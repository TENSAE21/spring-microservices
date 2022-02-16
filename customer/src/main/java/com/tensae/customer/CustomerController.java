package com.tensae.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void addCustomer(@RequestBody CustomerRegistrationRequest request){
        log.info("Incoming customer Request {}", request);
        customerService.registerCustomer(request);
    }
}
