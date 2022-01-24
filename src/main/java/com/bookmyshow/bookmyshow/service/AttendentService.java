package com.bookmyshow.bookmyshow.service;

import com.bookmyshow.bookmyshow.dto.AttendentDto;

public interface AttendentService {

    public AttendentDto createAttentdent(AttendentDto attendentDto);

    public  AttendentDto getAttentdentDetailByEmail(String email);
}
