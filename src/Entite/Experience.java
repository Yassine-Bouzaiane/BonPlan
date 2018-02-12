
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
public class Experience {
    protected int id_exp;
  protected String description;
   protected String preuve;
   protected int id ;
  protected int  id_etablissement;

    public Experience( String description, String preuve, int id, int id_etablissement) {
     
        this.description = description;
        this.preuve = preuve;
        this.id = id;
        this.id_etablissement = id_etablissement;
    }

    public Experience() {
    }

    public int getId_exp() {
        return id_exp;
    }

    public void setId_exp(int id_exp) {
        this.id_exp = id_exp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreuve() {
        return preuve;
    }

    public void setPreuve(String preuve) {
        this.preuve = preuve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_etablissement() {
        return id_etablissement;
    }

    public void setId_etablissement(int id_etablissement) {
        this.id_etablissement = id_etablissement;
    }

    @Override
    public String toString() {
        return "experience{" + "id_exp=" + id_exp + ", description=" + description + ", preuve=" + preuve + ", id=" + id + ", id_etablissement=" + id_etablissement + '}';
    }
  
    
}