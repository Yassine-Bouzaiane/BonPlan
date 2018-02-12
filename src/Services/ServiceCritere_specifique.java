/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Critere_specifique;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ServiceCritere_specifique implements IServices.IServiceCritere_specifique{
Connection con ;

    public ServiceCritere_specifique() {
        con = Connexion.getInstance().getCon();
    }
    @Override
    public void ajouterCritere_specifique(Critere_specifique cr) {
         try {
            Statement state = con.createStatement();
            state.executeUpdate("INSERT INTO`critere_specifique`(`nom_critere_specifique`,`id_categorie`) VALUES ('"+cr.getNom_critere_specifique()+"','"+cr.getId_categorie()+"');");
                    
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        
    } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierCritere_specifique(Critere_specifique cr) {
        try
        {
        String update = "UPDATE Critere_specifique SET nom_critere_specifique = ? ,id_categorie = ? WHERE id_critere_specifique = ?";
        PreparedStatement statement2 = con.prepareStatement(update);
        statement2.setString(1, cr.getNom_critere_specifique());
        statement2.setInt(2, cr.getId_categorie());
        statement2.setInt(3, cr.getId_critere_specifique());
        
        statement2.executeUpdate();
        System.out.println(""+cr.getNom_critere_specifique()+" modifiee !!!");
        
        }
        catch (SQLException e)
                {
                    System.out.println(e.getMessage());
                    System.err.println(""+cr.getNom_critere_specifique()+" non modifiee");
                } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerCritere_specifique(Critere_specifique cr) {
        try 
        {
        String delete = "DELETE FROM Critere_specifique WHERE id_critere_specifique = ?";
        PreparedStatement st2 = con.prepareStatement(delete);
        st2.setInt(1,cr.getId_critere_specifique());
        
        st2.executeUpdate();
        
        
        }
        catch (SQLException e)
        {

                    System.err.println("SQLException: "+e.getMessage());
                           } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Critere_specifique> listCritere_specifique(String nom_categ) {
        List<Critere_specifique> lcr=new ArrayList<>();
        try 
        {
            
            String select_id = "SELECT * from categorie WHERE nom_categorie = ?; ";
            PreparedStatement stm = con.prepareStatement(select_id);
            stm.setString(1, nom_categ);
            ResultSet rs = stm.executeQuery();
            int id_categ  ;
            if (rs.next()){
                
            
             id_categ = rs.getInt("id_categorie");
             
        String select = "SELECT  * FROM Critere_specifique  where id_categorie = "+id_categ+";"; 
                 
        Statement statement1 = con.createStatement();
        
        ResultSet result = statement1.executeQuery(select);
        
        while (result.next()) 
        {
            
            Critere_specifique cr = new Critere_specifique();
            
            cr.setId_critere_specifique(result.getInt("id_critere_specifique"));
            cr.setNom_critere_specifique(result.getString("nom_critere_specifique"));
            cr.setId_categorie(result.getInt("id_categorie"));
            
            System.out.println(cr.toString());
            lcr.add(cr);

        } }
    }   
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        return lcr;
} //To change body of generated methods, choose Tools | Templates.
    }
    

