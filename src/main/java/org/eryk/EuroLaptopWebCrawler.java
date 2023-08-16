package org.eryk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

//Web crawler for RtvEuroAgd website
public class EuroLaptopWebCrawler extends LaptopWebCrawler {


    public void crawl() {
        this.driver.get("https://www.euro.com.pl/search/laptopy-i-netbooki.bhtml?keyword=" + this.searchStr);

        //Accept cookies pop up
        WebElement acceptCookies = null;
        while(acceptCookies == null){
            try{
                acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
                acceptCookies.click();
            }
            catch(NoSuchElementException ignored) {

            }
        }

        //wait for products to load
        WebElement element = null;
        while (element == null) {
            try{
                element = driver.findElement(By.className("product-list__load-more-box"));
            }
            catch(NoSuchElementException ignored) {
            }
        }
        //get products
        Document doc = Jsoup.parse(driver.getPageSource());
        Elements laptopList = doc.select(".box-medium");

        WebElement nextPage = null;
        do {
            try{
                nextPage = driver.findElement(By.className("list-load-more__button"));
                nextPage.click();
                Document doc2 = Jsoup.parse(driver.getPageSource());
                Elements laptopList2 = doc2.select(".box-medium");
                laptopList.addAll(laptopList2);
            }
            catch(NoSuchElementException ignored){
                nextPage = null;
            }
            catch(ElementClickInterceptedException ignored){

            }
        }
        while(nextPage != null);

        for(Element laptop : laptopList) {
            Laptop item = new Laptop();
            item.setName(laptop.text());
            this.laptops.add(item);
        }
    }
}
