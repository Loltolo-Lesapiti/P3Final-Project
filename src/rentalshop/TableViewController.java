/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalshop;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lesapii
 */
public class TableViewController implements Initializable {

    private Connection conn;
    private PreparedStatement st =null;
    private ResultSet rs;
    @FXML
    private TableColumn<RentalClass,String> namecol;
    @FXML
    private TableColumn<RentalClass,String> phonecol;
    @FXML
    private TableColumn<RentalClass,String> adressCol;
    @FXML
    private TableColumn<RentalClass,Integer> canopyCol;
    @FXML
    private TableColumn<RentalClass,Integer> chairsCol;
    @FXML
    private TableColumn<RentalClass,Integer> costCol;
    @FXML
    private TableColumn<RentalClass,Integer> tableCol;
    @FXML
    private TableView<RentalClass> tableview;
    
    ObservableList<RentalClass> list=FXCollections.observableArrayList();
    @FXML
    private Button logoutbtn;
    @FXML
    private TextField searchItem;
    @FXML
    private Button backbn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/rental?zeroDateTimeBehavior=convertToNull","root","");
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        

        
        try {
            java.sql.Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from transactioninfo");
            while (r.next()) {
                list.add(new RentalClass(r.getInt("canopy"),r.getInt("tent"),r.getInt("chair"),r.getInt("cost")
                        ,r.getString("username"),r.getString("phone"),r.getString("address")));
                
                namecol.setCellValueFactory(cellData -> cellData.getValue().theNameProperty());
                phonecol.setCellValueFactory(cellData -> cellData.getValue().thephoneProperty());
                adressCol.setCellValueFactory(cellData -> cellData.getValue().theAddressProperty());
                canopyCol.setCellValueFactory(cellData -> cellData.getValue().theTableProperty().asObject());
                tableCol.setCellValueFactory(cellData -> cellData.getValue().theTableProperty().asObject());
                chairsCol.setCellValueFactory(cellData -> cellData.getValue().theChairProperty().asObject());
                costCol.setCellValueFactory(cellData -> cellData.getValue().theCostProperty().asObject());
                tableview.setItems(list);

            }
            
            r.close();
            s.close();
            con.close();
            
        } catch (SQLException ex) {
            
            System.out.println(ex);
        }
        FilteredList<RentalClass> filteredData = new FilteredList<>(list, p -> true);
        searchItem.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(client -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (client.getTheName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if (client.getThephone().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
                return false; 
            });
        });
     
        SortedList<RentalClass> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData);
        // TODO
    }    

    @FXML
    private void delete(ActionEvent event) throws SQLException {
         int row = tableview.getSelectionModel().getSelectedIndex();
        if (row >= 0) {
            tableview.getItems().remove(row);
        }
        
       dbConnect db =new dbConnect();
       db.connect();
         String sql;
        sql = "DELETE * FROM transactionInfo WHERE username='searchItem.getText()'";
           
        
             st=(PreparedStatement) conn.createStatement();
            
            st.executeUpdate(sql);
        
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

    private void edit(ActionEvent event) {
        tableview.setEditable(true);
        namecol.setCellFactory(TextFieldTableCell.forTableColumn());
        namecol.setOnEditCommit(e -> namecolEdit(e));
        //phonecol.setCellFactory(TextFieldTableCell.forTableColumn());
        phonecol.setOnEditCommit(e -> phoneEdit(e));
        adressCol.setOnEditCommit(e -> adressEdit(e));
        canopyCol.setOnEditCommit(e -> canopyEdit(e));
        tableCol.setOnEditCommit(e -> tableEdit(e));
        chairsCol.setOnEditCommit(e -> chairsEdit(e));
        costCol.setOnEditCommit(e -> costEdit(e));
            
        
        
    }
    public void namecolEdit(Event event) {
        TableColumn.CellEditEvent<RentalClass, String> ce;
        ce = (TableColumn.CellEditEvent<RentalClass, String>) event;
        RentalClass s = ce.getRowValue();
        s.setTheName(ce.getNewValue());
        }
    public void phoneEdit(Event event) {
        TableColumn.CellEditEvent<RentalClass, String> ce;
        ce = (TableColumn.CellEditEvent<RentalClass, String>) event;
        RentalClass s = ce.getRowValue();
        s.setThephone(ce.getNewValue());
        }
    public void adressEdit(Event event) {
        TableColumn.CellEditEvent<RentalClass, String> ce;
        ce = (TableColumn.CellEditEvent<RentalClass, String>) event;
        RentalClass s = ce.getRowValue();
        s.setTheAddress(ce.getNewValue());
        }
    public void canopyEdit(Event event) {
        TableColumn.CellEditEvent<RentalClass, Integer> ce;
        ce = (TableColumn.CellEditEvent<RentalClass, Integer>) event;
        RentalClass s = ce.getRowValue();
        s.setTheCanopy(ce.getNewValue());
        }
    public void tableEdit(Event event) {
        TableColumn.CellEditEvent<RentalClass, Integer> ce;
        ce = (TableColumn.CellEditEvent<RentalClass, Integer>) event;
        RentalClass s = ce.getRowValue();
        s.setTheTable(ce.getNewValue());
        }
    public void chairsEdit(Event event) {
        TableColumn.CellEditEvent<RentalClass, Integer> ce;
        ce = (TableColumn.CellEditEvent<RentalClass, Integer>) event;
        RentalClass s = ce.getRowValue();
        s.setTheChair(ce.getNewValue());
        }
    public void costEdit(Event event) {
        TableColumn.CellEditEvent<RentalClass, Integer> ce;
        ce = (TableColumn.CellEditEvent<RentalClass, Integer>) event;
        RentalClass s = ce.getRowValue();
        s.setTheCost(ce.getNewValue());
        }

    private void search(ActionEvent event) {
        int row = tableview.getSelectionModel().getSelectedIndex();
        if (row >= 0) {
            tableview.getItems().clear();
        }
        
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
    
}
