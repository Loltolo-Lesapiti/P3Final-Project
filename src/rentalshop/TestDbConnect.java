/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalshop;


/**
 *
 * @author Loltolo Petro Lesapiti
 */
public class TestDbConnect {
    public static void main(String args[]){
    dbConnect db=new dbConnect();
    db.setData("Lesapiti","0705400471","BAAWA",25,36,8);
    System.out.println("Getting one particular record");
    db.getData();
    }
}
