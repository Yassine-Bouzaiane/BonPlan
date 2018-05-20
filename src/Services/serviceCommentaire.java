/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Client;
import Entite.CriteresEvaluation;
import Entite.Commentaire;
import Entite.Test;
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
 * @author amine
 */
public class ServiceCommentaire {
   public Connection cnx;

    public ServiceCommentaire() {
        this.cnx = Connexion.getInstance().getCon();
    }   
    public void ajoutercommentaire(Commentaire a ,int id_exp , int id_ucomm)    {
     try {
 
            String query = "insert into `bonplan2`.`commentraire` (`commentaire`,`id_exp`,`id_ucomm`) values (?,?,?)";
            PreparedStatement st = Connexion.getInstance().getCon().prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
           
           st.setString(1,a.getCommentaire());
            st.setInt(2,id_exp);
            st.setInt(3,id_ucomm);

            st.executeUpdate();
             ResultSet result = st.getGeneratedKeys();
            int id = 0;
            while (result.next()) {
                id = result.getInt(1);
                a.setId_commentaire(result.getInt(1));
                System.out.println("id ajout commentaire "+id);
            }

          
         } catch (SQLException ex) {
               System.out.println(ex.getMessage());    
         } 
}

 public void editcommentaire(Commentaire cs , int id_ucomm) 
    {
     
        {
        String update = "UPDATE commentraire SET commentaire= ?  WHERE id_ucomm= ?";
        PreparedStatement statement2;
            try {
                statement2 = cnx.prepareStatement(update);
                
                
                statement2.setString(1,cs.getCommentaire());
        statement2.setInt(2, id_ucomm);
        statement2.executeUpdate();
        System.out.println("le commentaire"+cs.getCommentaire()+" modifiÃ©e !!!");
            } catch (SQLException ex) {
                Logger.getLogger(ServiceExperience.class.getName()).log(Level.SEVERE, null, ex);
            
            }


}
    }
 public void Deletecommentaire(int id_commentaire) 
    {
        try 
        {
        String delete = "DELETE FROM commentraire WHERE id_commentaire = ? ";
        PreparedStatement st2 = cnx.prepareStatement(delete);
         st2.setInt(1, id_commentaire);
        st2.executeUpdate();
       
        
        }
        catch (SQLException e)
        {

                    System.err.println("SQLException: "+e.getMessage());
                           }
    }
   
public Commentaire Findcommentaire(int id_commentaire) 
    {
        Commentaire ce= new  Commentaire();
        
        try
        {
        String select = "SELECT * FROM commentraire WHERE  id_commentaire = '"+id_commentaire+"' ";
        Statement statement1 = cnx.createStatement();
        ResultSet result = statement1.executeQuery(select);
       
        while (result.next()) 
        {
            ce.setId_commentaire(result.getInt("id_commentaire"));
            ce.setCommentaire(result.getString("commentaire"));
               ce.setId_exp(result.getInt("id_exp"));
               ce.setId_ucomm(result.getInt("id_ucomm"));
           
        }
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        return ce;
    }
 public List<Test> listcommentaire(int id_exp ) throws SQLException 
    {
                List<Test> co=new ArrayList<>();
      
        String select = "SELECT c.id_commentaire,c.commentaire,c.id_ucomm,u.nom,u.prenom,u.photo_user FROM commentraire c JOIN user u  ON (c.id_ucomm = u.id) WHERE   id_exp=? ";
       PreparedStatement statement1 = cnx.prepareStatement(select);
        statement1.setInt(1, id_exp);
       // statement1.setInt(2, id_user);
        ResultSet result = statement1.executeQuery();
      
        while (result.next()) 
        {
            
            Test h1 = new Test();
            h1.setId_commentaire(result.getInt("id_commentaire"));
            h1.setCommen(result.getString("commentaire"));
           
            h1.setNom(result.getString("nom"));
           h1.setPrenom(result.getString("prenom"));
            h1.setPhoto_user(result.getString("photo_user"));
             h1.setId_ucomm(result.getInt("id_ucomm"));
            
           
            co.add(h1);

        } 
    
            
        //System.out.println("fin");
        return co;

    }
 
 /* public Commentaire getCommentaireById(int id_exp , int id_user) throws SQLException {
        List<Commentaire> list = listcommentaire(id_exp,id_user);
        for (Commentaire c : list) {
            if (c.getId_exp() == id_exp) {
                return c;
            }
        }
        return null;
    }
 */
 
 

   
}
