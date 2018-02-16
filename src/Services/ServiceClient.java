/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author malek
 */
public class ServiceClient {
 
     public Connection cnx;
   
    
    public ServiceClient(){
        this.cnx = Connexion.getInstance().getCon();
    }
    
    public void ajouterClient(Client client){
         String req = "insert into user (`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `locked`, `expired`, "
                 + "`roles`, `credentials_expired`, `nom`, `prenom`, `date_de_naissance`, `region`, `ville`, `telephone`, `genre`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
           
                        PreparedStatement st1 = Connexion.getInstance().getCon().prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);

            
            st1.setString(1, client.getUsername());
            st1.setString(2, client.getUsername_canonical());
            st1.setString(3, client.getEmail());
            st1.setString(4,client.getEmail_canonical());
             st1.setInt(5,client.getEnable());
             st1.setString(6,client.getSalt());
             st1.setString(7,client.getMot_de_passe());
             st1.setInt(8, client.getLocked());
             st1.setInt(9, client.getExpired());
             st1.setString(10,"Client");
             st1.setInt(11, client.getCredentials_expired());
             st1.setString(12, client.getNom());
             st1.setString(13, client.getPrenom());
             st1.setDate(14, client.getDate_naissance());
             st1.setString(15, client.getRegion());
            st1.setString(16, client.getVille());
            st1.setInt(17, client.getTelephone());
            st1.setString(18, client.getGenre());
            
            
            st1.executeUpdate();
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
    }
    
    public void deleteClient(int id_user){
        
        String req = "delete from user where id = ?";
        try {
            PreparedStatement st2 = Connexion.getInstance().getCon().prepareStatement(req);
             st2.setInt(1, id_user);
            st2.executeUpdate();
            
            
        } catch (Exception e) {
            
        }
        }
    
    public void modifierClient(Client client , int id_user){
            
            try {
                String req = "UPDATE user SET nom=? ,prenom=? ,telephone=? where id=?";
                PreparedStatement st3 = Connexion.getInstance().getCon().prepareStatement(req);
                
                
              st3.setString(1, client.getNom());
              st3.setString(2, client.getPrenom());
            st3.setInt(3, client.getTelephone());

            st3.setInt(4, id_user);
            st3.executeUpdate();
           
                
                
            } catch (SQLException ex) {
                 ex.printStackTrace();
            System.out.println("errueur dans la requete update");
                
            }
            
        }
    
}
