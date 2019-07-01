package app.models;

import java.io.Serializable;

public class Batch1 implements Serializable {
    private static final long serialVersionUID = 1L;

    private String toyCode, toyName;

    public String getToyCode() {
        return toyCode;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public void setToyCode(String toyCode) {
        this.toyCode = toyCode;
    }
}