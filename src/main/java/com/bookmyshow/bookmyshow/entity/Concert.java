package com.bookmyshow.bookmyshow.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Concert {

    @Id
    @GeneratedValue
    private Long concertId;

    private String name;

    private Long time;

    @OneToMany(mappedBy = "concert")
    private Set<Transaction> registers;
}
