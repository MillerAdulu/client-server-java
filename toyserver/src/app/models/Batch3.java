package app.models;

import java.io.Serializable;

public class Batch3 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String company, streetAddress, zipCode, country;

    public String getCompany() {
        return company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}