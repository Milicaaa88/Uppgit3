package com.example.Uppgift2MilicaPetrovic;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IthsCookiesStep {

        WebDriver driver;
        WebDriverWait wait;


        @Given("I am on the homepage")
        public void i_am_on_the_homepage() {
            driver = new FirefoxDriver();
            driver.get("https://iths.se");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @When("I click on the link")
        public void i_click_on_the_link() {
            WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
            cookiesButton.click();


        }

        @Then("Cookies should be confirmed")
        public void cookies_should_be_confirmed() {
            // Get all buttons and check their innerHTML for the exact match "Tillåt alla"
            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            boolean isButtonPresent = buttons.stream().anyMatch(button -> button.getAttribute("innerHTML").contains("Tillåt alla"));
            Assertions.assertTrue(isButtonPresent, "Cookies not confirmed as button is still present.");
        }
        @io.cucumber.java.After
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
}
