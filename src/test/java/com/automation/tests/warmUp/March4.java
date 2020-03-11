package com.automation.tests.warmUp;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.security.Key;

public class March4 {
    public static void main(String[] args) {
//        ebayTest();
//        amazonTest();
        wikiTest();




    }

    public static void ebayTest (){
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("coffee");
        driver.findElement(By.id("gh-btn")).click();
        System.out.println(driver.findElement(By.tagName("h1")).getText().split(" ")[0]);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }

    public static void amazonTest () {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        if (driver.getTitle().contains("java book")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.quit();
    }

    public static void wikiTest () {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)", Keys.ENTER);
        if (driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("Wiki Test Passed");
        }else{
            System.out.println("Wiki Test Failed");
        }
    }



}
