package com.tensae.app.notification;

import com.tensae.app.clients.notification.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public boolean saveNotification(Integer customerId, String customerEmail){
        Notification notification =Notification.builder()
                                        .message("notified " + customerId)
                                        .customerId(customerId)
                                        .notifiedAt(LocalDateTime.now())
                                        .build();

       notificationRepository.saveAndFlush(notification);
       return notification.getId() != null; // successfully saved or not??
    }


    public boolean saveNotification(NotificationRequest notificationRequest){
        Notification notification = Notification.builder()
                        .message("Welcome " + notificationRequest.firstName())
                        .notifiedAt(LocalDateTime.now())
                        .toEmail(notificationRequest.email())
                        .build();
        notificationRepository.saveAndFlush(notification);
        return notification.getId() != null;

    }



}
