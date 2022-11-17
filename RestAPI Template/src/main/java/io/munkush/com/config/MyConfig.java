package io.munkush.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("io.munkush.com")
public class MyConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
