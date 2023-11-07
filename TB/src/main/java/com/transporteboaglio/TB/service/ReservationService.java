package com.transporteboaglio.TB.service;

import com.transporteboaglio.TB.entity.ReservationEntity;

import java.util.List;

public interface ReservationService {
    List<ReservationEntity> listReservations();
    ReservationEntity getReservationById(Long id);
    ReservationEntity createReservation(ReservationEntity reservation);
    ReservationEntity updateReservation(Long id, ReservationEntity reservation);
    void deleteReservation(Long id);
}

