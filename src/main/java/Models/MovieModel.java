package Models;

import java.util.UUID;

public class MovieModel {
    private String autor, nume, continut, key;
    private ReservationState reservationState;

    public MovieModel(String autor, String nume, String continut, ReservationState reservationState) {
        this.autor = autor;
        this.nume = nume;
        this.continut = continut;
        this.key = UUID.randomUUID().toString();
        this.reservationState = reservationState;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ReservationState getReservationState() {
        return reservationState;
    }

    public void setReservationState(ReservationState reservationState) {
        this.reservationState = reservationState;
    }
}
