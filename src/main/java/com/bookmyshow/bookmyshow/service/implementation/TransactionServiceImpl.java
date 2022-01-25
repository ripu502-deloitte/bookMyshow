package com.bookmyshow.bookmyshow.service.implementation;

import com.bookmyshow.bookmyshow.entity.Attendent;
import com.bookmyshow.bookmyshow.entity.Concert;
import com.bookmyshow.bookmyshow.entity.Transaction;
import com.bookmyshow.bookmyshow.exception.ResourceNotFoundException;
import com.bookmyshow.bookmyshow.repository.AttendentRepository;
import com.bookmyshow.bookmyshow.repository.ConcertRepository;
import com.bookmyshow.bookmyshow.repository.TransactionRepository;
import com.bookmyshow.bookmyshow.service.AttendentService;
import com.bookmyshow.bookmyshow.service.ConcertService;
import com.bookmyshow.bookmyshow.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private ModelMapper mapper;
    private TransactionRepository transactionRepository;
    private ConcertRepository concertRepository;
    private AttendentRepository attendentRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  ModelMapper mapper,
                                  ConcertRepository concertRepository,
                                  AttendentRepository attendentRepository) {
        this.transactionRepository = transactionRepository;
        this.mapper = mapper;
        this.attendentRepository = attendentRepository;
        this.concertRepository = concertRepository;
    }

    @Override
    public void registerUserToConcert(Long concertId, String attendentEmail) {
        Concert concert = concertRepository.findById(concertId).orElseThrow(() -> new ResourceNotFoundException("Concert", "id", concertId));
        Attendent attendent = attendentRepository.findByEmail(attendentEmail);

        if(attendent == null) {
            throw new ResourceNotFoundException("Attendant", "id", attendentEmail);
        }

        Transaction transaction = new Transaction();
        transaction.setConcert(concert);
        transaction.setAttendent(attendent);
        transaction.setStatus("Success");

        transactionRepository.save(transaction);
    }

    @Override
    public List<Attendent> getUsersWithStatus(Long concertId, String status) {
       return attendentRepository.getListOfUserWithPaymentStatus(status, concertId);
    }
}
