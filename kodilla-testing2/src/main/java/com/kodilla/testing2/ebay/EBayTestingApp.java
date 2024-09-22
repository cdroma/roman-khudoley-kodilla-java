package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {

    public static final String SEARCH_FIELD = "gh-ac";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);

        if (driver != null) {

            driver.get("https://www.ebay.com/");

            WebElement searchField = driver.findElement(By.id(SEARCH_FIELD));

            searchField.sendKeys("Laptop");

            searchField.submit();
        } else {
            System.out.println("Driver is not initialized properly.");
        }
    }
}
