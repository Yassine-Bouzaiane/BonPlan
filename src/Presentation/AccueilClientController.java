/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Publicite;
import Services.ServicePublicite;
import Services.ServiceStatPublicite;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AccueilClientController implements Initializable {

    @FXML
    private Button bt_menu;

    private ObservableList<Publicite> data;
    ServicePublicite service = new ServicePublicite();
    @FXML
    private Pagination slide;
    private List<Publicite> ls;

    private int PagSize = 0;
    @FXML
    private ImageView imagespace;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        ls = service.afficherPhoto();
        PagSize = ls.size();
        slide.setPageCount(PagSize);
        slide.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return LoadPub(pageIndex);
            }

        });
        
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //parcours  me3 tsawer
                    //
                    
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AccueilClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();*/
        

        
        slide.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);

    }

    public ImageView LoadPub(int pageIndex) {
        ImageView box = new ImageView();
        Publicite P = ls.get(pageIndex);
        //Image I = new Image("/Presentation/"+P.getPhoto_publicite());
        javafx.scene.image.Image image = new javafx.scene.image.Image("http://localhost/image/" + P.getPhoto_publicite());
        imagespace.setImage(image);
        imagespace.onMouseClickedProperty().setValue(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    
                    ServiceStatPublicite ps = new ServiceStatPublicite();
                    try {
                        if(ps.CheckStatu(P)){
                            ps.ajouterStatPubicite();
                        }
                    } catch (SQLException ex) {
                      //  Logger.getLogger(AccueilClientController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //To change body of generated methods, choose Tools | Templates.
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("AffichagePub.fxml"));
                    AnchorPane root = (AnchorPane) loader.load();
                    AffichagePubController controller = loader.getController();
                    controller.setDesc(P.getDescription_publicite());
                    Scene scene = new Scene(root);
                    
                    Stage stage = new Stage();
                    stage.setTitle("Description de Publicite");
                    stage.setScene(scene);
                    stage.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(AccueilClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
         
                
            }
        });
        return imagespace;
    }

    @FXML
    private void ouvrePub(MouseEvent event) throws IOException {
//         FXMLLoader loader = new FXMLLoader(getClass().getResource(
//               "AffichagePub.fxml"));
//         Parent root = (Parent) loader.load();
//         AffichagePubController controller = loader.getController();
//        // controller.
//        
//        
//        Scene scene = new Scene(root);
//        
//      Stage stage = new Stage();
//      stage.setTitle("Description de Publicite");
//      stage.setScene(scene);
//      stage.showAndWait(); 
   }     
    }


