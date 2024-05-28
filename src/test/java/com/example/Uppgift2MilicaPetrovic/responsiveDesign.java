package com.example.Uppgift2MilicaPetrovic;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class responsiveDesign {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I am on iths homepage")
    public void i_am_on_iths_homepage() {
        driver = new FirefoxDriver();
        driver.get("https://www.iths.se/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I adjust the screen size")
    public void i_adjust_the_screen_size() {
        driver.manage().window().setSize(new Dimension(1250, 800)); // Set width to less than 1260px
    }

    @Then("I check if hamburger menu is visible")
    public void i_check_if_hamburger_menu_is_visible() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile-toggle")));
        Assertions.assertTrue(button.isDisplayed(), "The button is not visible at 1250px width.");
    }

    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
