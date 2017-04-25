/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalshop;

/**
 *
 * @author Administrator
 */
public class transacTable {
    private String name;
    private String phone;
    private String address;
    private int tents;
    private int canopy;
    private int chairs;
    private int cost;

    public transacTable(String name, String phone, String address, int tents, int canopy, int chairs) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.tents = tents;
        this.canopy = canopy;
        this.chairs = chairs;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the tents
     */
    public int getTents() {
        return tents;
    }

    /**
     * @param tents the tents to set
     */
    public void setTents(int tents) {
        this.tents = tents;
    }

    /**
     * @return the canopy
     */
    public int getCanopy() {
        return canopy;
    }

    /**
     * @param canopy the canopy to set
     */
    public void setCanopy(int canopy) {
        this.canopy = canopy;
    }

    /**
     * @return the chairs
     */
    public int getChairs() {
        return chairs;
    }

    /**
     * @param chairs the chairs to set
     */
    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }
}
