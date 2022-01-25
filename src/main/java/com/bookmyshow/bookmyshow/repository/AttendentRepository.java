package com.bookmyshow.bookmyshow.repository;

import com.bookmyshow.bookmyshow.entity.Attendent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendentRepository extends JpaRepository<Attendent, Long> {
    Attendent findByEmail(String email);

    @Query(value = "select a.user_id , a.email from attendent a join \"transaction\" t ON a.user_id = t.user_id where t.status = :status  and t.concert_id = :concertId " +
            "group by a.user_id", nativeQuery = true)
    List<Attendent> getListOfUserWithPaymentStatus(@Param("status") String status, @Param("concertId") Long concertId);

}
