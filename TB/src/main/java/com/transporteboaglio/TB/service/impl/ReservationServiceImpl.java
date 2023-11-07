package com.transporteboaglio.TB.service.impl;

import com.transporteboaglio.TB.entity.ReservationEntity;
import com.transporteboaglio.TB.repository.ReservationRepository;
import com.transporteboaglio.TB.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private  ReservationRepository reservationRepository;

    @Override
    public List<ReservationEntity> listReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public ReservationEntity getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public ReservationEntity createReservation(ReservationEntity reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public ReservationEntity updateReservation(Long id, ReservationEntity reservation) {
        ReservationEntity existingReservation = reservationRepository.findById(id).orElse(null);
        if (existingReservation != null) {
            reservation.setId(id);
            return reservationRepository.save(reservation);
        }
        return null;
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}

