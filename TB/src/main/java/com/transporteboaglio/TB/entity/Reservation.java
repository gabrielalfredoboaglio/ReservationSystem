package com.transporteboaglio.TB.entity;


import jakarta.persistence.*;


@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameofclient;

    private Integer numberofseats; // Cambiado a Integer para representar la cantidad de asientos

    @ManyToOne
    @JoinColumn(name = "screening_id") // Establece la relación con la entidad "Screening"
    private Screening screening;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameofclient() {
        return nameofclient;
    }

    public void setNameofclient(String nameofclient) {
        this.nameofclient = nameofclient;
    }

    public Integer getNumberofseats() {
        return numberofseats;
    }

    public void setNumberofseats(Integer numberofseats) {
        this.numberofseats = numberofseats;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reservation() {
    }

    public Reservation(String nameofclient, Integer numberofseats, Screening screening, String status) {
        this.nameofclient = nameofclient;
        this.numberofseats = numberofseats;
        this.screening = screening;
        this.status = status;
    }
}
