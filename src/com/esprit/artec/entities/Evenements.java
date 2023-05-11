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
public class Evenements {

    public Evenements() {

    }

    public enum Categorie_gal {
        artContemporain,
        artModerne,
        PopArt,
        opArt
    }
    private int idEvent, nombrePart, nombrePartRest, prix, idRes, idOeuvre;

    public Evenements(int idEvent, int nombrePart, int nombrePartRest, int prix, int idRes, int idOeuvre, String nomGalerie, String descriptionGalerie, String dateGal, Categorie_gal categ_gal) {
        this.idEvent = idEvent;
        this.nombrePart = nombrePart;
        this.nombrePartRest = nombrePartRest;
        this.prix = prix;
        this.idRes = idRes;
        this.idOeuvre = idOeuvre;
        this.nomGalerie = nomGalerie;
        this.descriptionGalerie = descriptionGalerie;
        this.dateGal = dateGal;
        this.categ_gal = categ_gal;
    }
    private String nomGalerie, descriptionGalerie, dateGal;
    private Categorie_gal categ_gal;
    private String categGal;

    public Evenements(int nombrePart, int nombrePartRest, int prix, int idRes, int idOeuvre, String nomGalerie, String descriptionGalerie, String dateGal, Categorie_gal categ_gal) {
        this.nombrePart = nombrePart;
        this.nombrePartRest = nombrePartRest;
        this.prix = prix;
        this.idRes = idRes;
        this.idOeuvre = idOeuvre;
        this.nomGalerie = nomGalerie;
        this.descriptionGalerie = descriptionGalerie;
        this.dateGal = dateGal;
        this.categ_gal = categ_gal;
    }

    public String getCategGal() {
        return categGal;
    }

    public void setCategGal(String categGal) {
        this.categGal = categGal;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getNombrePart() {
        return nombrePart;
    }

    public void setNombrePart(int nombrePart) {
        this.nombrePart = nombrePart;
    }

    public int getNombrePartRest() {
        return nombrePartRest;
    }

    public void setNombrePartRest(int nombrePartRest) {
        this.nombrePartRest = nombrePartRest;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getIdRes() {
        return idRes;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    public int getIdOeuvre() {
        return idOeuvre;
    }

    public void setIdOeuvre(int idOeuvre) {
        this.idOeuvre = idOeuvre;
    }

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

    public String getDateGal() {
        return dateGal;
    }

    public void setDateGal(String dateGal) {
        this.dateGal = dateGal;
    }

    public Categorie_gal getCateg_gal() {
        return categ_gal;
    }

    public void setCateg_gal(Categorie_gal categ_gal) {
        this.categ_gal = categ_gal;
    }

}
