package com.bookmyshow.bookmyshow.repository;

import com.bookmyshow.bookmyshow.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

    @Query(value = "select concert_id , \"name\",  \"time\" from concert c where c.\"time\"  < EXTRACT(EPOCH FROM DATE_TRUNC('seconds' , now())) and c.concert_id in " +
            "(select t.concert_id from \"transaction\" t where t.user_id = :userId)\n", nativeQuery = true)
    List<Concert> getListOfConcertInPastForUser(@Param("userId") Long userId);

    @Query(value = "select concert_id , \"name\",  \"time\" from concert c where c.\"time\"  > EXTRACT(EPOCH FROM DATE_TRUNC('seconds' , now())) and c.concert_id in " +
            "(select t.concert_id from \"transaction\" t where t.user_id = :userId)\n", nativeQuery = true)
    List<Concert> getListOfConcertInFutureForUser(@Param("userId") Long userId);
}
