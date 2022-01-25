package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.entity.Attendent;
import com.bookmyshow.bookmyshow.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/concerts/{concertId}/attendent")
    public ResponseEntity<List<Attendent>> getUsersWithStatus(@PathVariable(name = "concertId") Long concertId,
                                                              @RequestParam(name = "status", defaultValue = "Success", required = false) String status)
    {
        return new ResponseEntity<>(transactionService.getUsersWithStatus(concertId, status), HttpStatus.OK);
    }
}
