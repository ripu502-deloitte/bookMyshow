package com.bookmyshow.bookmyshow.service.implementation;

import com.bookmyshow.bookmyshow.dto.ConcertDto;
import com.bookmyshow.bookmyshow.entity.Concert;
import com.bookmyshow.bookmyshow.exception.ResourceNotFoundException;
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

        Concert newConcert = mapToEntity(concertDto);
        concertRepository.save(newConcert);
        ConcertDto response = mapToDto(newConcert);
        return response;
    }

    private ConcertDto mapToDto(Concert newConcert) {
        ConcertDto response = new ConcertDto();

        response.setName(newConcert.getName());
        response.setConcertId(newConcert.getConcertId());
        response.setTime(newConcert.getTime());
        response.setRegisters(newConcert.getRegisters());
        return response;
    }

    private Concert mapToEntity(ConcertDto concertDto) {
        Concert concert = new Concert();
        concert.setName(concertDto.getName());
        concert.setTime(concertDto.getTime());
        return concert;
    }

    @Override
    public ConcertDto getConcertDetails(Long id) {
        Concert concert = concertRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Concert", "id", id));
        return mapToDto(concert);
    }
}
