package com.tensae.customer;

import com.tensae.app.clients.fraud.FraudCheckResponse;
import com.tensae.app.clients.fraud.FraudClient;
import org.springframework.stereotype.Service;

@Service
//public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
 //Notice ^^^                      ^^^^ instead of @Autowired           ^^^^^

public record CustomerService(CustomerRepository customerRepository, FraudClient fraudClient) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

    // REST TEMPLATE IMPLEMENTATION
        //So the customer will have a DB ID

//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                //thanks to eureka http://localhost:8081/api/...  is replaced
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,   // return type
//                customer.getId()            // input to the url
//                );


    // OpenFeign Implementation
        FraudCheckResponse fraudCheckResponse = fraudClient.fraudCheck(customer.getId());

        if(fraudCheckResponse.isFraudlentCustomer())
        {
            throw new IllegalStateException("Fraudulent Customer");
        }

    }
}
