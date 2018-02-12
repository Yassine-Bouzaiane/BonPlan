/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Experience;
import IServices.IServiceExperience;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amine
 */
public class ServiceExperience implements IServiceExperience{
    

    public Connection cnx;

    public ServiceExperience() {
        this.cnx = Connexion.getInstance().getCon();
    }
 public void ajouterexperience(Experience e)    {
     try {

            Statement state = cnx.createStatement();
            state.executeUpdate("INSERT INTO`experience`(description,`preuve`,`id`,`id_etablissement`) VALUES ('"+e.getDescription()+"','"+e.getPreuve()+"',"+e.getId()+","+e.getId_etablissement()+");");

            // 
         } catch (SQLException ex) {
               System.out.println(ex.getMessage());    
         }
        
        
   
}


public void modifierexperience(Experience e) 
    {
     
        {
        String update = "UPDATE experience SET description= ? , preuve = ? WHERE id_etablissement = ? and id =?";
        PreparedStatement statement2;
            try {
                statement2 = cnx.prepareStatement(update);
                
                
                statement2.setString(1, e.getDescription());
        statement2.setString(2,e.getPreuve());
        statement2.setInt(3,e.getId_etablissement());
        statement2.setInt(4,e.getId());
        statement2.executeUpdate();
        System.out.println("exp num"+e.getId_exp()+" modifiÃ©e !!!");
            } catch (SQLException ex) {
                Logger.getLogger(ServiceExperience.class.getName()).log(Level.SEVERE, null, ex);
            
            }
        
      


}
    }


 public void supprimerexperience(Experience s) 
    {
        try 
        {
        String delete = "DELETE FROM experience WHERE id_etablissement = ? and id =?";
        PreparedStatement st2 = cnx.prepareStatement(delete);
        st2.setInt(1,s.getId_etablissement());
        st2.setInt(2,s.getId());
        st2.executeUpdate();
       
        
        }
        catch (SQLException e)
        {

                    System.err.println("SQLException: "+e.getMessage());
                           }
    }
 public Experience rechercherexperience(int id ,int id_etablissement) 
    {
        Experience h = new Experience ();
        try
        {
        String select = "SELECT * FROM experience WHERE id = '"+id+"' and id_etablissement = '"+id_etablissement+"' ";
        Statement statement1 = cnx.createStatement();
        ResultSet result = statement1.executeQuery(select);
       
        while (result.next()) 
        {
            h.setDescription(result.getString("description"));
            h.setId(result.getInt("id"));
            h.setId_etablissement(result.getInt("id_etablissement"));
            h.setId_exp(result.getInt("id_exp"));
            h.setPreuve(result.getString("preuve"));
        
        }
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        return h;
    }

    @Override
    public List<Experience> afficherexperience() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}