package com.bookmyshow.bookmyshow.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    private Long transactionId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Attendent attendent;

    @ManyToOne
    @MapsId("concertId")
    @JoinColumn(name = "concert_id")
    private Concert concert;

    private String status;
}
