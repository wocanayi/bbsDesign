package com.qtt.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author XC
 */
@SpringBootApplication
@MapperScan("com.qtt.bbs.dao.forum, com.qtt.bbs.dao.ribon")
@EnableSwagger2
public class BbsDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbsDesignApplication.class, args);
        System.out.println("别担心这担心那，什么也没干！！");
    }

}
