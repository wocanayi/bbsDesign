package com.qtt.bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Project name：bbsDesign
 * Class name：RestConfig
 * description：TODO
 * date：2020/2/21 21:00
 *
 * @author ：XC
 */
@Configuration
public class RestConfig {

    @Bean
    public RestTemplate createRT() {
        return new RestTemplate();
    }
}
