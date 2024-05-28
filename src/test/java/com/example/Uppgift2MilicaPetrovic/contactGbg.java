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


public class contactGbg {
    WebDriver driver;
    WebDriverWait wait;


    @Given("I want to contact gbg office")
    public void i_want_to_contact_gbg_office() {
        driver = new FirefoxDriver();
        driver.get("https://iths.see");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I click on the nav link contact")
    public void i_click_on_the_nav_link_contact() {
        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        cookiesButton.click();
        WebElement applyHere = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("TILL VÅRA UTBILDNINGAR")));
        applyHere.click();
    }

    @Then("Page should have gothenburg contact field")
    public void page_should_have_gothenburg_contact_field() {
        WebElement breadcrumbs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("breadcrumbs")));
        Assertions.assertTrue(breadcrumbs.isDisplayed(), "Breadcrumbs are not visible.");
    }



}
