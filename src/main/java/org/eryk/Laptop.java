package org.eryk;

public class Laptop {
    private String name;
    private int price; //in grosze (199 = 1,99 zł)
    public Laptop() {
        this.name = "";
        this.price = 0;
    }
    public Laptop(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public int getPrice() {
        return this.price;
    }
}
