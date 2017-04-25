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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lesapii
 */
public class AddTransactionController implements Initializable {

    @FXML
    private Label namelbl;
    @FXML
    private Label phonelbl;
    @FXML
    private Label addresslbl;
    @FXML
    private Label canopylbl;
    @FXML
    private Label tentlbl;
    @FXML
    private Label chairlbl;
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private TextField address;
    @FXML
    private TextField canopy;
    @FXML
    private TextField tent;
    @FXML
    private TextField chair;
    @FXML
    private Button addBtn;
    Scene scene;
    @FXML
    private AnchorPane backbtn;
    @FXML
    private Button logoutbtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    /*private void add() throws SQLException{
        dbConnect db=new dbConnect();
        String firstname=name.getText();
        String telephone=phone.getText();
        String location=address.getText();
        int can=Integer.parseInt(canopy.getText());
        int ten=Integer.parseInt(tent.getText());
        int cha=Integer.parseInt(chair.getText());
        int cost=Integer.parseInt(costtxt.getText());
       
        //Creating an istance of the databse class
        
        db.setData(firstname, telephone, location, can, ten, cha,cost);
        db.closeDb();
    }*/

    @FXML
    private void addTransaction(ActionEvent event) throws IOException, SQLException {
        Stage stage;

        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("confirmation.fxml"));

        Scene scene1 = new Scene(root);

        stage.setScene(scene1);
         ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.show();
        
        insert2DB();
    }
    /**
     * @param args the command line arguments
     * A method to insert the data entered in the form
     * into the databse.
     */
    
    public void insert2DB() throws SQLException{
        String firstname=name.getText();
        String telephone=phone.getText();
        String location=address.getText();
        int can=Integer.parseInt(canopy.getText());
        int tables=Integer.parseInt(tent.getText());
        int cha=Integer.parseInt(chair.getText());
        
        
        dbConnect db=new dbConnect();
        db.setData(firstname, telephone, location, can, tables, cha);
        db.closeDb();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Stage stage;

        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

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
    
    
}
