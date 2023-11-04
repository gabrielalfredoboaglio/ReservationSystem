package com.transporteboaglio.TB.repository;



import com.transporteboaglio.TB.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
