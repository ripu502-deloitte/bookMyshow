package com.bookmyshow.bookmyshow.repository;

import com.bookmyshow.bookmyshow.entity.Attendent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendentRepository extends JpaRepository<Attendent, Long> {
    Attendent findByEmail(String email);
}
