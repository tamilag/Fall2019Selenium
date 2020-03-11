package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        checkBoxes.get(0).click(); // click on the first checkbox
        BrowserUtils.wait(2);
        if (checkBoxes.get(1).isDisplayed() && checkBoxes.get(1).isEnabled() &&
                (!checkBoxes.get(1).isSelected())){ //if checkbox is not selected then click
            checkBoxes.get(1).click();//click on the second checkbox
        }

        BrowserUtils.wait(2);

        driver.quit();
    }
}
