package com.bookmyshow.bookmyshow.service.implementation;

import com.bookmyshow.bookmyshow.dto.ConcertDto;
import com.bookmyshow.bookmyshow.entity.Concert;
import com.bookmyshow.bookmyshow.repository.ConcertRepository;
import com.bookmyshow.bookmyshow.service.ConcertService;
import org.springframework.stereotype.Service;

@Service
public class ConcertServiceImpl implements ConcertService {

    private ConcertRepository concertRepository;

    public ConcertServiceImpl(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    @Override
    public ConcertDto createConcert(ConcertDto concertDto) {

        Concert concert = new Concert();
        concert.setName(concertDto.getName());
        concert.setTime(concertDto.getTime());
        Concert newConcert = concertRepository.save(concert);

        ConcertDto response = new ConcertDto();

        response.setName(newConcert.getName());
        response.setConcertId(newConcert.getConcertId());
        response.setTime(newConcert.getTime());
        response.setRegisters(newConcert.getRegisters());

        return response;
    }
}
