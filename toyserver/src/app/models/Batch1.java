package app.models;

import java.io.Serializable;

public class Batch1 implements Serializable {
    public static final long serialVersionUID = 1L;

    public String toyCode, toyName;

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