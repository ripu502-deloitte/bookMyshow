package com.bookmyshow.bookmyshow.dto;

import com.bookmyshow.bookmyshow.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConcertDto {

    private Long concertId;
    private String name;
    private Long time;
    private Set<Transaction> registers;
}
