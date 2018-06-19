package dev.model;

import org.hibernate.tuple.GeneratedValueGeneration;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
public class Mission {

    public enum Statue{
        INITIALE,
        EN_ATTENTE_VALIDATION,
        VALIDEE,
        REJETEE;
    }

    public enum Transport{
        Avion,
        Covoiturage,
        Train,
        Voiture_de_service;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateDeDebut;
    private LocalDate dateDeFin;
    @ManyToOne
    @JoinColumn(name = "NAT_ID")
    private Nature nature;
    private String VilleDeDepart;
    private String VilleDArrivee;
    private Transport transport;
    private Statue statue;

    public Mission(){

    }

    public Mission(LocalDate dateDeDebut, LocalDate dateDeFin, Nature nature, String villeDeDepart, String villeDArrivee, Transport transport, Statue statue) {
        this.dateDeDebut = dateDeDebut;
        this.dateDeFin = dateDeFin;
        this.nature = nature;
        VilleDeDepart = villeDeDepart;
        VilleDArrivee = villeDArrivee;
        this.transport = transport;
        this.statue = statue;
    }

    public LocalDate getDateDeDebut() {
        return dateDeDebut;
    }

    public void setDateDeDebut(LocalDate dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    public LocalDate getDateDeFin() {
        return dateDeFin;
    }

    public void setDateDeFin(LocalDate dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public String getVilleDeDepart() {
        return VilleDeDepart;
    }

    public void setVilleDeDepart(String villeDeDepart) {
        VilleDeDepart = villeDeDepart;
    }

    public String getVilleDArrivee() {
        return VilleDArrivee;
    }

    public void setVilleDArrivee(String villeDArrivee) {
        VilleDArrivee = villeDArrivee;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Statue getStatue() {
        return statue;
    }

    public void setStatue(Statue statue) {
        this.statue = statue;
    }
}
