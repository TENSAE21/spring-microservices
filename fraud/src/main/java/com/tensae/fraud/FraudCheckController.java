package com.tensae.fraud;

import com.tensae.app.clients.fraud.FraudCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/fraud-check")
@Slf4j
public class FraudCheckController {

    @Autowired
    FraudCheckService fraudCheckService;

    @GetMapping(value = "/{customerId}")
    public FraudCheckResponse fraudCheck (@PathVariable("customerId") Integer customerId){
        log.info("customer registration request with " + customerId);
        boolean isFraud = fraudCheckService.isCustomerFraud(customerId);
        return new FraudCheckResponse(isFraud);
    }

}
