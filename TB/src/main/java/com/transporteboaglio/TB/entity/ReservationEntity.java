package com.transporteboaglio.TB.entity;


import jakarta.persistence.*;


@Entity
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameofclient;

    private Integer numberofseats; // Cambiado a Integer para representar la cantidad de asientos

    @ManyToOne
    @JoinColumn(name = "screening_id") // Establece la relación con la entidad "Screening"
    private ScreeningEntity screening;

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

    public ScreeningEntity getScreening() {
        return screening;
    }

    public void setScreening(ScreeningEntity screening) {
        this.screening = screening;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReservationEntity() {
    }

    public ReservationEntity(String nameofclient, Integer numberofseats, ScreeningEntity screening, String status) {
        this.nameofclient = nameofclient;
        this.numberofseats = numberofseats;
        this.screening = screening;
        this.status = status;
    }
}
