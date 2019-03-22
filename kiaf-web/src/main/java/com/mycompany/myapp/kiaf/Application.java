package com.mycompany.myapp.kiaf;

import com.kedacom.kidp.base.data.config.ElasticsearchAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author kedacom
 * @date 2018-11-16
 */
@SpringBootApplication(exclude = {ElasticsearchAutoConfiguration.class, ElasticsearchAutoConfig.class, ElasticsearchDataAutoConfiguration.class}, scanBasePackages = {"com.mycompany.myapp.kiaf"})
@EnableSwagger2
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(Application.class);
    }
}
