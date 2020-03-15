package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResultTitle {
    public static void verifyGoogleTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser",
                "automation" );
        for (int i = 0; i < searchStrs.size(); i++) {
            WebElement searchBox = driver.findElement(By.xpath("//input[@title=\"Search\"]"));
            searchBox.sendKeys(searchStrs.get(i) + Keys.ENTER);
            WebElement firstURL = driver.findElement(By.xpath("//cite[@class=\"iUh30 tjvcx\"]"));
            String firstURLStr = "https://"+firstURL.getText()+"/";
            firstURL.click();
            if(driver.getCurrentUrl().equals(firstURLStr)){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
                System.out.println("URL: " + driver.getCurrentUrl());
                System.out.println("Expected URL: " + firstURLStr);
            }
            driver.get("https://google.com");
        }
        driver.close();
    }
}
