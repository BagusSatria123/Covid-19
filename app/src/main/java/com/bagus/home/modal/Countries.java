package com.bagus.home.modal;

public class Countries {

    private String country;
    private String flag;

    public Countries(String country, String flag) {
        this.country = country;
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
