package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(5);
        WebElement upload = driver.findElement(By.id("file-upload"));
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir")+"/pom.xml";

        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(5);
        System.out.println(filePath);
        driver.quit();
    }
}
