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
public class Publicite 
{
    private int id_publicite;
    private String description;
    private String photo;

    public Publicite() 
    {
    }

    
    public Publicite(int id_publicite, String description, String photo) {
       this.id_publicite=id_publicite;
       this.description=description;
       this.photo=photo;
    }

    public int getId_publicite() {
        return id_publicite;
    }

    public void setId_publicite(int id_publicite) {
        this.id_publicite = id_publicite;
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

    @Override
    public String toString() {
        return "Publicite{" + "id_publicite=" + id_publicite + ", description=" + description + ", photo=" + photo + '}';
    }
    
    
    
    
}
