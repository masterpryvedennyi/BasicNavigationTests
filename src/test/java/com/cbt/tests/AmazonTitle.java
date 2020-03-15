package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTitle {
    public static void verifyAmazonTitle() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        String searchItem = "sunglasses";
        searchBox.sendKeys(searchItem + Keys.ENTER);
        if(driver.getTitle().contains(searchItem)){
            System.out.println("PASS! Title contains search item");
        }else{
            System.out.println("FAIL!");
            System.out.println("Search item "+ searchItem);
            System.out.println("Title: " + driver.getTitle());
        }
        driver.close();
    }
}
