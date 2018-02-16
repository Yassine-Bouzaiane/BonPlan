/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author malek
 */
public class Admin extends Utilisateur{
    
   
    public Admin(){
        
    }

    public Admin(int id_user, String nom, String prenom, String mot_de_passe, String username, String username_canonical, String email_canonical, int enable, String salt, int credentials_expired, String ville, int telephone, String genre, int locked, int expired, String region, int teliphone,String email) {
        super(id_user, nom, prenom, mot_de_passe, username, username_canonical, email_canonical, enable, salt, credentials_expired, ville, telephone, genre, locked, expired, region, teliphone,email);
    roles="Admin";
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
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

    @Override
    public String toString() {
        return super.toString()+"Admin{" + '}';
    }

   
   
    
   

  
    
    
   
    
    
    
}
