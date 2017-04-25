/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalshop;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author lesapii
 */
public class RentalClass {

    public RentalClass(int theChair, int theCost, int theCanopy, int theTable, String theAddress, String thephone, String theName) {
        this.theChair = new SimpleIntegerProperty(theChair);
        this.theCost = new SimpleIntegerProperty(theCost);
        this.theCanopy = new SimpleIntegerProperty(theCanopy);
        this.theTable = new SimpleIntegerProperty(theTable);
        this.theAddress = new SimpleStringProperty(theAddress);
        this.thephone = new SimpleStringProperty(thephone);
        this.theName = new SimpleStringProperty(theName);
    }

    

    private final IntegerProperty theChair;
    //= new SimpleIntegerProperty();
    private final IntegerProperty theCost;
    //= new SimpleIntegerProperty();

    public int getTheCost() {
        return theCost.get();
    }

    public void setTheCost(int value) {
        theCost.set(value);
    }

    public IntegerProperty theCostProperty() {
        return theCost;
    }

    public int getTheChair() {
        return theChair.get();
    }

    public void setTheChair(int value) {
        theChair.set(value);
    }

    public IntegerProperty theChairProperty() {
        return theChair;
    }

    private final IntegerProperty theCanopy;
    //= new SimpleIntegerProperty();
    private final IntegerProperty theTable;
    //= new SimpleIntegerProperty();

    public int getTheTable() {
        return theTable.get();
    }

    public void setTheTable(int value) {
        theTable.set(value);
    }

    public IntegerProperty theTableProperty() {
        return theTable;
    }

    public int getTheCanopy() {
        return theCanopy.get();
    }

    public void setTheCanopy(int value) {
        theCanopy.set(value);
    }

    public IntegerProperty theCanopyProperty() {
        return theCanopy;
    }

    private final StringProperty theAddress;
    //= new SimpleStringProperty();

    public String getTheAddress() {
        return theAddress.get();
    }

    public void setTheAddress(String value) {
        theAddress.set(value);
    }

    public StringProperty theAddressProperty() {
        return theAddress;
    }

    private final StringProperty thephone;
    //= new SimpleStringProperty();

    public String getThephone() {
        return thephone.get();
    }

    public void setThephone(String value) {
        thephone.set(value);
    }

    public StringProperty thephoneProperty() {
        return thephone;
    }

    private final StringProperty theName;
    //= new SimpleStringProperty();

    public String getTheName() {
        return theName.get();
    }

    public void setTheName(String value) {
        theName.set(value);
    }

    public StringProperty theNameProperty() {
        return theName;
    }
    
}
