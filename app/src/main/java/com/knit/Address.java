package com.knit;

public class Address {
	 
    private String line;
    private String city;
    private String state;
    private long zipcode;
 
    public String getLine() {
        return line;
    }
    public void setLine(String line) {
        this.line = line;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public long getZipcode() {
        return zipcode;
    }
    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }   
}