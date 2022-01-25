package com.bookmyshow.bookmyshow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Attendent attendent;

    @ManyToOne
    @JoinColumn(name = "concert_id")
    @JsonIgnore
    private Concert concert;

    private String status;
}
