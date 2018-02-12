/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Publicite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import IServices.IServicePublicite;
import IServices.IServiceEvenement;

/**
 *
 * @author admin
 */
public class ServicePublicite implements IServicePublicite{

    @Override
    public Publicite rechercherpublicite(Publicite p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publicite> afficherpublicite() {

    {
                List<Publicite> pubs =new ArrayList<>();
        try {
            Statement stm = Connexion.getInstance().getCon().createStatement();
            ResultSet rest= 
                    stm.executeQuery("select * from `publicite` ");
            while(rest.next()){
                Publicite pub = new Publicite();
                pub.setId_publicite(rest.getInt("id_publicite"));
                pub.setDescription(rest.getString("description"));
                pub.setPhoto(rest.getString("photo"));
                
                pubs.add(pub);
                
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublicite.class.getName()).log(Level.SEVERE, null, ex);
        }
         return pubs;
    }    }

    @Override
    public void ajouterpublicite(Publicite p) {
try {
    String query = "insert into `bonplan`.`publicite` (`description`,`photo`,`id_etablissement`) values (?,?,?)";
    
    PreparedStatement st =
            Connexion.getInstance().getCon().prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
           
            st.setString(1,p.getDescription());
            st.setString(2,p.getPhoto());
            st.setInt(3,1);

            st.executeUpdate();

             ResultSet result = st.getGeneratedKeys();
            int id = 0;
            while (result.next()) {
                id = result.getInt(1);
                p.setId_publicite(result.getInt(1));
                System.out.println("id ajout pub"+id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublicite.class.getName()).log(Level.SEVERE, null, ex);
            
        }   
    }

    @Override
    public void modifierpublicite(Publicite p) {
try {
            String query = "update `bonplan`.`publicite` set description =? where id_etablissement =?  ;";
            PreparedStatement st = Connexion.getInstance().getCon().prepareStatement(query);

            st.setString(1,"TEST DE MODIfication de pub");
//            st.setDate(2,o.getDate_debut());
//            st.setDate(3,o.getDate_fin());
//            st.setString(4,o.getPhoto());
//            st.setInt(5,1);
            st.setInt(2,1);

            st.executeUpdate();
            System.out.println(p.getId_publicite());

        } catch (SQLException ex) {
            Logger.getLogger(ServicePublicite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerpublicite(Publicite p) {

         try {
            String query = "delete from `publicite` where id_publicite =?";
            PreparedStatement st = Connexion.getInstance().getCon().prepareStatement(query);
            st.setInt(1, 2);
            st.executeUpdate();
            System.out.println("supp pub ok");

        } catch (SQLException ex) {
            Logger.getLogger(ServicePublicite.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
}
