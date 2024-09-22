package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class FacebookTestingApp {

    public static void main(String[] args) {
        // using WebDriver for Firefox
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);

        if (driver != null) {
            // open a Facebook page
            driver.get("https://pl-pl.facebook.com/");

            try {
                // wait for button accept cookies
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Zezwól na wszystkie pliki cookie')]")));
                cookiesButton.click();

                // creating a new account
                WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Utwórz nowe konto')]")));
                createAccountButton.click();

                // set a birthday day
                WebElement daySelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='birthday_day']")));
                Select dayDropdown = new Select(daySelect);
                dayDropdown.selectByVisibleText("13");

                // set a birthday month
                WebElement monthSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='birthday_month']")));
                Select monthDropdown = new Select(monthSelect);
                monthDropdown.selectByVisibleText("Maj");

                // set a birthday year
                WebElement yearSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='birthday_year']")));
                Select yearDropdown = new Select(yearSelect);
                yearDropdown.selectByVisibleText("1974");

            } catch (Exception e) {
                e.printStackTrace(); // show problems if they will appear
            }
        } else {
            System.out.println("Driver is not initialized properly.");
        }
    }
}