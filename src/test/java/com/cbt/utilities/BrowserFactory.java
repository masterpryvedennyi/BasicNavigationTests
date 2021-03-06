package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().fullscreen();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
            driver.manage().window().fullscreen();
        }else {
            return null;
        }
        return driver;
    }
}
