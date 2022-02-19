package com.tensae.app.notification;

import com.tensae.app.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/notification")
@Slf4j
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    //done_todo: make this into postMapping with a request body - have the other service send an object
    @GetMapping(value = "/{customerId}/{email}")
    public Boolean notify(@PathVariable ("customerId") Integer customerID, @PathVariable ("email") String email ){
        log.info("In Notification controller");
         return notificationService.saveNotification(customerID, email);
    }

    @PostMapping
    public Boolean notifyCustomer(@RequestBody NotificationRequest notificationRequest){
        log.info("In Notification controller");
        return notificationService.saveNotification(notificationRequest);
    }



}
