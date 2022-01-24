package com.bookmyshow.bookmyshow.service.implementation;

import com.bookmyshow.bookmyshow.dto.AttendentDto;
import com.bookmyshow.bookmyshow.entity.Attendent;
import com.bookmyshow.bookmyshow.exception.ResourceNotFoundException;
import com.bookmyshow.bookmyshow.repository.AttendentRepository;
import com.bookmyshow.bookmyshow.service.AttendentService;
import org.springframework.stereotype.Service;

@Service
public class AttendentServiceImpl implements AttendentService {

    private AttendentRepository attendentRepository;

    public AttendentServiceImpl(AttendentRepository attendentRepository) {
        this.attendentRepository = attendentRepository;
    }

    @Override
    public AttendentDto createAttentdent(AttendentDto attendentDto) {

        Attendent attendent = mapToEntity(attendentDto);
        Attendent newAttendent = attendentRepository.save(attendent);
        AttendentDto response = mapToDto(newAttendent);
        return response;
    }

    @Override
    public AttendentDto getAttentdentDetailByEmail(String email) {
        Attendent attendent = attendentRepository.findByEmail(email);
        if(attendent == null) {
            throw new ResourceNotFoundException("Attendant", "id", email);
        }
        return mapToDto(attendent);
    }

    private AttendentDto mapToDto(Attendent newAttendent) {
        AttendentDto response = new AttendentDto();
        response.setEmail(newAttendent.getEmail());
        response.setUserId(newAttendent.getUserId());
        return response;
    }

    private Attendent mapToEntity(AttendentDto attendentDto) {
        Attendent attendent = new Attendent();
        attendent.setEmail(attendentDto.getEmail());
        return attendent;
    }
}
