package com.qtt.bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Project name：bbsDesign
 * Class name：SwaggerConfig
 * description：TODO
 * date：2020/2/18 22:52
 *
 * @author ：XC
 */
@Configuration
public class SwaggerConfig {
    /**
     * 创建文档说明
     * @return
     */
    public ApiInfo createAI(){
        ApiInfo apiInfo=new ApiInfoBuilder().title("基于SpringBoot实现的bbs论坛数据接口").
                description("SpringBoot").
                contact(new Contact("Eudemonia","http://www.qtt.top","993519925@qq.com")).build();
        return apiInfo;
    }

    /**
     * 创建Swagger扫描信息
     * @return
     */
    @Bean
    public Docket createD(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createAI()).select().
                apis(RequestHandlerSelectors.basePackage("com.qtt.bbs.controller")).build();
    }
}
