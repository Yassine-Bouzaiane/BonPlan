/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author amine
 */
public class CriteresEvaluation {
    
  protected int id_critere;
  protected String nom ;
  protected  int id_categorie;

    public CriteresEvaluation(String nom, int id_categorie) {
        this.nom = nom;
        this.id_categorie = id_categorie;
    }

    public CriteresEvaluation() {
    }

    public int getId_critere() {
        return id_critere;
    }

    public void setId_critere(int id_critere) {
        this.id_critere = id_critere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    @Override
    public String toString() {
        return "criteresevaluation{" + "id_critere=" + id_critere + ", nom=" + nom + ", id_categorie=" + id_categorie + '}';
    }

}
