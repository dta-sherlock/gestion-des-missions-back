package dev.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Nature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String name;
     private boolean facturation;
     private boolean prime;
     private int TJM;
     private float pourcentage;
     private int plafond;
     private boolean plafondDepassable;
     private LocalDate debutValidite;
     private  LocalDate finValidite;

    @OneToMany(mappedBy = "nature")
     private List<Mission> missions;

    public Nature(){}

    public Nature(String name, boolean facturation, boolean prime, int plafond, boolean plafondDepassable, LocalDate debutValidite) {
        this.name = name;
        this.facturation = facturation;
        this.prime = prime;
        this.plafond = plafond;
        this.plafondDepassable = plafondDepassable;
        this.debutValidite = debutValidite;
    }

    public Nature(String name, boolean facturation, boolean prime, int TJM, float pourcentage, int plafond, boolean plafondDepassable, LocalDate debutValidite, LocalDate finValidite) {
        this.name = name;
        this.facturation = facturation;
        this.prime = prime;
        this.TJM = TJM;
        this.pourcentage = pourcentage;
        this.plafond = plafond;
        this.plafondDepassable = plafondDepassable;
        this.debutValidite = debutValidite;
        this.finValidite = finValidite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean isFacturation() {
        return facturation;
    }

    public void setFacturation(boolean facturation) {
        this.facturation = facturation;
    }

    public boolean isPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public int getTJM() {
        return TJM;
    }

    public void setTJM(int TJM) {
        this.TJM = TJM;
    }

    public float  getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(float pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public LocalDate getFinValidite() {
        return finValidite;
    }

    public void setFinValidite(LocalDate finValidite) {
        this.finValidite = finValidite;
    }

    public LocalDate getDebutValidite() {

        return debutValidite;
    }

    public void setDebutValidite(LocalDate debutValidite) {
        this.debutValidite = debutValidite;
    }

    public boolean isPlafondDepassable() {
        return plafondDepassable;
    }

    public void setPlafondDepassable(boolean plafondDepassable) {
        this.plafondDepassable = plafondDepassable;
    }

    public int getPlafond() {
        return plafond;
    }

    public void setPlafond(int plafond) {
        this.plafond = plafond;
    }
}
