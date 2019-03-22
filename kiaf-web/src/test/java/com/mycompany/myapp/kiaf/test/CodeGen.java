package com.mycompany.myapp.kiaf.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.kedacom.kidp.base.codegen.CodeGenerator;
import com.kedacom.kidp.base.codegen.DefaultNameStrategy;
import com.kedacom.kidp.base.codegen.DefaultTypeMapping;
import com.kedacom.kidp.base.data.DataConstant;
import org.junit.Test;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wanggang on 2019/3/15.
 */
public class CodeGen {
    @Test
    public void generate() throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("exercise");
        dataSource.setPassword("Pass!234");
        dataSource.setUrl("jdbc:mysql://localhost:3306/exercise?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        CodeGenerator codeGenerator = new CodeGenerator().setDataSource(dataSource)
                .setAuthor("kedacom").setNow(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .setBasePackage("com.mycompany.myapp")
                .setWebBasePackage("com.mycompany.myapp").setServiceProjectName("kiaf-web")
                .setModule("kiaf").setEntityPackage("entity").setRepositoryPackage("dao")
                .setNameStrategy(new DefaultNameStrategy("", "", new DefaultTypeMapping()))
                .setSuperEntity("com.kedacom.kidp.base.data.common.entity.BaseEntity")
                .setSuperRepository("com.kedacom.kidp.base.data.common.repository.BaseJpaRepository")
                .setSuperService("com.kedacom.kidp.base.data.common.service.BaseService")
                .setSuperServiceImpl("com.kedacom.kidp.base.data.common.service.impl.BaseServiceImpl")
                .setEscapeColumns(DataConstant.DEFAULT_AUDIT_TABLE_FIELDS_NAME)
                .setOverwritten(true);
        codeGenerator.generate("test");
    }

}
