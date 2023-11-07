package com.transporteboaglio.TB.service.impl;

import com.transporteboaglio.TB.entity.ScreeningEntity;
import com.transporteboaglio.TB.repository.ScreeningRepository;
import com.transporteboaglio.TB.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreeningServiceImpl implements ScreeningService {
    @Autowired
    private ScreeningRepository screeningRepository;


    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @Override
    public List<ScreeningEntity> listScreenings() {
        return screeningRepository.findAll();
    }

    @Override
    public ScreeningEntity getScreeningById(Long id) {
        Optional<ScreeningEntity> optionalScreening = screeningRepository.findById(id);
        return optionalScreening.orElse(null);
    }

    @Override
    public ScreeningEntity createScreening(ScreeningEntity screening) {
        return screeningRepository.save(screening);
    }

    @Override
    public ScreeningEntity updateScreening(Long id, ScreeningEntity screening) {
        Optional<ScreeningEntity> optionalScreening = screeningRepository.findById(id);
        if (optionalScreening.isPresent()) {
            screening.setId(id);
            return screeningRepository.save(screening);
        }
        return null;
    }

    @Override
    public void deleteScreening(Long id) {
        screeningRepository.deleteById(id);
    }
}

