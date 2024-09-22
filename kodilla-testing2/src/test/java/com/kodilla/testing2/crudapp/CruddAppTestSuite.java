package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class CruddAppTestSuite {
    private static final String BASE_URL = "https://cdroma.github.io/";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        final String XPATH_TASK_NAME = "/html/body/main/section[1]/form/fieldset[1]/input"; // Zaktualizowany XPath
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea"; // Pozostawiam oryginalny
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        final String XPATH_DELETE_BUTTON = "//div[contains(@class, 'task-container')]//button[contains(@class, 'task-delete')]";

        String taskName = "Task number " + generator.nextInt(100000);            // [1]
        String taskContent = taskName + " content";                              // [2]

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);                                                 // [3]

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);                                           // [4]

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));   // [5]
        addButton.click();                                                       // [6]

        // Użycie WebDriverWait do oczekiwania na przycisk usuwania
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_DELETE_BUTTON))); // [8]
        deleteButton.click();                                                   // [9]
    }

}
