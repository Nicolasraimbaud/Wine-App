package com.nicolas.catalogue_vins.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vins")
public class Vin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String annee;
    private String region;
    private Double prix;

    // Constructeurs
    public Vin() {
    }

    public Vin(String nom, String region, Double prix, String annee) {
        this.nom = nom;
        this.region = region;
        this.prix = prix;
        this.annee = annee;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
}
