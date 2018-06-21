package dev.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Mission {

    public enum Statut {
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
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @ManyToOne
    @JoinColumn(name = "NAT_ID")
    private Nature nature;
    private String VilleDeDepart;
    private String VilleDArrivee;
    @Enumerated(EnumType.STRING)
    private Transport transport;
    @Enumerated(EnumType.STRING)
    private Statut statut;

    public Mission(){

    }

    public Mission(LocalDate dateDebut, LocalDate dateFin, Nature nature, String villeDeDepart, String villeDArrivee, Transport transport, Statut statut) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nature = nature;
        VilleDeDepart = villeDeDepart;
        VilleDArrivee = villeDArrivee;
        this.transport = transport;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateDeFin) {
        this.dateFin = dateFin;
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

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
}
