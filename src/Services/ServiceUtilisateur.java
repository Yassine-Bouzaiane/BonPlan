/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author malek
 */
public class ServiceUtilisateur {
    
     public Connection cnx;
   
    
    public ServiceUtilisateur(){
        this.cnx = Connexion.getInstance().getCon();
    }
    
    public void ajouterUtilisateur(Utilisateur utilisateur){
         String req = "insert into user (nom,prenom ,roles,username,password) values (?,?,?,?,?)";
        try {
            PreparedStatement st1 = cnx.prepareStatement(req);
            
             st1.setString(1, utilisateur.getNom());
            st1.setString(2, utilisateur.getPrenom());  
            st1.setString(3, utilisateur.getRoles());
            st1.setString(4,utilisateur.getUsername());
             st1.setString(5,utilisateur.getMot_de_passe());
            
            
            
            st1.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public List<Utilisateur> listUtilisateur() 
    {
                ArrayList<Utilisateur> lcr=new ArrayList<>();
        try 
        {
        String select = "SELECT * FROM user  ; ";
        Statement statement1 = cnx.createStatement();
        
        ResultSet result = statement1.executeQuery(select);
        
        while (result.next()) 
        {
            Utilisateur cr = new Utilisateur();
            
            cr.setId_user(result.getInt("id"));
            cr.setNom(result.getString("nom"));
            cr.setPrenom(result.getString("prenom"));
            cr.setMot_de_passe(result.getString("password"));
             cr.setRoles(result.getString("roles"));
            cr.setUsername(result.getString("username"));
            
          
            
            lcr.add(cr);

        } 
    }   catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        return lcr; 
    }

     public void deleteUtilisateur(int id){
        
        String req = "delete from user where id = ?";
        try {
            PreparedStatement st2 = cnx.prepareStatement(req);
             st2.setInt(1, id);
            st2.executeUpdate();
            
            
        } catch (Exception e) {
            
        }
        }
    
    
    
    
}
