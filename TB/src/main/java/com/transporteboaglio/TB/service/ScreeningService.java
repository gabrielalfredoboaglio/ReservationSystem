package com.transporteboaglio.TB.service;

import com.transporteboaglio.TB.entity.ScreeningEntity;

import java.util.List;

public interface ScreeningService {
    List<ScreeningEntity> listScreenings();
    ScreeningEntity getScreeningById(Long id);
    ScreeningEntity createScreening(ScreeningEntity screening);
    ScreeningEntity updateScreening(Long id, ScreeningEntity screening);
    void deleteScreening(Long id);
}