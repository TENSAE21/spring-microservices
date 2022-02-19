package com.tensae.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
 //Notice ^^^                      ^^^^ instead of @Autowired           ^^^^^

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //So the customer will have a DB ID
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                //thanks to eureka http://localhost:8081/api/...  is replaced
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,   // return type
                customer.getId()            // input to the url
                );

        if(fraudCheckResponse.isFraudlentCustomer())
        {
            throw new IllegalStateException("Fraudulent Customer");
        }

    }
}
