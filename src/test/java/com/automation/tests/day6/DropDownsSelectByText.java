package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownsSelectByText {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        //create a webelement object for dropdown
        WebElement simpleDropDown = driver.findElement(By.id("dropdown"));
        //provide webelement object into constructor
        Select selectSimpleDropDown = new Select (simpleDropDown);
        //select by visible text
        selectSimpleDropDown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        selectSimpleDropDown.selectByVisibleText("Option 1");
        //
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));
        selectYear.selectByVisibleText("1989");
        selectMonth.selectByVisibleText("March");
        selectDay.selectByVisibleText("21");
        BrowserUtils.wait(3);
        //get the month name and select based on that
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement eachMonth:months) {
            //get the month name and select based on that
            selectMonth.selectByVisibleText(eachMonth.getText());
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(5);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District Of Columbia");

        //option that is currently selected
        //getFirstSelectedOption() -- returns a webelement, that's why we need to call getText() method
        // getText() retrieves visible text from the webelement
        String selected = stateSelect.getFirstSelectedOption().getText();

        if (selected.equals("District Of Columbia")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }


        List<WebElement> states = stateSelect.getOptions();
        for (WebElement stateOption : states ) {
            System.out.println(stateOption.getText()); //getText return value inside every item in states collection

        }



        BrowserUtils.wait(3);
        driver.quit();
    }
}
