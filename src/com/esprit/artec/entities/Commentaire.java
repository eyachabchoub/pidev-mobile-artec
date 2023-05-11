/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.artec.entities;

/**
 *
 * @author Asus
 */
public class Commentaire {
     private int idComm;
     private String date,text;

    public Commentaire() {
    }

    public Commentaire(int idComm, String date, String text) {
        this.idComm = idComm;
        this.date = date;
        this.text = text;
    }

    public Commentaire(String date, String text) {
        this.date = date;
        this.text = text;
    }

    public int getIdComm() {
        return idComm;
    }

    public void setIdComm(int idComm) {
        this.idComm = idComm;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
