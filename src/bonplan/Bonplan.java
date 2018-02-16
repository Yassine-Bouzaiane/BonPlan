/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonplan;

import Config.Connexion;
import Entite.Budget;
import Entite.Categorie;
import Entite.CriteresEvaluation;
import Entite.Etablissement;
import Entite.Evenement;
import Entite.Experience;
import Entite.Offre;
import Entite.Publicite;
import Entite.Utilisateur;
import Services.ServiceCritere;
import Services.ServiceEvaluation;
import Services.ServiceEvenement;
import Services.ServiceExperience;
import Services.ServiceOffre;
import Services.ServicePublicite;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import Entite.Evaluation;
import Entite.Produit;
import Services.ServiceCategorie;
import Services.ServiceEtablissement;
import Services.ServiceProduit;



/**
 *
 * @author Yassine
 */
public class Bonplan {

  

  /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connexion.getInstance();
  
        // --------------Anoir-------------- //
        System.out.println("// --------------Categorie-------------- ");        

 ServiceCategorie SC= new ServiceCategorie();
        Categorie c = new Categorie();
        c.setNom_categorie("lounge");
        c.setId_categorie(1);
      SC.ajouterCategorie(c);
 
      SC.modifierCategorie(c);
        c.setId_categorie(2);
        SC.supprimerCategorie(c);
        for(Categorie cat:SC.listCategorie()){
            System.out.println(cat.toString());
        }

        System.out.println("// --------------Categorie-------------- ");        


        
//        ServiceEtablissement SE = new ServiceEtablissement();
//                Utilisateur u1 = new Utilisateur(1,"user1");
//
//        Etablissement et = new Etablissement("cafe bristol", "aaaaa", 92332029 , "24h", "yezzi frere", "google it","photo patente", 4011, "google it", Etablissement.Budget.Moyen,"www.anoir.com",c,u1);
//        SE.ajouterEtablissement(et);
//        et.getCategorie().setId_categorie(5);
//        et.setId_etablissement(7);
//        SE.modifierEtablissement(et);
//       et.setId_etablissement(7);
//       SE.supprimerEtablissement(et);
//       SE.listEtablissement();
////       System.out.println(SE.chercherEtablissement("cafe bristol"));
//       for(Etablissement etab:SE.listEtablissement()){
//            System.out.println(etab.toString());
//        }
       
      
// --------------Anoir-------------- //

// --------------Mariem-------------- //
  
        System.out.println("// --------------Offre-------------- ");        
                ServiceOffre so = new ServiceOffre();

        Offre o1 = new Offre();
        o1.setDescription("decsription de l'offre 1");
        o1.setDate_debut(new java.sql.Date(2011-1900,10,5));
        o1.setDate_fin(new java.sql.Date(2012-1900,5,12));
        o1.setPhoto("photo offre 1");
        so.ajouteroffre(o1);
        
        for (Offre o:so.afficheroffre())
        {
            System.out.println(o.toString());
        }
            o1.setDescription("modif de l'offre 1");
    
        so.modifieroffre(o1);
            so.supprimeroffre(2);
        System.out.println("// --------------OFFRE-------------- ");        
   
              System.out.println("// --------------PUBLICITE-------------- ");        
   
        ServicePublicite sp = new ServicePublicite();

        Publicite p1 = new Publicite();
        p1.setDescription_publicite("decsription de pub 1");
    
        p1.setPhoto_publicite("photo pub 1");
        sp.ajouterpublicite(p1);
        
        for (Publicite p:sp.afficherpublicite())
        {
            System.out.println(p.toString());
        }
        
        p1.setDescription_publicite("modif de pub 1");
        sp.modifierpublicite(p1);
        p1.setId_publicite(3);
              sp.supprimerpublicite(p1);
                System.out.println("// --------------PUBLICITE-------------- ");        
   
                System.out.println("// --------------EVENT-------------- ");        
       
               ServiceEvenement se = new ServiceEvenement();

        Evenement e1 = new Evenement();
        e1.setDescription_evenement("decsription de even 1");
        e1.setDate_evenement(new java.sql.Date(2018-1900,2,2));
        e1.setPhoto_evenement("photo even 1");
//        se.ajouterevenement(e1);
//        
        for (Evenement e:se.afficherevenement())
        {
            System.out.println(e.toString());
        }
        
            se.modifierevenement(e1);
            se.supprimerevenement(e1);   
//            
            
               System.out.println("// --------------EVENT-------------- ");        
        
//               ServiceExperience sx = new ServiceExperience();
//        Utilisateur u1 = new Utilisateur(1,"user1");
//        Etablissement etab1 = new Etablissement(1, "etab55");
//        Experience x1 = new Experience();
//        x1.setDescription_experience("decsription de exp 3");
//        x1.setPreuve("preuve exp3");
//        x1.setId_user(u1.getId_user());
//        x1.getEtablissement().setId_etablissement(etab1.getId_etablissement());
//        sx.ajouterexperience(x1);
//        
//        for (Experience x:sx.afficherexperience())
//        {
//            System.out.println(x.toString());
//        }
//        
//            sx.modifierexperience(x1);
//            sx.supprimerexperience(x1);
    

// --------------Mariem-------------- //

// --------------Amine-------------- //

// ServiceExperience ex = new  ServiceExperience();
//        Experience e = new Experience("description", "preuve", 1, 1);
  // e.setId_etablissement(1);
   
    //   e.setId(1);
       
      // e.setDescription("amine");
//ex.ajouterexperience(e);

//ex.editexp(e);
       
       //ex.Deleteexp(e);
  //  System.out.println(ex.Findexp(1,1));
    
//        ServiceCritere cs =new  ServiceCritere();
//        CriteresEvaluation ce = new  CriteresEvaluation();
//    ce.setId_categorie(2);
//   
//    ce.setNom("qualiter");
//      //  cs.ajoutercritere(ce);
//        //System.out.println(  cs.Findcritere(1) );
//         
//         
//         
//        //for (criteresevaluation ca :cs.listcritereevaluation()){
//          //  System.out.println(ce.toString());}

System.out.println("// --------------Evaluation-------------- //");

ServiceEvaluation es= new  ServiceEvaluation();
          Evaluation k = new Evaluation();
       k.setNote(6);
     
          es.ajouterevaluation(k);
    //  es.editevaluation(k);
System.out.println("// --------------Evaluation-------------- //");
// --------------Amine-------------- //




// --------------Malek-------------- //
    System.out.println("// --------------PRODUIT-------------- ");        
           ServiceProduit s1 =new ServiceProduit();
        Produit p=new Produit();
       
        p.setNom_produit("7aja bnina");
        p.setPhoto_produit("taswiiiiira");
        p.setPrix_produit(11f);
        
       // System.out.println(s1.chercherProduit("grey couse"));
           s1.ajouterProduit(p);
      System.out.println("// --------------PRODUIT-------------- ");        
         
// --------------Malek-------------- //

    }
    

    
}
