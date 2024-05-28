package com.example.Uppgift2MilicaPetrovic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class checkTestningCategory {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("Exploring homepage")
    public void exploring_homepage() {
        driver = new FirefoxDriver(); // Assuming using FirefoxDriver, configure path accordingly
        driver.get("https://www.iths.se"); // Replace with your actual homepage URL
        wait = new WebDriverWait(driver,  Duration.ofSeconds(10)); // Setup wait time
    }

    @When("I click on the link utbildningar")
    public void i_click_on_the_link_utbildningar() {
        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        cookiesButton.click();
        WebElement utbildningarLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-utbildningar"))); // Replace with actual ID or selector
        utbildningarLink.click();
    }

    @Then("There should be category testning")
    public void there_should_be_category_testning() {
        WebElement testningCategory = driver.findElement(By.cssSelector("label.sf-label-radio[for='sf-input-ace157812002b570621c3803d4a24859']")); // Replace with actual ID or selector
        Assertions.assertTrue(testningCategory.isDisplayed(), "Testning category is not displayed on the page");
    }

    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
