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

public class applyForCourse {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I am on the home page iths")
    public void i_am_on_the_home_page_iths() {
        driver = new FirefoxDriver();
        driver.get("https://www.iths.se"); // Adjust the URL to your homepage
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I click on the link to read more and later to apply link")
    public void i_click_on_the_link_to_read_more_and_later_to_apply_link() {
        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        cookiesButton.click();
        WebElement readMoreLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.promo__btn.btn[href='https://www.iths.se/ansokan-it-hogskolan/']")));
        readMoreLink.click();
        WebElement applyButton = driver.findElement(By.xpath("//button[text()='Ansök här!']"));
        applyButton.click();
    }

    @Then("Second link should take me to application page")
    public void Second_link_should_take_me_to_the_application_page() {
        String expectedUrl = "yh-antagning.se"; // Adjust the expected URL
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expectedUrl), "The URL after clicking the apply link is incorrect.");
    }

    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
