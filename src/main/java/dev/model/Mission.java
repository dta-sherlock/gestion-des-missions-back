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
        AVION ("Avion"),
        COVOITURAGE ("Covoiturage"),
        TRAIN ("Train"),
        VOITURE_DE_SERVICE ("Voiture de service");

        private String name;

        Transport(String name) {
            this.name=name;
        }

        public String toString(){
            return name;
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @ManyToOne
    @JoinColumn(name = "NAT_ID")
    private Nature nature;
    private String villeDeDepart;
    private String villeDArrivee;
    @Enumerated(EnumType.STRING)
    private Transport transport;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    private int prime;

    public Mission(){
        this.prime = 0;
    }

    public Mission(LocalDate dateDebut, LocalDate dateFin, Nature nature, String villeDeDepart, String villeDArrivee, Transport transport, Statut statut) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nature = nature;
        this.villeDeDepart = villeDeDepart;
        this.villeDArrivee = villeDArrivee;
        this.transport = transport;
        this.statut = statut;
        this.prime = 0;
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
        return villeDeDepart;
    }

    public void setVilleDeDepart(String villeDeDepart) {
        this.villeDeDepart = villeDeDepart;
    }

    public String getVilleDArrivee() {
        return villeDArrivee;
    }

    public void setVilleDArrivee(String villeDArrivee) {
        this.villeDArrivee = villeDArrivee;
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

    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }
}
