package app.models;

import java.io.Serializable;
import java.util.Date;

public class ToyMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String toyCode, toyName, description, price;
    private Date dateOfManufacture;
    private int batchNumber;
    private ToyManufacturer manufacturer;

    public ToyMessage (){}
    
    /**
     * @return the batchNumber
     */
    public int getBatchNumber() {
        return batchNumber;
    }

    /**
     * @param batchNumber the batchNumber to set
     */
    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    /**
     * @return the dateOfManufacture
     */
    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    /**
     * @param dateOfManufacture the dateOfManufacture to set
     */
    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the manufacturer
     */
    public ToyManufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(ToyManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the toyCode
     */
    public String getToyCode() {
        return toyCode;
    }

    /**
     * @param toyCode the toyCode to set
     */
    public void setToyCode(String toyCode) {
        this.toyCode = toyCode;
    }

    /**
     * @return the toyName
     */
    public String getToyName() {
        return toyName;
    }

    /**
     * @param toyName the toyName to set
     */
    public void setToyName(String toyName) {
        this.toyName = toyName;
    }
}