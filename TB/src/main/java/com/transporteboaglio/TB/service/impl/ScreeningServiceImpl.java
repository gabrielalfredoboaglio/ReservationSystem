package com.transporteboaglio.TB.service.impl;

import com.transporteboaglio.TB.entity.Screening;
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
    public List<Screening> listScreenings() {
        return screeningRepository.findAll();
    }

    @Override
    public Screening getScreeningById(Long id) {
        Optional<Screening> optionalScreening = screeningRepository.findById(id);
        return optionalScreening.orElse(null);
    }

    @Override
    public Screening createScreening(Screening screening) {
        return screeningRepository.save(screening);
    }

    @Override
    public Screening updateScreening(Long id, Screening screening) {
        Optional<Screening> optionalScreening = screeningRepository.findById(id);
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

