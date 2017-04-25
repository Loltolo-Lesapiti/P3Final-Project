/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalshop;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lesapii
 */
public class controlerController{

    @FXML
    private Label errorlbl;
    @FXML
    private TextField userlbl;
    @FXML
    private Button loginbtn;
    @FXML
    private PasswordField passpsw;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */

    @FXML
    private void login(ActionEvent event) {
        if(userlbl.getText().equals("admin")&& passpsw.getText().equals("pass")){
            errorlbl.setText("Login Success");
            Stage stage=new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("main.fxml"));
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
         ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.show();
        }else{
            errorlbl.setText("Wrong username or password");
        }
    }
    
}
