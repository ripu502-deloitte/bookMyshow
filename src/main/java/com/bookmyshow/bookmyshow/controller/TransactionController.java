package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/concerts/{concertId}/attendents/{attendentEmail}")
    public ResponseEntity<String> registerUserToConcert(@PathVariable(name = "concertId") Long concertId,
                                                        @PathVariable(name = "attendentEmail") String attendentEmail)
    {
        transactionService.registerUserToConcert(concertId, attendentEmail);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
