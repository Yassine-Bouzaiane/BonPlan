/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Etablissement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ServiceEtablissement implements IServices.IServiceEtablissement{
     
    Connection con ;

    public ServiceEtablissement() {
        con = Connexion.getInstance().getCon();
    }
    
    
    

    @Override
    public void ajouterEtablissement(Etablissement e) {
        String sql = "INSERT INTO etablissement(nom,adresse,telephone,horaire_travail,description,photo,code_postal"
                + ",position,budget,id_categorie,photo_patente) VAlUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1,e.getNom());
            stm.setString(2,e.getAdresse());
            stm.setInt(3,e.getTelephone());
            stm.setString(4,e.getHoraire_travail());
            stm.setString(5,e.getDescription());
            stm.setString(6,e.getPhoto());
            stm.setInt(7,e.getCode_postal());
            stm.setString(8,e.getPosition());
            stm.setString(9,e.getBudget());
            stm.setInt(10, e.getCategorie().getId_categorie());
            stm.setString(11,e.getPhoto_patente());
            int res = stm.executeUpdate();
            if(res > 0){
                System.out.println("Add Done");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    @Override
    public void modifierEtablissement(Etablissement e) {
        try
        {
        String update = "UPDATE etablissement SET  nom = ? , adresse = ? , telephone = ? , horaire_travail = ? , "
                + "description = ? , photo = ? , code_postal = ? , position = ? , budget = ? , id_categorie = ? , photo_patente = ?  "
                + "WHERE id_etablissement = ?";
        PreparedStatement statement2 = con.prepareStatement(update);
        
        statement2.setString(1, e.getNom());
        statement2.setString(2, e.getAdresse());      
        statement2.setInt(3, e.getTelephone());
        statement2.setString(4, e.getHoraire_travail());
        statement2.setString(5, e.getDescription());
        statement2.setString(6, e.getPhoto());
        statement2.setInt(7, e.getCode_postal());
        statement2.setString(8, e.getPosition());
        statement2.setString(9, e.getBudget());
        statement2.setInt(10, e.getCategorie().getId_categorie());
        statement2.setString(11, e.getPhoto_patente());
        statement2.setInt(12, e.getId_etablissement());
        
        
        statement2.executeUpdate();
        System.out.println(""+e.getNom()+" modifiee !!!");
        
        }
        catch(SQLException ex)
                {
                    System.out.println(ex.getMessage());
                    System.err.println(""+e.getNom()+" non modifiee");
                }
    }

    @Override
    public void supprimerEtablissement(Etablissement e) {
        try 
        {
        String delete = "DELETE FROM etablissement WHERE id_etablissement= ? ";
        PreparedStatement st2 = con.prepareStatement(delete);
        st2.setInt(1,e.getId_etablissement());
        st2.executeUpdate();
        System.out.println(""+e.getNom()+" supprimee !!!");
        
        }
        catch (SQLException ex)
        {

                    System.err.println("SQLException: "+ex.getMessage());
                           } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etablissement chercherEtablissement(String nom) {
         Etablissement e = new Etablissement();
        try
        {
        String select = "SELECT * FROM etablissement WHERE nom = '"+nom+"' ";
        Statement statement1 = con.createStatement();
        ResultSet result = statement1.executeQuery(select);
       
        while (result.next()) 
        { 
            e.setNom(result.getString("nom"));
            e.setAdresse(result.getString("adresse"));  
            e.setTelephone(result.getInt("telephone"));
            e.setHoraire_travail(result.getString("horaire_travail"));
            e.setDescription(result.getString("description"));
            e.setPhoto(result.getString("photo"));
            e.setPhoto_patente(result.getString("photo_patente"));
            e.setCode_postal(result.getInt("code_postal"));
            e.setPosition(result.getString("position"));
            e.setBudget(Etablissement.Budget.valueOf(result.getString("budget")));
            e.getCategorie().setId_categorie(result.getInt("id_categorie"));
            }
        }
        catch (SQLException ex)
                {
                    System.err.println("SQLException: "+ex.getMessage());
                    System.err.println("SQLSTATE: "+ex.getSQLState());
                    System.err.println("VnedorError: "+ex.getErrorCode());
                }
        return e; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etablissement> listEtablissement() {
        List<Etablissement> le=new ArrayList<>();
        try 
        {
        String select = "SELECT  * FROM etablissement ;"; 
                 
        Statement statement1 = con.createStatement();
        
        ResultSet result = statement1.executeQuery(select);
        
        while (result.next()) 
        {
            Etablissement e = new Etablissement();
            
            e.setNom(result.getString("nom"));
            e.setAdresse(result.getString("adresse"));  
            e.setTelephone(result.getInt("telephone"));
            e.setHoraire_travail(result.getString("horaire_travail"));
            e.setDescription(result.getString("description"));
            e.setPhoto(result.getString("photo"));
            e.setPhoto_patente(result.getString("photo_patente"));
            e.setCode_postal(result.getInt("code_postal"));
            e.setPosition(result.getString("position"));
            e.setBudget(Etablissement.Budget.valueOf(result.getString("budget")));
            e.getCategorie().setId_categorie(result.getInt("id_categorie"));
            
            
            le.add(e);

        } 
    }   
        catch (SQLException ex)
                {
                    System.err.println("SQLException: "+ex.getMessage());
                    System.err.println("SQLSTATE: "+ex.getSQLState());
                    System.err.println("VnedorError: "+ex.getErrorCode());
                }
        return le;
} //To change body of generated methods, choose Tools | Templates.
    
    
}
