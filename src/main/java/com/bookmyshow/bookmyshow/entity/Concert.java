package com.bookmyshow.bookmyshow.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Concert {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long concertId;

    private String name;

    private Long time;

    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> registers  = new HashSet<>();
}
