package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(1);
        //task: verify if 1st chbx is not selected and 2nd is selected
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        if (!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        BrowserUtils.wait(1);
        //let's click on the first chkbx and verify it's clicked
        WebElement checkBox1 = checkBoxes.get(0); //to get first chkbx
        checkBox1.click(); // clickon it

        if (checkBox1.isSelected()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Checkbox # 1 is not selected");
        }
        driver.quit();
    }
}
