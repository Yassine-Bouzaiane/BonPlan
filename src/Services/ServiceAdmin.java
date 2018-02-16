/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Admin;
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
public class ServiceAdmin {
    
    
    public Connection cnx;
   
    
    public ServiceAdmin(){
        this.cnx = Connexion.getInstance().getCon();
    } 
    
     public void ajouterAdmin(Admin admin){
         String req = "insert into user (`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `locked`, `expired`, "
                 + "`roles`, `credentials_expired`, `nom`, `prenom`, `date_de_naissance`, `region`, `ville`, `telephone`, `genre`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
           
                        PreparedStatement st1 = Connexion.getInstance().getCon().prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);

            
            st1.setString(1, admin.getUsername());
            st1.setString(2, admin.getUsername_canonical());
            st1.setString(3, admin.getEmail());
            st1.setString(4,admin.getEmail_canonical());
             st1.setInt(5,admin.getEnable());
             st1.setString(6,admin.getSalt());
             st1.setString(7, admin.getMot_de_passe());
             st1.setInt(8, admin.getLocked());
             st1.setInt(9, admin.getExpired());
             st1.setString(10,"Admin");
             st1.setInt(11, admin.getCredentials_expired());
             st1.setString(12, admin.getNom());
             st1.setString(13, admin.getPrenom());
             st1.setDate(14, admin.getDate_naissance());
             st1.setString(15, admin.getRegion());
            st1.setString(16, admin.getVille());
            st1.setInt(17, admin.getTelephone());
            st1.setString(18, admin.getGenre());
            
            
            st1.executeUpdate();
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
    }
    
    public List<Admin> listAdmin() 
    {
                ArrayList<Admin> lcr=new ArrayList<>();
        try 
        {
        String select = "SELECT * FROM user  WHERE roles = 'Admin' ; ";
        Statement statement1 = cnx.createStatement();
        
        ResultSet result = statement1.executeQuery(select);
        
        while (result.next()) 
        {
            Admin cr = new Admin();
            
            cr.setId_user(result.getInt("id"));
            cr.setNom(result.getString("nom"));
            cr.setPrenom(result.getString("prenom"));
            cr.setMot_de_passe(result.getString("password"));
             cr.setRoles(result.getString("roles"));
            cr.setUsername(result.getString("username"));
            cr.setEmail(result.getString("email"));
           
            
            lcr.add(cr);

        } 
    }   
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        return lcr; 
    }

    public void deleteAdmin(int id_user){
        
        String req = "delete from user where id = ?";
        try {
            PreparedStatement st2 = cnx.prepareStatement(req);
             st2.setInt(1, id_user);
            st2.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        }
     
     public void modifierAdmin(Admin admin , int id_user){
            
            try {
                String req = "UPDATE user SET nom=? ,prenom=?  where id=?";
                PreparedStatement st3 = cnx.prepareStatement(req);
                
                
              st3.setString(1, admin.getNom());
              st3.setString(2,admin.getPrenom());
            st3.setInt(4, id_user);
            st3.executeUpdate();
           
                
                
            } catch (SQLException ex) {
                 ex.printStackTrace();
            System.out.println("errueur dans la requete update");
                
            }
            
        }
    
    
    
}
