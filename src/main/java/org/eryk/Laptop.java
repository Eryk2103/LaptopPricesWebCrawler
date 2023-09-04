package org.eryk;

public class Laptop {
    private String name;
    private String price; //in grosze (199 = 1,99 zł)
    public Laptop() {
        this.name = "";
        this.price = "0";
    }
    public Laptop(String name, String price) {
        this.name = name;
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public String getPrice() {
        return this.price;
    }
}
