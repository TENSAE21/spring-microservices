package com.tensae.app.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud") //same as value="fraud" but is important to name it!
public interface FraudClient {
    //this interface represents the fraud controller - the service to be queried
    @GetMapping(value = "/api/v1/fraud-check/{customerId}")
    FraudCheckResponse fraudCheck (@PathVariable("customerId") Integer customerId);
}
