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


public class breadcrumbs {
    WebDriver driver;
    WebDriverWait wait;


    @Given("I want to see all courses")
    public void i_want_to_see_all_courses() {
        driver = new FirefoxDriver();
        driver.get("https://iths.se");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I click on the link all our courses")
    public void i_click_on_the_link_all_our_courses() {
        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        cookiesButton.click();
        WebElement navContact = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-kontakt")));
        navContact.click();
    }

    @Then("Page should have breadcrumbs")
    public void page_should_have_breadcrumbs() {
        WebElement contactGbg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Kontakt Göteborg']")));
        Assertions.assertFalse(contactGbg.isDisplayed(), "The 'Kontakt Göteborg' h2 tag is not visible.");
    }

    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
