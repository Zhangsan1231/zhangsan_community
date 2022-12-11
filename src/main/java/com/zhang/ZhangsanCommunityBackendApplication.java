package com.zhang;

import com.zhang.jwt.JwtAuthenticationFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.zhang.mapper")//自动扫描mapper文件
@SpringBootApplication
public class ZhangsanCommunityBackendApplication {


    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ZhangsanCommunityBackendApplication.class);
    }
    @Bean
    public FilterRegistrationBean jwtFilter() {
//        用来注册我们的FilterRegistrationBean
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
//        jwt过滤器运用
        registrationBean.setFilter(filter);
        return registrationBean;
    }


    public static void main(String[] args) {
        SpringApplication.run(ZhangsanCommunityBackendApplication.class, args);
    }

}
