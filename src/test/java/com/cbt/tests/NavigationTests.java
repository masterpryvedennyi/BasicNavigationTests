package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) throws InterruptedException{
        ChromeTest();
        FirefoxTest();
    }
    private static void ChromeTest() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        Thread.sleep(3000);
        String googleTitle = driver.getTitle();
        driver.get("https://etsy.com");
        Thread.sleep(3000);
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        Thread.sleep(3000);
        StringUtility.verifyEquals(googleTitle, driver.getTitle());
        driver.navigate().forward();
        Thread.sleep(3000);
        StringUtility.verifyEquals(etsyTitle, driver.getTitle());
        driver.close();
    }

    private static void FirefoxTest() throws InterruptedException{
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        Thread.sleep(3000);
        String googleTitle = driver.getTitle();
        driver.get("https://etsy.com");
        Thread.sleep(3000);
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        Thread.sleep(3000);
        StringUtility.verifyEquals(googleTitle, driver.getTitle());
        driver.navigate().forward();
        Thread.sleep(3000);
        StringUtility.verifyEquals(etsyTitle, driver.getTitle());
        driver.close();
    }
}
