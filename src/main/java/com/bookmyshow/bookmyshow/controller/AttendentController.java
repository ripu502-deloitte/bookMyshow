package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.dto.AttendentDto;
import com.bookmyshow.bookmyshow.dto.ConcertDto;
import com.bookmyshow.bookmyshow.service.AttendentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/attendents")
public class AttendentController {

    AttendentService attendentService;

    public AttendentController(AttendentService attendentService) {
        this.attendentService = attendentService;
    }

    @PostMapping
    public ResponseEntity<AttendentDto> createUser(@RequestBody AttendentDto attentdentDto){
        return new ResponseEntity<>(attendentService.createAttentdent(attentdentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public  ResponseEntity<AttendentDto> getUserDetailsByEmail(@PathVariable(name = "email") String email)
    {
        return new ResponseEntity<>(attendentService.getAttentdentDetailByEmail(email), HttpStatus.OK);
    }
}
