/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Proprietaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author malek
 */
public class ServiceProprietaire {
    
     public Connection cnx;
   
    
    public ServiceProprietaire(){
        this.cnx = Connexion.getInstance().getCon();
    }
    
    public void ajouterProprietaire(Proprietaire proprietaire){
         String req = "insert into user (`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `locked`, `expired`, "
                 + "`roles`, `credentials_expired`, `nom`, `prenom`, `date_de_naissance`, `region`, `ville`, `telephone`, `genre`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
           
                        PreparedStatement st1 = Connexion.getInstance().getCon().prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);

            
            st1.setString(1, proprietaire.getUsername());
            st1.setString(2, proprietaire.getUsername_canonical());
            st1.setString(3, proprietaire.getEmail());
            st1.setString(4,proprietaire.getEmail_canonical());
             st1.setInt(5,proprietaire.getEnable());
             st1.setString(6,proprietaire.getSalt());
             st1.setString(7, proprietaire.getMot_de_passe());
             st1.setInt(8, proprietaire.getLocked());
             st1.setInt(9, proprietaire.getExpired());
             st1.setString(10,"Proprietaire");
             st1.setInt(11, proprietaire.getCredentials_expired());
             st1.setString(12, proprietaire.getNom());
             st1.setString(13, proprietaire.getPrenom());
             st1.setDate(14, proprietaire.getDate_naissance());
             st1.setString(15, proprietaire.getRegion());
            st1.setString(16, proprietaire.getVille());
            st1.setInt(17, proprietaire.getTelephone());
            st1.setString(18, proprietaire.getGenre());
            
            
            st1.executeUpdate();
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }         
        }
    
    
    public void deleteProprietaire(int id_user){
        
        String req = "delete from user where id = ?";
        try {
            PreparedStatement st2 = cnx.prepareStatement(req);
             st2.setInt(1, id_user);
            st2.executeUpdate();
            
            
        } catch (Exception e) {
            
        }
        }
    
    public void modifierProprietaire(Proprietaire proprietaire , int id_user){
            
            try {
                String req = "UPDATE user SET nom=? ,prenom=? ,telephone=? where id=?";
                PreparedStatement st3 = cnx.prepareStatement(req);
                
                
              st3.setString(1, proprietaire.getNom());
              st3.setString(2,proprietaire.getPrenom());
            st3.setInt(3, proprietaire.getTelephone());

            st3.setInt(4, id_user);
            st3.executeUpdate();
           
                
                
            } catch (SQLException ex) {
                 ex.printStackTrace();
            System.out.println("errueur dans la requete update");
                
            }
            
        }
     
    
    
    
    
}
