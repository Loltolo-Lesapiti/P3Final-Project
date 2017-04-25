package rentalshop;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Loltolo Petro Lesapiti
 */
//Importing the sql package


public class dbConnect {
    // Declaring the variables
    private Connection conn;
    private PreparedStatement st =null;
    private ResultSet rs;
    
    //Constructor

    /**
     * A Method to connect to the database
     */
    
    public void connect(){
          
        try{
            //Loading the driver class
            Class.forName("com.mysql.jdbc.Driver");
            conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/rental?zeroDateTimeBehavior=convertToNull","root","");
        }catch(ClassNotFoundException | SQLException ex){
                System.out.println("Error :" + ex);
        }
         
    }
    /**
     * This method views the transaction from the database
     */
    public String getData(){
        connect();
         String sql = "SELECT * FROM transactionInfo";
         String name = null;
         String phone=null;
         String adress=null;
         String content=null;
        try{
           
            st=conn.prepareStatement(sql);
            
            rs = st.executeQuery();
        
            while(rs.next()){
               name=rs.getString("username");
               phone=rs.getString("phone");
               adress=rs.getString("address");
               
               content=" "+ name +" "+phone+" "+adress; 
           }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        /**
         * This method adds a new record
         */
        
      return content;  
    }
    /**
     * This method add a new transaction
     * @param uname
     * @param telephone
     * @param adress
     * @param canopies
     * @param tables
     * @param chairs
     */
    public void setData(String uname,String telephone,String adress,int canopies,int tables,int chairs){
        int totalCost=(tables *20+canopies*30+chairs*10);
        connect();
      String sql = "INSERT INTO transactioninfo(username, phone, address, tent, canopy, chair, cost)" 
             +"VALUES (?,?,?,?,?,?,?)";
        try{
             st=conn.prepareStatement(sql);
             st.setString(1, uname);
             st.setString(2, telephone);
             st.setString(3, adress);
             st.setInt(4, tables);
             st.setInt(5, canopies);
             st.setInt(6, chairs);
             st.setInt(7, totalCost);
             st.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    /**
     * This method views one particular record
     */
    public void getRecord(){
        connect();
        
        try{
         
          String sql= "SELECT username, phone,address, tent, canopy, chair, cost FROM transactionInfo Where userId=1";
            st=conn.prepareStatement(sql);
            
            rs = st.executeQuery();
        
           
               String name=rs.getString("username");
               String phone=rs.getString("phone");
               System.out.println(" Name: "+ name+" "+
                       "Telephone: "+ phone);
           
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    public void closeDb() throws SQLException{
        if(conn!=null){
            conn.close();
        }
    }
}


