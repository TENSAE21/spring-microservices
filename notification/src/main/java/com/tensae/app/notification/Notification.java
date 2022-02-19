package com.tensae.app.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j      //logging
@Entity    // JPA
@Builder  // Notification.builder().message("").build
@Data   //getters and setters
public class Notification {

    @Id
    @SequenceGenerator(name="notification_sequence_generator", sequenceName = "notification_sequence_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_sequence_generator")

    private Integer id;
    private String message;
    private LocalDateTime notifiedAt;
    private String toEmail;
    private Integer customerId;

}
