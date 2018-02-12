/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IService;

import Entite.Produit;

/**
 *
 * @author malek
 */
public interface IServiceProduit {
     public void ajouterProduit(Produit prod);
     public void deleteProduit(int id_produit);
}
