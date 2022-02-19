package com.tensae.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/fraud-check")
public class FraudCheckController {

    @Autowired
    FraudCheckService fraudCheckService;

    @GetMapping(value = "/{customerId}")
    public FraudCheckResponse fraudCheck (@PathVariable("customerId") Integer customerId){
        boolean isFraud = fraudCheckService.isCustomerFraud(customerId);
        return new FraudCheckResponse(isFraud);
    }

}
