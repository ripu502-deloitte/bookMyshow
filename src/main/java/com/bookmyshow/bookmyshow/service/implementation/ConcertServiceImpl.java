package com.bookmyshow.bookmyshow.service.implementation;

import com.bookmyshow.bookmyshow.controller.EpochConverterProxy;
import com.bookmyshow.bookmyshow.dto.ConcertDto;
import com.bookmyshow.bookmyshow.dto.EpochResponse;
import com.bookmyshow.bookmyshow.entity.Concert;
import com.bookmyshow.bookmyshow.exception.ResourceNotFoundException;
import com.bookmyshow.bookmyshow.repository.ConcertRepository;
import com.bookmyshow.bookmyshow.service.ConcertService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertServiceImpl implements ConcertService {

    private ConcertRepository concertRepository;
    private ModelMapper mapper;
    private EpochConverterProxy proxy;


    public ConcertServiceImpl(ConcertRepository concertRepository,
                              ModelMapper mapper,
                              EpochConverterProxy proxy) {
        this.concertRepository = concertRepository;
        this.mapper = mapper;
        this.proxy = proxy;
    }

    @Override
    public ConcertDto createConcert(ConcertDto concertDto) {

        EpochResponse res = proxy.getEpochTimeAfterXdays(5).getBody();
        System.out.println("_________________________________");
        System.out.println(res.getPort());
        System.out.println("_________________________________");

        Concert newConcert = mapToEntity(concertDto);
        concertRepository.save(newConcert);
        ConcertDto response = mapToDto(newConcert);
        return response;
    }

    private ConcertDto mapToDto(Concert newConcert) {
        ConcertDto response = mapper.map(newConcert, ConcertDto.class);
        return response;
    }

    private Concert mapToEntity(ConcertDto concertDto) {
        Concert concert = mapper.map(concertDto, Concert.class);
        return concert;
    }

    @Override
    public ConcertDto getConcertDetails(Long id) {
        Concert concert = concertRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Concert", "id", id));
        return mapToDto(concert);
    }

    @Override
    public List<Concert> getConcertsForTheUser(Long userId, String dir) {
        if(dir.equals("past"))
        {
            return concertRepository.getListOfConcertInPastForUser(userId);
        }else{
            return concertRepository.getListOfConcertInFutureForUser(userId);
        }
    }
}
