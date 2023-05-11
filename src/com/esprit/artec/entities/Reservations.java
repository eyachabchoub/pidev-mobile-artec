/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.artec.entities;

/**
 *
 * @author eyach
 */
public class Reservations {

    private int idRes, idUser, idEvent;
    private String date;
    private float prixr;
    private boolean payer;
    String nomGalerie;
    String descriptionGalerie;

    public String getNomGalerie() {
        return nomGalerie;
    }

    public void setNomGalerie(String nomGalerie) {
        this.nomGalerie = nomGalerie;
    }

    public String getDescriptionGalerie() {
        return descriptionGalerie;
    }

    public void setDescriptionGalerie(String descriptionGalerie) {
        this.descriptionGalerie = descriptionGalerie;
    }

    public Reservations(int idRes, int idUser, int idEvent, String date, float prixr, boolean payer) {
        this.idRes = idRes;
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.date = date;
        this.prixr = prixr;
        this.payer = payer;
    }

    public Reservations(int idUser, int idEvent, String date, float prixr, boolean payer) {
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.date = date;
        this.prixr = prixr;
        this.payer = payer;
    }

    public Reservations() {
    }

    public int getIdRes() {
        return idRes;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPrixr() {
        return prixr;
    }

    public void setPrixr(float prixr) {
        this.prixr = prixr;
    }

    public boolean isPayer() {
        return payer;
    }

    public void setPayer(boolean payer) {
        this.payer = payer;
    }

}
