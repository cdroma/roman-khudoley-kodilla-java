package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public class GoogleTestingApp {

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);  // [1]
        driver.get("https://www.google.com");                                   // [2]
    }
}
