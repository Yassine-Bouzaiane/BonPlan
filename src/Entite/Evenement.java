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
public class Evenement 
{
    private int id_evenement;
    private String description;
    private Date date_evenement;
    private String photo;

    public Evenement() 
    {
    }

    public Evenement(int id_evenement, String description, Date date_evenement, String photo)
    {
        this.id_evenement=id_evenement;
        this.description=description;
        this.date_evenement=date_evenement;
        this.photo=photo; 
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_evenement() {
        return date_evenement;
    }

    public void setDate_evenement(Date date_evenement) {
        this.date_evenement = date_evenement;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_evenement=" + id_evenement + ", description=" + description + ", date_evenement=" + date_evenement + ", photo=" + photo + '}';
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    
    
    
}
