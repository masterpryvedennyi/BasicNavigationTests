package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class WikipediaURL {
    public static void verifyWikipediaURL(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org");
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("selenium webdriver" + Keys.ENTER);
        String searchItem = "Selenium (software)";
        WebElement seleniumSoftwareURL = driver.findElement(By.linkText("Selenium (software)"));
        seleniumSoftwareURL.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        if(driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("PASS! URL ends with \"Selenium_(software)\"");
        }else{
            System.out.println("FAIL!");
            System.out.println("Search item: Selenium_(software)");
            System.out.println("URL: " + driver.getCurrentUrl());
        }
        driver.close();
    }

}
