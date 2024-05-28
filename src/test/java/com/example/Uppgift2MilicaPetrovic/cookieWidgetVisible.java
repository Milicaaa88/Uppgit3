package com.example.Uppgift2MilicaPetrovic;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class cookieWidgetVisible {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I want to setup cookies")
    public void i_want_to_setup_cookies() {
        driver = new FirefoxDriver();
        driver.get("https://iths.se");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I open homepage")
    public void i_open_homepage() {
        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        cookiesButton.click();
    }

    @Then("Cookie settings button should be visible")
    public void cookie_settings_button_should_be_visible() {
        WebElement cookieWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CookiebotWidget")));
        Assertions.assertTrue(cookieWidget.isDisplayed(), "There is no cookie widget");
    }
}
