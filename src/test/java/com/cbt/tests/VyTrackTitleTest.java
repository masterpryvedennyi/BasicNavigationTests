package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class VyTrackTitleTest {
    public static void verifyTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");
        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        WebElement loginButton = driver.findElement(By.id("_submit"));
        usernameBox.sendKeys("SalesManager110");
        passwordBox.sendKeys("UserUser123");
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        WebElement dropdownMenu = driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
        dropdownMenu.click();
        WebElement myConfiguration = driver.findElement(By.linkText("My Configuration"));
        myConfiguration.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.navigate().refresh();
        String dropdownTitle = driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).getText();
        if(driver.getTitle().startsWith(dropdownTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Title: " + driver.getTitle());
            System.out.println("Account name: " + dropdownMenu.getText());
        }
        driver.close();
    }
}
