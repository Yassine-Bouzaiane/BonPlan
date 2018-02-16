/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Offre;
import Entite.Publicite;
import Services.ServiceOffre;
import bonplan.TestOffre;
import bonplan.TestPublicite;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class OffreController{

    @FXML
    private Button bt_menu;
    @FXML
    private VBox mainContainer;
    @FXML
    private TableColumn<?, ?> photo;
    @FXML
    private TableColumn<?, ?> details;
    @FXML
    private Label wcount;
    @FXML
    private TableView<Offre> table_offre;
    @FXML
    private Button add_offre;
    @FXML
    private Button edit_offre;
    @FXML
    private Button delete_offre;

    private ObservableList<Offre> data ;
    ServiceOffre service = new ServiceOffre();
    private TestOffre mainApp;
    /**
     * Initializes the controller class.
     */
    
    public void initialize() {
        // TODO
        data = FXCollections.observableArrayList();
        List<Offre> ls = service.afficheroffre();
        ls.stream().forEach((j)->{
            data.add(j);
        });
        
        table_offre.setItems(data);
        photo.setCellValueFactory(new PropertyValueFactory<>("photo_publicite"));
        details.setCellValueFactory(new PropertyValueFactory<>("description_publicite"));

    }    
    
    public void setMainApp(TestOffre mainApp) {
        this.mainApp = mainApp;
        // Add observable list data to the table
       // personTable.setItems(mainApp.getPersonData());
    }

    @FXML
    private void Add(ActionEvent event) throws IOException {
Parent homePage = FXMLLoader.load(getClass().getResource("AfficherOffre.fxml"));

        Scene homePage_scene = new Scene(homePage);

        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.setScene(homePage_scene);

        app_stage.show();
Offre tempService = new Offre();
        if(mainApp != null ){
            boolean okClicked = mainApp.showServiceEditDialog(tempService);
            if (okClicked) {
                service.ajouteroffre(tempService);
                initialize();
        }
        }
        else{
            System.out.println("xD");
        };

    }

    @FXML
    private void Edit(ActionEvent event) {
    }

    @FXML
    private void Delete(ActionEvent event) {
    }
    
}
