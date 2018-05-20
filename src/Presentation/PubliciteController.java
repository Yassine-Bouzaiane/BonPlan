/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Publicite;
import Services.Facebook;
import Services.ServicePublicite;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PubliciteController {

    @FXML
    private VBox mainContainer;
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button delete;
    @FXML
    public  ListView<Publicite> titre;
    @FXML
    private ImageView photo2;
    @FXML
    private Button partage;
    @FXML
    private Label desc;
    ServicePublicite service = new ServicePublicite();
    private ObservableList<Publicite> data ;
    
    public static Publicite e;

    /**
     * Initializes the controller class.
     */
   
    public void initialize() {
          data = FXCollections.observableArrayList();
        List<Publicite> ls = service.afficherpublicite(AuthentificationController.c.getId_user());
        ls.stream().forEach((j)->{
            data.add(j);
        });
        
        titre.setItems(data);
        titre.getSelectionModel().selectFirst();
        e = titre.getSelectionModel().getSelectedItem();
        
        System.out.println(e.toString());
        desc.setText(e.getDescription_publicite());
        desc.setMaxWidth(200);
        desc.setWrapText(true);
        javafx.scene.image.Image image = new javafx.scene.image.Image("http://localhost/image/"+e.getPhoto_publicite());
        photo2.setImage(image);
        
        
       

    }    

    @FXML
    private void Add(ActionEvent event) {
        Publicite tempService = new Publicite();
            boolean okClicked = showServiceEditDialog(tempService);
            if (okClicked) {
                System.out.println(tempService.toString());
                service.ajouterpublicite(tempService);
                
                initialize();
               
        
        }
        else{
            System.out.println("not done");
        };
    }

    @FXML
    private void Edit(ActionEvent event) throws IOException {
        Publicite selectedPerson = titre.getSelectionModel().getSelectedItem();
        System.out.println(selectedPerson.getTitre());
        if ( selectedPerson != null) {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierPublicite.fxml"));
        //        Parent root = (Parent) loader.load();
                
//    Scene scene = new Scene(root);
//      Stage stage = new Stage();
//      stage.setScene(scene);
//      stage.showAndWait(); 
//                service.modifierpublicite(selectedPerson);
AnchorPane root = (AnchorPane) loader.load();
                ModifierPubliciteController controller = loader.getController();
                controller.setPublicite(selectedPerson); 
               // AnchorPane root = (AnchorPane) loader.load();
                 Scene scene = new Scene(root);
                Stage stage = new Stage();
      stage.setScene(scene);
      stage.showAndWait(); 
                
            

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Publicite Selected");
            alert.setContentText("Please select a Publicite in the table.");

            alert.showAndWait();


        }
    }

    @FXML
    private void Delete(ActionEvent event) {
         int selectedIndex = titre.getSelectionModel().getSelectedIndex();
         Publicite selectedPerson = titre.getSelectionModel().getSelectedItem();
         Alert a = new Alert(Alert.AlertType.CONFIRMATION);
         if (selectedIndex >= 0) {
            titre.getItems().remove(selectedIndex);
            service.supprimerpublicite(selectedPerson);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
           // alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Publicite Selected");
            alert.setContentText("Please select a Publicite in the table.");
            alert.showAndWait();
        }
    
    }

    @FXML
    private void afficher(MouseEvent event) {
        Publicite e=titre.getSelectionModel().getSelectedItem();
        desc.setText(e.getDescription_publicite());
       // photo2.setViewport(e.getPhoto_publicite());
       //label1.setText(e.getPhoto_publicite());
       // System.out.println(e.getPhoto_publicite());
      // Image image = new Image(e.getPhoto_publicite());
        System.out.println("http://localhost/image/"+e.getPhoto_publicite());
      //  ImageView photo2 = new ImageView(image););
       javafx.scene.image.Image image = new javafx.scene.image.Image("http://localhost/image/"+e.getPhoto_publicite());
      //  ImageView photo2 = new ImageView(image);
       
    photo2.setImage(image);
    }

    @FXML
    private void Partager(ActionEvent event) {
        int selectedIndex = titre.getSelectionModel().getSelectedIndex();
         Publicite selectedPerson = titre.getSelectionModel().getSelectedItem();
         if (selectedIndex >= 0) 
         {
             Facebook fb = new Facebook();
             fb.partager(selectedPerson);
         }
    }
    public boolean showServiceEditDialog(Publicite s) {
        try {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(getClass().getResource("../Presentation/AjouterPublicite.fxml"));
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            AnchorPane page = (AnchorPane) loader2.load();
            dialogStage.setTitle("Edit Publicite");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            //dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            // Set the person into the controller.
            AjouterPubliciteController controller = loader2.getController();            
            controller.setDialogStage(dialogStage);
            controller.setPublicite(s);            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
           // controller.isOkClicked();
            return controller.isOkClicked();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
