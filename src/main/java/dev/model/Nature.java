package dev.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Nature {

     private String name;
     private boolean facturation;
     private boolean prime;
     private int TJM;
     private int pourcentage;
     @OneToMany(mappedBy = "nature")
     private List<Mission> missions;

    public Nature(boolean facturation, boolean prime, int TJM, int pourcentage) {
        this.facturation = facturation;
        this.prime = prime;
        this.TJM = TJM;
        this.pourcentage = pourcentage;
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

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
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
}
