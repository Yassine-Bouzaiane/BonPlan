/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Evenement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import IServices.IServiceEvenement;

/**
 *
 * @author admin
 */
public class ServiceEvenement implements IServiceEvenement{

    @Override
    public List<Evenement> afficherevenement() 
    {
        List<Evenement> evs =new ArrayList<>();
        try {
            Statement stm = Connexion.getInstance().getCon().createStatement();
            ResultSet rest= 
                    stm.executeQuery("select * from `evenement` ");
            while(rest.next()){
                Evenement ev = new Evenement();
                ev.setId_evenement(rest.getInt("id_evenement"));
                ev.setDescription(rest.getString("description"));
                ev.setDate_evenement(rest.getDate("date_evenement"));
                ev.setPhoto(rest.getString("photo"));
                
                evs.add(ev);
                
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
         return evs;
    }

    @Override
    public Evenement rechercherevenment(Evenement e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void modifierevenement(Evenement e) {
try {
            String query = 
                    
         "update `bonplan`.`evenement` set  description=?, date_evenement=?, photo=? where id_etablissement =?  ;";
            
            PreparedStatement st = Connexion.getInstance().getCon().prepareStatement(query);

            st.setString(1,"modif de desc even1");
            st.setDate(2,new java.sql.Date(2016-1900,1,1));
            st.setString(3,"modif de photo even1");
            st.setInt(4,1);

            st.executeUpdate();
            System.out.println(e.getId_evenement());

        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerevenement(Evenement e) {
 try {
            String query = "delete from `evenement` where id_evenement =?";
            PreparedStatement st = Connexion.getInstance().getCon().prepareStatement(query);
            st.setInt(1, 1);
            st.executeUpdate();
            System.out.println("supp even ok");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @Override
    public void ajouterevenement(Evenement e) {
try {
            String query = "insert into `bonplan`.`evenement` (`description`,`date_evenement`,`photo`,`id_etablissement`) values (?,?,?,?)";
            PreparedStatement st = Connexion.getInstance().getCon().prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
           
           
            //st.setInt(1, d.getId_demande());
            st.setString(1,e.getDescription());
            st.setDate(2,e.getDate_evenement());
            st.setString(3,e.getPhoto()); 
            st.setInt(4,1);

            st.executeUpdate();
             ResultSet result = st.getGeneratedKeys();
            int id = 0;
            while (result.next()) {
                id = result.getInt(1);
                e.setId_evenement(result.getInt(1));
                System.out.println("id ajout even "+id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
            
        }    
    }
 }

 