/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Produit;
import Services.ServiceEtablissement;
import Services.ServiceProduit;

import com.jfoenix.controls.JFXButton;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AjouterProduitFXMLController{

    @FXML
    private ImageView picajout;
    @FXML
    private Button canproduit;
    @FXML
    private Button ajoutproduit;
    @FXML
    private JFXButton upload_add_produit;
    @FXML
    private TextField prixajout;
    @FXML
    private TextField nomajout;
    @FXML
    private Label titre1;
    
    private Stage odialogStage;
    private Produit p= new Produit();
    private boolean okClicked = false;
    ServiceProduit serp = new ServiceProduit();
    AjouterOffreFXMLController aj;

    /**
     * Initializes the controller class.
     */
  
    public void initialize() {
        // TODO
        List<String> l = new ArrayList<>();
 

    }

    public void setDialogStage(Stage dialogStage) {
        this.odialogStage = dialogStage;
    }

    public void setProduit(Produit p) {
        this.p = p;
        p.setNom_produit(nomajout.getText());
        p.setPrix_produit(Double.parseDouble(prixajout.getText()));

     
    }

    public boolean isOkClicked() {

        return okClicked;
    }
   public String upload(File file) throws FileNotFoundException, IOException {
        BufferedOutputStream stream = null;
        String globalPath = "C:\\wamp64\\www\\image";
        String localPath = "localhost:3306/";
        String fileName = file.getName();
        fileName = fileName.replace(" ", "_");
        try {
            Path p = file.toPath();

            byte[] bytes = Files.readAllBytes(p);

            File dir = new File(globalPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // Create the file on server
            File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
            stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            return localPath + "/" + fileName;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AjouterPubliciteController.class.getName()).log(Level.SEVERE, null, ex);
            return "error1";
        } catch (IOException ex) {
            Logger.getLogger(AjouterPubliciteController.class.getName()).log(Level.SEVERE, null, ex);
            return "error2";
        }
    }

    @FXML
    private void uploadPic(ActionEvent event) throws MalformedURLException, IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
  
                 upload(selectedFile);
            String imageFile = selectedFile.toURI().toURL().toString();
            System.err.println(selectedFile.getName());

            
            System.out.println(imageFile);

            Image image = new Image(imageFile);
            picajout.setImage(image);
            System.out.println("NAAAMMMEEE ::::: >>>>>>>"+selectedFile.getName());   
            p.setPhoto_produit(selectedFile.getName());

        } else {
            System.out.println("Fichier mouch hné");
        }
    }
    @FXML
    private void ajouter(ActionEvent event) {

        if (isInputValid()) {
            System.out.println("PRODUIT >>>>>>>>>>>>>> ");
            String k = nomajout.getText();
            System.out.println(nomajout.getText());

            try {
                p.setNom_produit(nomajout.getText());
                p.setPrix_produit(Double.parseDouble(prixajout.getText()));
               
                p.setEtablissement(aj.getEtab());
       okClicked = true;
            serp.ajouterProduit(p);
    
             } catch (Exception e) {
                System.out.println("PRODUIT ELEMENTS >>>>>>>>> : " + e.getMessage());
            }

            System.out.println(" pp : " + p.toString());
         }

    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (nomajout.getText() == null || nomajout.getText().length() == 0) {
            errorMessage += "No valid  Name!\n";
        }
        if (prixajout.getText() == null || prixajout.getText().length() == 0) {
            errorMessage += "No valid  Price!\n";
        }
        if (picajout.getImage() == null || picajout.getImage().equals(picajout)) {
            errorMessage += "No valid Photo !\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(odialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void Cancel(ActionEvent event) {
        odialogStage.close();

    }

 
}
