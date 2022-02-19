package com.tensae.fraud;

import com.tensae.app.clients.notification.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {
    @Autowired
    FraudCheckHistoryRepository fraudCheckHistoryRepository;


    public boolean isCustomerFraud(Integer customerId){
        /* TODO: check if customer is Fraud with some logic */
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                .build()
        );


        return false;
    }


}
