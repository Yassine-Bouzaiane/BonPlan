/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author user
 */
public class Critere_specifique {
    private int id_critere_specifique;
    private String nom_critere_specifique;
    private int id_categorie;

    public Critere_specifique( String nom_critere_specifique, int id_categorie) {
       
        this.nom_critere_specifique = nom_critere_specifique;
        this.id_categorie = id_categorie;
    }
    public Critere_specifique(){
    
    }

    public int getId_critere_specifique() {
        return id_critere_specifique;
    }

    public void setId_critere_specifique(int id_critere_specifique) {
        this.id_critere_specifique = id_critere_specifique;
    }

    public String getNom_critere_specifique() {
        return nom_critere_specifique;
    }

    public void setNom_critere_specifique(String nom_critere_specifique) {
        this.nom_critere_specifique = nom_critere_specifique;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    @Override
    public String toString() {
        return "Critere_specifique{" + "id_critere_specifique=" + id_critere_specifique + ", nom_critere_specifique=" + nom_critere_specifique + ", id_categorie=" + id_categorie + '}';
    }
    
    
    
    
}
