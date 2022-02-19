package com.tensae.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
    private Integer id;
    private Integer customerId;
    private boolean isFraudster;
    private LocalDateTime createdAt;
}
