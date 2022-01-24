package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.dto.ConcertDto;
import com.bookmyshow.bookmyshow.service.ConcertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/concerts")
public class ConcertController {

    private ConcertService concertService;

    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    @PostMapping
    public ResponseEntity<ConcertDto> createConcert(@RequestBody ConcertDto concertDto){
        return new ResponseEntity<>(concertService.createConcert(concertDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ConcertDto> getConcertDetails(@PathVariable(name = "id") Long id)
    {
        return new ResponseEntity<>(concertService.getConcertDetails(id), HttpStatus.OK);
    }

}
