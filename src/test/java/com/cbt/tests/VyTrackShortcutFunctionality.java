package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class VyTrackShortcutFunctionality {
    public static void verifyVyTrachShortcut() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");
        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        WebElement loginButton = driver.findElement(By.id("_submit"));
        usernameBox.sendKeys("SalesManager110");
        passwordBox.sendKeys("UserUser123");
        loginButton.click();
        Thread.sleep(3000);
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASS! You are on dashboard page");
        }else{
            System.out.println("FAIL!");
            System.out.println("Expected title: " + expectedTitle);
            System.out.println("Actual title: " + actualTitle);
        }
        WebElement shorcutsLink = driver.findElement(By.xpath("//a[@title=\"Shortcuts\"]"));
        shorcutsLink.click();
        Thread.sleep(3000);
        WebElement seeFullListLink = driver.findElement(By.linkText("See full list"));
        seeFullListLink.click();
        Thread.sleep(3000);
        WebElement opportunitiesLink = driver.findElement(By.linkText("Opportunities"));
        opportunitiesLink.click();
        Thread.sleep(3000);
        String expectedTitleOpp = "Open Opportunities";
        if(driver.getTitle().startsWith(expectedTitleOpp)){
            System.out.println("PASS! Title starts with \"Open opportunities\"");
        }else{
            System.out.println("FAIL! Title doesnt start with \"Open opportunities\"");
            System.out.println("Actual title: " + driver.getTitle());
        }
        WebElement shorcutsLink2 = driver.findElement(By.xpath("//a[@title=\"Shortcuts\"]"));
        shorcutsLink2.click();
        Thread.sleep(3000);
        WebElement seeFullListLink2 = driver.findElement(By.linkText("See full list"));
        seeFullListLink2.click();
        Thread.sleep(3000);
        WebElement vehicleSeriviceLogsLink = driver.findElement(By.linkText("Vehicle Services Logs"));
        vehicleSeriviceLogsLink.click();
        Thread.sleep(3000);
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class=\"message\"]")).getText();
        String expectedErrorMessage = "You do not have permission to perform this action.";
        if(actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("PASS!");
        }else{
            System.out.println("FAIL!");
            System.out.println("Expected error message: " + expectedErrorMessage);
            System.out.println("Actual error message: " + actualErrorMessage);
        }
        driver.close();

    }
}
