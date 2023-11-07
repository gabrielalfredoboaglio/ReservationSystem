package com.transporteboaglio.TB.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ScreeningEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startTime; // Fecha y hora de inicio de la función
    private Integer availableSeats;

    @ManyToOne
    @JoinColumn(name = "movie_id") // Establece la relación con la entidad "Movie"
    private MovieEntity movie; // Una función pertenece a una película

    @ManyToOne
    @JoinColumn(name = "theater_id") // Establece la relación con la entidad "Theater"
    private TheaterEntity theater; // Una función se realiza en una sala de cine

    private double price; // Precio de la función

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public TheaterEntity getTheater() {
        return theater;
    }

    public void setTheater(TheaterEntity theater) {
        this.theater = theater;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ScreeningEntity() {
    }

    public ScreeningEntity(Long id, Date startTime, Integer availableSeats, MovieEntity movie, TheaterEntity theater, double price) {
        this.id = id;
        this.startTime = startTime;
        this.availableSeats = availableSeats;
        this.movie = movie;
        this.theater = theater;
        this.price = price;
    }
}

