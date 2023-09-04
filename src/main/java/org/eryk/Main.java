package org.eryk;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EuroLaptopWebCrawler crawler = new EuroLaptopWebCrawler();
        crawler.setSearchStr("vivobook 14");
        crawler.crawl();

        ArrayList<Laptop> laptops = crawler.getLaptops();
        for(Laptop item : laptops) {
            System.out.println("name: " + item.getName());
            System.out.println("price: " + item.getPrice());
        }
        crawler.close();
    }
}