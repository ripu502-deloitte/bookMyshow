package com.bookmyshow.bookmyshow.service;

import com.bookmyshow.bookmyshow.dto.ConcertDto;
import com.bookmyshow.bookmyshow.entity.Concert;

import java.util.List;

public interface ConcertService {

    ConcertDto createConcert(ConcertDto concertDto);

    ConcertDto getConcertDetails(Long id);

    List<Concert> getConcertsForTheUser(Long userId, String dir);
}
