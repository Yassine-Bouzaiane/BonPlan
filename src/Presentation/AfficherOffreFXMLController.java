/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Offre;
import Entite.Publicite;
import Services.ServiceEtablissement;
import Services.ServiceOffre;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AfficherOffreFXMLController implements Initializable {

    private VBox vbox1;
    private TextField inurlphoto;
    private TextArea indesc;
    private DatePicker indfin;
    private DatePicker inddebut;
    private TextArea moddesc;
    @FXML
    private TextArea desc;
    @FXML
    private Button ajouter;
   @FXML
    private ChoiceBox<String> chb;
    @FXML
    private Button cancel;
    @FXML
    private ImageView pic;
        private Stage dialogStage;
    private boolean okClicked = false; 

    private Offre s;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

                ServiceEtablissement sp = new ServiceEtablissement();
         List<String> l=new ArrayList<>();
       // l=sp.nouri();
        for (int i=0;i<l.size();i++)
        {//System.out.println(l.get(i).toString());
chb.getItems().add(l.get(i).toString());
                }
        if(s != null){
            desc.setText(s.getDescription());
            
             //System.out.println(photo.getImage());
             
            
           // photo.setImage();
            
        }
        else{
            System.out.println("done");
        }

        }
    
public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
 public void setPublicite(Offre s) {
        this.s =s ;
        desc.setText(s.getDescription());
 }
 public boolean isOkClicked() {
       
        return okClicked;
    }
    @FXML
    private void ajouter(ActionEvent event) {
   if (isInputValid()) {
            s.setDescription(desc.getText());
            s.setPhoto(pic.getImage().toString());

            //    getImageUrl = selectedFile.getAbsolutePath();
            // System.out.println(getImageUrl);
            // Image value = new Image(getImageUrl);
            //  img.setImage(value);
           
            okClicked = true;
            dialogStage.close();
        
    } 
    }

    private void modifier(ActionEvent event) {
    Services.ServiceOffre som = new ServiceOffre();

      

    }

    @FXML
    private void Cancel(ActionEvent event) {
          dialogStage.close();
  }
   private boolean isInputValid() {
        String errorMessage = "";

        if (desc.getText() == null || desc.getText().length() == 0) {
            errorMessage += "No valid  description!\n"; 
        }
        if (pic.getImage()== null || pic.getImage().equals(pic)) {
            errorMessage += "No valid photo, !\n"; 
        }


         
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    
   }

    @FXML
    private void uploadPic(ActionEvent event) throws MalformedURLException {
         FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            //    getImageUrl = selectedFile.getAbsolutePath();
            // System.out.println(getImageUrl);
            // Image value = new Image(getImageUrl);
            //  img.setImage(value);
            String imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);

            Image image = new Image(imageFile);
            pic.setImage(image);
            //////a changer static
            /*IuserService is = new UserService();
            User u;
            u = is.findById(15);
            //////////
            u.setPath(imageFile);
            is.update(u);*/
            /////

        } else {
            System.out.println("file doesn't exist");
        }
    }

}
