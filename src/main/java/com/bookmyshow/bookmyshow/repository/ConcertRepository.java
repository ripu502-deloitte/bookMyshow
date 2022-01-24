package com.bookmyshow.bookmyshow.repository;

import com.bookmyshow.bookmyshow.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
}
