package com.bookmyshow.bookmyshow.entity;

import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendent {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;

    @Column(unique=true)
    private String email;

    @OneToMany(mappedBy = "attendent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> concerts = new HashSet<>();

}
