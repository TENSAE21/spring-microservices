package com.tensae.app.clients.notification;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {

    @GetMapping("/api/v1/notification/{customerId}")
    Boolean notify(@PathVariable("customerId") Integer customerID);

    @PostMapping("/api/v1/notification")
    Boolean notifyCustomer(@RequestBody NotificationRequest notificationRequest);
}
