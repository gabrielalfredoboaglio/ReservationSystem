package com.transporteboaglio.TB.service;

import com.transporteboaglio.TB.entity.Screening;

import java.util.List;

public interface ScreeningService {
    List<Screening> listScreenings();
    Screening getScreeningById(Long id);
    Screening createScreening(Screening screening);
    Screening updateScreening(Long id, Screening screening);
    void deleteScreening(Long id);
}