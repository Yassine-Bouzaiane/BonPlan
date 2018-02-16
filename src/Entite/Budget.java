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
public enum Budget {
    Faible("Faible",0),Moyen("Moyen",1),Cher("Cher",2);
    private String name;
    private int valeur;

    private Budget(String name, int valeur) {
        this.name = name;
        this.valeur = valeur;
    }

   
  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "budget{" + "name=" + name + ", valeur=" + valeur + '}';
    }
    
    

    
}
