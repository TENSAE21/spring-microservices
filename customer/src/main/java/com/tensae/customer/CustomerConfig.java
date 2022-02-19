package com.tensae.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    @Bean
    @LoadBalanced   // is to let restTemplate not be confused among the different instances it might encounter
                    // implements Round-Robin approach
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
