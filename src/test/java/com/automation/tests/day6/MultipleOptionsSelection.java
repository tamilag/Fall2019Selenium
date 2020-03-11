package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultipleOptionsSelection {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select languagesSelect = new Select (driver.findElement(By.name("Languages")));
        // Whether this select element support selecting multiple options at the same time? This
//         is done by checking the value of the "multiple" attribute.
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple); // -> true
        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");
        //let's get all selected options
        List<WebElement> selectLanguages = languagesSelect.getAllSelectedOptions();
        for (WebElement eachLanguage : selectLanguages){
            System.out.println(eachLanguage.getText());
        }
        BrowserUtils.wait(3);
        languagesSelect.deselectByVisibleText("Java");
        BrowserUtils.wait(3);
        languagesSelect.deselectAll();





        BrowserUtils.wait(3);
        driver.quit();
    }
}
