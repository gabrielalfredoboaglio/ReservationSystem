package com.transporteboaglio.TB.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startTime; // Fecha y hora de inicio de la función

    @ManyToOne
    @JoinColumn(name = "movie_id") // Establece la relación con la entidad "Movie"
    private Movie movie; // Una función pertenece a una película

    @ManyToOne
    @JoinColumn(name = "theater_id") // Establece la relación con la entidad "Theater"
    private Theater theater; // Una función se realiza en una sala de cine

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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Screening() {
    }

    public Screening(Date startTime, Movie movie, Theater theater, double price) {
        this.startTime = startTime;
        this.movie = movie;
        this.theater = theater;
        this.price = price;
    }
}

