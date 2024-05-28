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
import java.util.ArrayList;

public class quizUrl {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I am on homepage")
    public void i_am_on_homepage() {
        driver = new FirefoxDriver();
        driver.get("https://iths.se");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I start quiz")
    public void i_start_quiz() {
        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        cookiesButton.click();
        WebElement doQuiz = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Gör quizet']")));
        doQuiz.click();

        // Switch to the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

    }

    @Then("I want to check url")
    public void i_want_to_check_url() {
        boolean urlIsCorrect = wait.until(ExpectedConditions.urlToBe("https://www.iths.se/vilken-utbildning-passar-mig/"));

        Assertions.assertTrue(urlIsCorrect, "The current URL is not as expected.");

    }

    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
