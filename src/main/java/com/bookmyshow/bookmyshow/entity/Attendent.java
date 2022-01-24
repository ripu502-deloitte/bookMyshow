package com.bookmyshow.bookmyshow.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendent {

    @Id
    @GeneratedValue
    private Long userId;

    @Column(unique=true)
    private String email;

    @OneToMany(mappedBy = "attendent")
    private Set<Transaction> concerts;

}
