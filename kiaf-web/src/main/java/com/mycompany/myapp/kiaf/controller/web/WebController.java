package com.mycompany.myapp.kiaf.controller.web;

import com.kedacom.ctsp.web.controller.message.ResponseMessage;
import com.mycompany.myapp.kiaf.entity.Cinema;
import com.mycompany.myapp.kiaf.entity.Film;
import com.mycompany.myapp.kiaf.entity.User;
import com.mycompany.myapp.kiaf.service.*;
import com.mycompany.myapp.kiaf.utils.Const;
import com.mycompany.myapp.kiaf.utils.EmptyUtils;
import com.mycompany.myapp.kiaf.utils.VOUtils;
import com.mycompany.myapp.kiaf.vo.CinemaVO;
import com.mycompany.myapp.kiaf.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by keda on 2019/3/21.
 */
@RestController
@RequestMapping("/filmweb")
public class WebController {
    @Autowired
    private UserService userService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private BillService billService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CinemaService cinemaService;

    /*@GetMapping("/getuser")
    public UserVO getUser(Long id) {
        User user = userService.findById(id);
         UserVO userVO = new UserVO();
        userVO = (UserVO) VOUtils.populate(user, userVO);
        return userVO;

    }*/

    @PostMapping("/login")//小型登录测试
    public ResponseMessage login( String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
            session.setAttribute(Const.CURRENT_USER, user);
            System.out.println("登陆成功！！！");
            return ResponseMessage.ok(user.getName()+"登录成功");
        }
        return ResponseMessage.error("用户或名密码错误");
    }

    @PostMapping("/buyfilm")//按影片Id购买影片（传入影片Id）
    public ResponseMessage buyFilm(Long id, HttpSession session) {
        UserVO userVO = new UserVO();
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ResponseMessage.error("用户未登录");
        }//登录验证模块，以后按照登录模块内容改
        Film film = filmService.findById(id);
        if(user.getBalance().compareTo(film.getPrice())==-1){//价格比较
            return ResponseMessage.error("账户余额不足！");
        }else{
            BigDecimal balance=user.getBalance().subtract(film.getPrice());//做减法
            Boolean result = userService.updateUserAndBillAndOrder(balance,user.getId(),
                    film.getPrice(),film.getId(),film.getName());//更新个人账户余额、保存个人账单（消费记录）、保存个人订单记录
            if(result) {
                return ResponseMessage.ok("购买成功！");
            }else{
                return ResponseMessage.error("购买失败！");
            }
        }
    }
    @PostMapping("/recharge")//按影片Id购买影片（传入影片Id）
    public ResponseMessage recharge(BigDecimal amount, HttpSession session) {
        User sessionUser = (User) session.getAttribute(Const.CURRENT_USER);
                if (sessionUser == null) {
            return ResponseMessage.error("用户未登录");
        }//登录验证模块，以后按照登录模块内容改
        User user = userService.findById(sessionUser.getId());
        System.out.println("用户原先余额"+user.getBalance());
        BigDecimal balance =(user.getBalance()).add(amount);
        Boolean result = userService.updateBalance(amount ,balance,user.getId());
        if(result){
           return ResponseMessage.ok("充值成功");
        }
        return ResponseMessage.error("充值失败");

}
@GetMapping("/search_cinemalist_by_district")//按区域搜索电影院列表(传入区域名称)
    public ResponseMessage searchCinemaListByDistrict( String district) {
        return ResponseMessage.ok(cinemaService.findAllByDistrict(district));
    }
    @GetMapping("/search_cinema_detail")//搜索影片细节(传入影院Id)
    public ResponseMessage searchCinemaDetials(Long id){
        CinemaVO cinemaVO= cinemaService.findDetail(id);
        if(EmptyUtils.isEmpty(cinemaVO)){
            return ResponseMessage.error("未找到相关影院");
        }
        return ResponseMessage.ok(cinemaVO);
    }
}
