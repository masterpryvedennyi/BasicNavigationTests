package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TitleVerificationTests {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        String expectedTitle = "";
        for (int i = 0; i < urls.size(); i++) {
            driver.get(urls.get(i));
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            if(expectedTitle.isEmpty()){
                expectedTitle = driver.getTitle();
            }
                if(driver.getTitle().equals(expectedTitle)){
                    System.out.println("Titles match");
                }else{
                    System.out.println("Titles do not match");
                    System.out.println("Expected Title " + expectedTitle +"\n" +
                    "Actual title " + driver.getTitle());
                }
            String expectedPartialTitle = "http://practice.cybertekschool.com";
            if(driver.getCurrentUrl().startsWith(expectedPartialTitle)){
                System.out.println("PASS");
                System.out.println("URL starts with " + expectedPartialTitle);
            }else{
                System.out.println("FAIL! URLs do not match");
                System.out.println("Expected partial URL " + expectedPartialTitle + "\n" +
                        "Actual URL " + driver.getCurrentUrl());
            }

        }
        driver.close();

    }
}
