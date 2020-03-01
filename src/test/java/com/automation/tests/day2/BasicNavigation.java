package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        //to start selenium script we need:
        //setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); //OR
        //WebDriver driver = new ChromeDriver(); OR
        //RemoteWebDriver driver = new ChromeDriver();
        //In selenium everything starts from WebDriver interface
        driver.get("http://google.com"); //to open a website
        //Thread.sleep(3000);  // for demo wait 3 seconds
        String title = driver.getTitle(); // returns <title> Some title </title> text

        System.out.println(title);
        String expectedTitle = "Google";
        if (expectedTitle.equals(title)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        driver.close(); //to close browser

    }
}
