/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalshop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author lesapii
 */
public class MainController implements Initializable {

    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Label transaction;
    @FXML
    private Label title;
    @FXML
    private Label contactlbl;
    @FXML
    private Button logputbtn;
    @FXML
    private Button print;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addItem(ActionEvent event) {
        Stage stage=new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("AddTransaction.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(controlerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
         ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.show();
    }

    @FXML
    private void viewItem(ActionEvent event) throws IOException {
        Stage stage;

        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tableView.fxml"));

        Scene scene1 = new Scene(root);
     
        stage.setScene(scene1);
         ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.show();
    }

    private void search(ActionEvent event) throws IOException {
        Stage stage;

        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tableView.fxml"));

        Scene scene1 = new Scene(root);

        stage.setScene(scene1);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.show();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Stage stage;

        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));

        Scene scene1 = new Scene(root);

        stage.setScene(scene1);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.show();
    }

    @FXML
    private void printItem(ActionEvent event){
        dbConnect db=new dbConnect();
        try {

   FileWriter fw = new FileWriter("myFile.txt");
   
      fw.write(db.getData());        
      fw.flush();
      fw.close();

		} catch (IOException e) {

			e.printStackTrace();

		} 
    
    }
    
}
