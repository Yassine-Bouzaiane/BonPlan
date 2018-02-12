/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author admin
 */
public class Etablissement {
    private int id_etablissement;
    private String nom;
    private String adresse;
    private int telephone;
    private String horaire_travail;
    private String description;
    private String photo;
    private String photo_patente;
    private int code_postal;
    private String position;
    public enum Budget{Faible,Moyen,Cher};
    private Budget budget ;
    private Categorie categorie;
    
    public Etablissement(String nom, String adresse, int telephone, String horaire_travail, String description, String photo, String photo_patente, int code_postal, String position, Budget budget, Categorie categorie) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.horaire_travail = horaire_travail;
        this.description = description;
        this.photo = photo;
        this.photo_patente = photo_patente;
        this.code_postal = code_postal;
        this.position = position;
        this.budget = budget;
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getPhoto_patente() {
        return photo_patente;
    }

    public void setPhoto_patente(String photo_patente) {
        this.photo_patente = photo_patente;
    }

    
public Etablissement(){
}
    public int getId_etablissement() {
        return id_etablissement;
    }

    public void setId_etablissement(int id_etablissement) {
        this.id_etablissement = id_etablissement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getHoraire_travail() {
        return horaire_travail;
    }

    public void setHoraire_travail(String horaire_travail) {
        this.horaire_travail = horaire_travail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBudget() {
        return budget.name();
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }


    @Override
    public String toString() {
        return "Etablissement{" + "id_etablissement=" + id_etablissement + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + ", horaire_travail=" + horaire_travail + ", description=" + description + ", photo=" + photo + ", code_postal=" + code_postal + ", position=" + position + ", budget=" + budget + ", categorie=" + categorie + '}';
    }
    
    
}
