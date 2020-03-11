package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) throws Exception {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);

        //how to collect all links from the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
//            link.click();
//            Thread.sleep(2000);
//            driver.navigate().back(); //go back
            //StaleElementReferenceException - means that selenium cannot find previously located element.
            // It happens when you are trying to interact with element after page refresh or navigation
        }

        for (int i = 1; i < links.size(); i++) {
            links.get(i).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            //in order not to get StaleElementReferenceException, refresh list
            links=driver.findElements(By.tagName("a")); //here you just recollect the links again
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
