package com.bookmyshow.bookmyshow.service;

import com.bookmyshow.bookmyshow.entity.Attendent;

import java.util.List;

public interface TransactionService {

    public void registerUserToConcert(Long concertId, String attendentEmail);

    public List<Attendent> getUsersWithStatus(Long concertId, String status);
}
