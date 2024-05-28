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

public class mobileAppLink {

    WebDriver driver;
    WebDriverWait wait;


    @Given("I want to get mobile app")
    public void i_want_to_get_mobile_app() {
        driver = new FirefoxDriver();
        driver.get("https://iths.se");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I click on the link student portal")
    public void i_click_on_the_link_student_portal() {
        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        cookiesButton.click();
        WebElement studentPortal = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-studentportaliclassfarfasigninalti")));
        studentPortal.click();
    }

    @Then("Page should have link to mobile app")
    public void page_should_have_link_to_mobile_app() {
        WebElement contactGbg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Hämta mobilappen']")));
        Assertions.assertTrue(contactGbg.isDisplayed(), "There is no link text Hämta mobilappen");
    }

    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
