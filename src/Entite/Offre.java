/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Offre 
{
    private int id_offre;
    private String description;
    private Date date_debut;
    private Date date_fin;
    private String photo;
            
            

    public Offre() 
    {
    }
    
    
    public Offre(int id_offre, String description, Date date_debut, Date date_fin, String photo) 
    {
        this.id_offre=id_offre;
        this.description=description;
        this.date_debut=date_debut;
        this.date_fin=date_fin;
        this.photo=photo;
    
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", description=" + description + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", photo=" + photo + '}';
    }

    
    
    
}