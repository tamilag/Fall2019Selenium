package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyIfElementIsGone {
    //Interview question:
    //how to check if element doesn't exist anymore in DOM (Document Object Model - html)
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);
        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);
        if (driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for (WebElement button : buttons) {
            button.click(); // no need to refresh here like in previous class because
            Thread.sleep(2000);
        }
        driver.quit();
    }
}
