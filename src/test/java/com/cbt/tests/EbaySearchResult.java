package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EbaySearchResult {
    public static void verifyEtsySearchFunctionality(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        WebElement numberOfResults = driver.findElement(By.xpath("//h1[@class=\"srp-controls__count-heading\"]/span[1]"));
        String count = numberOfResults.getText().replace(",", "");
        int numOfResultsInt = Integer.parseInt(count);

        WebElement allCategoriesLink = driver.findElement(By.xpath("//li[@class=\"srp-refine__category__item srp-refine__category__list--flush\"]/a"));
        allCategoriesLink.click();
        WebElement numberOfResults2 = driver.findElement(By.xpath("//h1[@class=\"srp-controls__count-heading\"]/span[1]"));
        count = numberOfResults2.getText().replace(",", "");
        int numOfResultsInt2 = Integer.parseInt(count);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        if(numOfResultsInt2 > numOfResultsInt){
            System.out.println("PASS! Number of results in all categories is bigger");
        }else if(numOfResultsInt2 == numOfResultsInt){
            System.out.println("FAIL! Number of results is the same in all categories");
        }else{
            System.out.println("FAIL! Number of results is smaller in all categories");
        }
        driver.navigate().back();
        WebElement searchBox1 = driver.findElement(By.id("gh-ac"));
        String searchValue = searchBox1.getAttribute("value");
        if(searchValue.equals("wooden spoon")){
            System.out.println("PASS! \"wooden spoon\" is still displayed in search box");
        }else{
            System.out.println("FAIL! \"wooden spoon\" is not displayed in search box");
        }
        driver.navigate().back();
        WebElement searchBox2 = driver.findElement(By.id("gh-ac"));
        String searchValue2 = searchBox2.getAttribute("value");
        if(searchValue2.isEmpty()){
            System.out.println("PASS! Search box is empty");
        }else{
            System.out.println("FAIL! Search box is not empty");

        }
        driver.close();

    }
}
