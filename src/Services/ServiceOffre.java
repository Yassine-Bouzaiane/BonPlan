/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Offre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import IServices.IServiceOffre;
import java.sql.Connection;
import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class ServiceOffre implements IServiceOffre
{
  Connection con= Connexion.getInstance().getCon();
   ;

    

    @Override
    public void ajouteroffre(Offre o) {
try {
    String query = "insert into `bonplan`.`offre` (`description_offre`,`date_debut`,`date_fin`, `photo_offre`, `nombre_like` , `nombre_dislike` , `id_etablissement`) values (?,?,?,?,?,?,?)";
    PreparedStatement st = Connexion.getInstance().getCon().prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
           
           
            st.setString(1,o.getDescription());
            st.setDate(2,o.getDate_debut());
            st.setDate(3,o.getDate_fin()); 
            st.setString(4,o.getPhoto()); 
            st.setInt(5,o.getNombre_like());
            st.setInt(6,o.getNombre_like());
            st.setInt(7,o.getEtablissement().getId_etablissement());

            st.executeUpdate();
             ResultSet result = st.getGeneratedKeys();
            int id = 0;
            while (result.next()) {
                id = result.getInt(1);
                o.setId_offre(result.getInt(1));
                System.out.println("id ajout offre"+id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public List<Offre> afficheroffre() {
    
    {
                List<Offre> offres =new ArrayList<>();
        try {
            Statement stm = Connexion.getInstance().getCon().createStatement();
            ResultSet rest= stm.executeQuery("select * from `offre` ");
           
            while(rest.next()){
                Offre off = new Offre();
                off.setId_offre(rest.getInt("id_offre"));
                off.setDescription(rest.getString("description_offre"));
                off.setDate_debut(rest.getDate("date_debut"));
                off.setDate_fin(rest.getDate("date_fin"));
                off.setPhoto(rest.getString("photo_offre"));
                off.setId_offre(rest.getInt("nombre_like"));
                off.setId_offre(rest.getInt("nombre_dislike"));
                
                offres.add(off);
                
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
         return offres;
    }

    }

//    @Override
//    public Offre rechercheroffre(Offre o) {
//       
//    }

    @Override
    public void modifieroffre(Offre o) {

try {
            String query = "UPDATE `bonplan`.`offre` SET description_offre = ? ,  date_debut = ? , date_fin = ? , photo_offre = ?  where id_etablissement =? and id_offre=?  ;";
            PreparedStatement st = Connexion.getInstance().getCon().prepareStatement(query);

            st.setString(1, o.getDescription());
            st.setDate(2,o.getDate_debut());
            st.setDate(3,o.getDate_fin());
            st.setString(4,o.getPhoto());
            st.setInt(5,o.getId_offre());
             st.setInt(6,o.getEtablissement().getId_etablissement());

            st.executeUpdate();
            System.out.println(o.getId_offre()+" Update Done");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimeroffre(int id) {

         try {
            String query = "delete from `offre` where id_offre =?";
            PreparedStatement st = Connexion.getInstance().getCon().prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("supp off ok");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
        public List<Offre> afficheroffrebyid(int id) {
    
    {
                List<Offre> offres =new ArrayList<>();
        try {
            Statement stm = Connexion.getInstance().getCon().createStatement();
            ResultSet rest= 
                    stm.executeQuery("select * from `offre` where id_offre="+id);
            while(rest.next()){
                Offre off = new Offre();
                off.setId_offre(rest.getInt("id_offre"));
                off.setDescription(rest.getString("description_offre"));
                off.setDate_debut(rest.getDate("date_debut"));
                off.setDate_fin(rest.getDate("date_fin"));
                off.setPhoto(rest.getString("photo_offre"));
               
 off.setEtablissement(new ServiceEtablissement().chercherEtablissement(rest.getInt(8)));
                offres.add(off);
                
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
         return offres;
    }

    }
    
    public List<Offre> afficheroffrebydate(LocalDate date) {
    
    {
                List<Offre> offres =new ArrayList<>();
        try {
            Statement stm = Connexion.getInstance().getCon().createStatement();
            ResultSet rest= 
                    stm.executeQuery("select * from `offre` where date_fin > '"+date+"';");

            while(rest.next()){
                Offre off = new Offre();
                off.setId_offre(rest.getInt("id_offre"));
                off.setDescription(rest.getString("description_offre"));
                off.setDate_debut(rest.getDate("date_debut"));
                off.setDate_fin(rest.getDate("date_fin"));
                off.setPhoto(rest.getString("photo_offre"));
               

 off.setEtablissement(new ServiceEtablissement().chercherEtablissement(rest.getInt(8)));
                offres.add(off);
                
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
         return offres;
    }

    }
    


    public Offre rechercheroffre(int id_etablissement) 
    {
        Offre h = new Offre();
        try
        { 
        String select = "SELECT * FROM offre WHERE id_etablissement ="+id_etablissement;
            Statement stm = Connexion.getInstance().getCon().createStatement();
        ResultSet result = stm.executeQuery(select);
       
        while (result.next()) 
        {
            h.setDate_debut(result.getDate(3));

            h.setDescription(result.getString(2));
                        h.setDate_fin(result.getDate(4));
                        h.setPhoto(result.getString(5));
                        
//                        ServiceEtablissement ss = new ServiceEtablissement();
//                        Etablissement ee =  ss.chercherEtablissement(id_etablissement);
//                    h.setEtab(ee);
//        
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
    }
    