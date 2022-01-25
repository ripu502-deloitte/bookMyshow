package com.bookmyshow.bookmyshow.dto;

import com.bookmyshow.bookmyshow.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendentDto {

    private Long userId;
    private String email;
    private Set<Transaction> concerts;
}
