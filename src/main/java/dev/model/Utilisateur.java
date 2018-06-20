package dev.model;

import javax.persistence.*;

@Entity
public class Utilisateur {

    enum Profil{
        Utilisateur,
        Manager,
        Admin;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String MDP;
    private String email;
    @Enumerated(EnumType.STRING)
    private Profil profil;
    //La photo est penser pour être un lien. Elle n'est pas obligatoire.
    @Column(nullable = true)
    private String photo;

    public Utilisateur() {}

    public Utilisateur(String nom, String MDP, String email, Profil profil) {
        this.nom = nom;
        this.MDP = MDP;
        this.email = email;
        this.profil = profil;
    }

    public Utilisateur(String nom, String MDP, String email, Profil profil, String photo) {
        this.nom = nom;
        this.MDP = MDP;
        this.email = email;
        this.profil = profil;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMDP() {
        return MDP;
    }

    public void setMDP(String MDP) {
        this.MDP = MDP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
