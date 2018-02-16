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
public class Utilisateur {
      protected int id_user;
    protected String nom ;
 protected String prenom ; 
 protected String mot_de_passe ;
 protected String username ;
 protected  String username_canonical;
 protected String roles;
 protected String email_canonical;
 protected int enable ; 
protected  String salt;
protected  int credentials_expired;
protected  String ville ;
protected int telephone;
protected String genre;
protected int locked;
protected int expired;
protected String region;
protected  int teliphone;
protected  String email;
protected  Date date_naissance;
    public Utilisateur(int id_user, String nom, String prenom, String mot_de_passe, String username, String username_canonical, String email_canonical, int enable, String salt, int credentials_expired, String ville, int telephone, String genre, int locked, int expired, String region, int teliphone,String email) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.mot_de_passe = mot_de_passe;
        this.username = username;
        this.username_canonical = username_canonical;
       this.email= email;
        this.email_canonical = email_canonical;
        this.enable = enable;
        this.salt = salt;
        this.credentials_expired = credentials_expired;
        this.ville = ville;
        this.telephone = telephone;
        this.genre = genre;
        this.locked = locked;
        this.expired = expired;
        this.region = region;
        this.teliphone = teliphone;
    }

    public Utilisateur(int id_user, String nom) {
        this.id_user = id_user;
        this.nom = nom;
    }

   

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getCredentials_expired() {
        return credentials_expired;
    }

    public void setCredentials_expired(int credentials_expired) {
        this.credentials_expired = credentials_expired;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public int getExpired() {
        return expired;
    }

    public void setExpired(int expired) {
        this.expired = expired;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getTeliphone() {
        return teliphone;
    }

    public void setTeliphone(int teliphone) {
        this.teliphone = teliphone;
    }

     


     public Utilisateur() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id) {
        this.id_user = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String nom_user) {
        this.username = nom_user;
    }

  

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", mot_de_passe=" + mot_de_passe + ", username=" + username + ", username_canonical=" + username_canonical + ", roles=" + roles + ", email_canonical=" + email_canonical + ", enable=" + enable + ", salt=" + salt + ", credentials_expired=" + credentials_expired + ", ville=" + ville + ", telephone=" + telephone + ", genre=" + genre + ", locked=" + locked + ", expired=" + expired + ", region=" + region + ", teliphone=" + teliphone + '}';
    }

 
  
  

   
            
           
    
    
}
