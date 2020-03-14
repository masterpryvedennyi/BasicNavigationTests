package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NavigationTests {
    public static void main(String[] args) throws InterruptedException{
        ChromeTest();
        FirefoxTest();
        SafariTest();
    }
    private static void ChromeTest() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        String googleTitle = driver.getTitle();
        driver.get("https://etsy.com");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        StringUtility.verifyEquals(googleTitle, driver.getTitle());
        driver.navigate().forward();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        StringUtility.verifyEquals(etsyTitle, driver.getTitle());
        driver.close();
    }

    private static void FirefoxTest() throws InterruptedException{
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        String googleTitle = driver.getTitle();
        driver.get("https://etsy.com");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        StringUtility.verifyEquals(googleTitle, driver.getTitle());
        driver.navigate().forward();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        StringUtility.verifyEquals(etsyTitle, driver.getTitle());
        driver.close();
    }

    private static void SafariTest() throws InterruptedException{
        WebDriver driver = BrowserFactory.getDriver("safari");
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        String googleTitle = driver.getTitle();
        driver.get("https://etsy.com");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        StringUtility.verifyEquals(googleTitle, driver.getTitle());
        driver.navigate().forward();
        Thread.sleep(3000);
        StringUtility.verifyEquals(etsyTitle, driver.getTitle());
        driver.close();
    }
}
