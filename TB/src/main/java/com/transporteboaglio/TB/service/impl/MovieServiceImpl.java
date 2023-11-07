package com.transporteboaglio.TB.service.impl;

import com.transporteboaglio.TB.entity.MovieEntity;
import com.transporteboaglio.TB.repository.MovieRepository;
import com.transporteboaglio.TB.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieEntity> listMovies() {
        return movieRepository.findAll();
    }

    @Override
    public MovieEntity getMovieById(Long id) {
        Optional<MovieEntity> movieOptional = movieRepository.findById(id);
        return movieOptional.orElse(null);
    }

    @Override
    public MovieEntity createMovie(MovieEntity movie) {
        return movieRepository.save(movie);
    }

    @Override
    public MovieEntity updateMovie(Long id, MovieEntity movie) {
        if (movieRepository.existsById(id)) {
            movie.setId(id);
            return movieRepository.save(movie);
        }
        return null;
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}

