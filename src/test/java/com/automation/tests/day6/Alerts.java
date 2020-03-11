package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));



        buttons.get(2).click();
        BrowserUtils.wait(3);
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();
        BrowserUtils.wait(3);
        String expected3 = "Hello World";
        String actual3 = driver.findElement(By.id("result")).getText();
        if (actual3.endsWith(expected3)){
            System.out.println("TEST 3 is passed");
        }else{
            System.out.println("TEST 3 is failed");
            System.out.println("expected 3: " + expected3);
            System.out.println("actual 3: " + actual3);
        }

        BrowserUtils.wait(3);
        driver.quit();
    }
}
