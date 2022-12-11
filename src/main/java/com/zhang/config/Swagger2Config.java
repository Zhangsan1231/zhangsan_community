package com.zhang.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//生产环境关闭sawgger-ui
@Profile("!prod")
public class Swagger2Config {
//    显示controller层的所有信息
     @Bean
     public Docket api(){
         return new Docket(DocumentationType.SWAGGER_2)
                 .apiInfo(getApiInfo())
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("com.zhang.controller"))
                 .paths(PathSelectors.any())
                 .build();
     }
     private ApiInfo getApiInfo(){
         return new ApiInfoBuilder()
                 .title("Swagger2") //文档标题
                 .description("Swagger2")   //文档描述
                 .version("1.0")    //版本
                 .license("预留在线测试（暂时跳转百度）") //许可
                 .licenseUrl("www.baidu.com")  //许可链接
                 //服务条款网址
                 .termsOfServiceUrl("www.spring.io")
                 //维护人信息
                 .contact(new Contact("zhangsan","www.zjs.com","2950909451@qq.com"))
                 .build();
     }
}