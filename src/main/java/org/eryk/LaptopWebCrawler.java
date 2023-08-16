package org.eryk;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public abstract class LaptopWebCrawler {
    protected ArrayList<Laptop> laptops;
    protected ChromeDriver driver;
    protected String searchStr;

    public LaptopWebCrawler() {
        driver = new ChromeDriver();
        laptops = new ArrayList<Laptop>();
        searchStr = "";
    }
    public ArrayList<Laptop> getLaptops() {
        return this.laptops;
    }
    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }
    public abstract void crawl();
    public void close() {
        driver.close();
    }


}
