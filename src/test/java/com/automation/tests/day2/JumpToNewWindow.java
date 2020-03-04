package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToNewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        // every window has some ID, this ID call window handle
        // based on window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle();//returns IDs of all currently opened windows
        System.out.println(windowHandle);
        System.out.println("Before switch : "+driver.getCurrentUrl());
        Set<String> windowHandles = driver.getWindowHandles(); //this will make suer that we will not have duplicates
        System.out.println(windowHandles);

        //since we have all windows
        // and we know Id of original window
        //we can say switch to something that is not equals to old windows

        for (String windowId:windowHandles) {
            if (! windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("After switch : "+driver.getCurrentUrl());
        driver.close();
    }

    public static void switchToWindowBasedOnTitle (String pageTitle, WebDriver driver){
        Set <String > windows = driver.getWindowHandles();
        for (String window:windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }
}
