package com.transporteboaglio.TB.service;

import com.transporteboaglio.TB.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> listReservations();
    Reservation getReservationById(Long id);
    Reservation createReservation(Reservation reservation);
    Reservation updateReservation(Long id, Reservation reservation);
    void deleteReservation(Long id);
}

