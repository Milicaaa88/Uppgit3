package com.example.Uppgift2MilicaPetrovic;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class sliderExists {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("User opens iths page")
    public void user_opens_iths_page() {
        driver = new FirefoxDriver();
        driver.get("https://www.iths.se");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Then("There should be quote slider")
    public void there_should_be_quote_slider() {
        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        cookiesButton.click();
        WebElement quoteSlider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slide__container"))); // Change "quote-slider" to the actual ID or another selector
        Assertions.assertTrue(quoteSlider.isDisplayed(), "Quote slider container is not visible on the page.");
    }

    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
