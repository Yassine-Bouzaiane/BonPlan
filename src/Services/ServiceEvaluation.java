/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import IServices.IServiceEvaluation;
import Entite.CriteresEvaluation;
import Entite.Evaluation;
import Entite.Experience;
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
public class ServiceEvaluation implements IServices.IServiceEvaluation{
    
       public Connection cnx;

    public ServiceEvaluation() {
        this.cnx = Connexion.getInstance().getCon();
    }   
public void ajouterevaluation(Evaluation e)    {
     try {
    String query =("INSERT INTO `evaluation`(`id_exp`, `id_critere`, `note`) VALUES (?,?,?)");
         
           PreparedStatement state = Connexion.getInstance().getCon().prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
           state.setInt(1, 4/*e.getExperience().getId_exp()*/);
           state.setInt(2, 3 /*e.getCritere_evaluation().getId_critere()*/);
           state.setInt(3,e.getNote());
 
                int res = state.executeUpdate();
                     ResultSet result = state.getGeneratedKeys();
            int id = 0;
            while (result.next()) {
                id = result.getInt(1);
        //        e.setId_Eval(result.getInt(1));
                System.out.println("id ajout offre"+id);
         
             if(res > 0){
                System.out.println("Add Done");
            }
             else{System.out.println("add not");}
            
            
            
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        
   
}
public void editevaluation(Evaluation cs) 
    {
     
        {
        String update = "UPDATE evaluation SET note= ?  WHERE id_exp = ? and id_critere=?";
        PreparedStatement statement2;
            try {
                statement2 = cnx.prepareStatement(update);
                
                
                statement2.setInt(1,cs.getNote());
        statement2.setInt(2,cs.getExperience().getId_exp());
        statement2.setInt(3, cs.getCritere_evaluation().getId_critere());
        statement2.executeUpdate();
        
        System.out.println("note num"+cs.getCritere_evaluation().getId_critere()+" modifiÃ©e !!!");
            } catch (SQLException ex) {
                Logger.getLogger(ServiceExperience.class.getName()).log(Level.SEVERE, null, ex);
            
            }


}
    }

 public void Deleteeval(Evaluation s) 
    {
        try 
        {
        String delete = "DELETE FROM evaluation WHERE WHERE id_exp = ? and id_critere=?";
        PreparedStatement st2 = cnx.prepareStatement(delete);
        st2.setInt(1,s.getExperience().getId_exp());
        st2.setInt(2,s.getCritere_evaluation().getId_critere());
        st2.executeUpdate();
       
        
        }
        catch (SQLException e)
        {

                    System.err.println("SQLException: "+e.getMessage());
                           }
    }

    @Override
    public Evaluation afficherEval(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Evaluation> listEvaluation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
