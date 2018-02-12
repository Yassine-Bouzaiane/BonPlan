/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entite.Critere_specifique;
import java.util.List;

/**
 *
 * @author user
 */
public interface IServiceCritere_specifique {
    public void ajouterCritere_specifique(Critere_specifique cr);
    public void modifierCritere_specifique(Critere_specifique cr);
    public void supprimerCritere_specifique(Critere_specifique cr);
    public List<Critere_specifique> listCritere_specifique(String nom_categ);
}
