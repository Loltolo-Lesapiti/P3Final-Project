/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalshop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lesapii
 */
public class ConfirmationController implements Initializable {

    @FXML
    private Label confirmbtn;
    @FXML
    private Button logoutbtn;
    @FXML
    private Button backbtn;
    @FXML
    private Button viewbtn;
    @FXML
    private Button addanotherbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        Stage stage;

        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("logout.fxml"));

        Scene scene1 = new Scene(root);

        stage.setScene(scene1);
         ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Stage stage;

        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene1 = new Scene(root);

        stage.setScene(scene1);
        stage.show();
    }

    @FXML
    private void viewData(ActionEvent event) throws IOException {
        Stage stage;

        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tableView.fxml"));

        Scene scene1 = new Scene(root);

        stage.setScene(scene1);
        stage.show();
    }

    @FXML
    private void add(ActionEvent event) throws IOException, SQLException {
        Stage stage;

        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddTransaction.fxml"));

        Scene scene1 = new Scene(root);

        stage.setScene(scene1);
        stage.show();
        
    }
    
}
