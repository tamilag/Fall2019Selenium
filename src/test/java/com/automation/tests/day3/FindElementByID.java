package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByID {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        // -- By name --
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(3000);
//        WebElement password = driver.findElement(By.name("password"));
//        password.sendKeys("SuperSecretPassword");
//        OR
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(3000);
        // -- By ID --
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();
        if (expected.equals(actual)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        //Let's click on logout button. It looks like a button, but it's actually a link
        //every element with <a> tag is a link

        WebElement logout = driver.findElement(By.linkText("Logout"));
        String href = logout.getAttribute("href");
        System.out.println(href);
        logout.click();
        Thread.sleep(3000);

        driver.quit();
    }
}
