package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com", "https://www.westelm.com", "https://walmart.com");
        String title = "";
        for (int i = 0; i < urls.size(); i++) {
            driver.get(urls.get(i));
            title = driver.getTitle().toLowerCase().replace(" ", "");
            if(driver.getCurrentUrl().contains(title)){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL! URL doesnt contain title");
                System.out.println("title: " + title);
                System.out.println("URL: " + driver.getCurrentUrl());
            }
        }
        driver.close();
    }
}
