package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenCartLoginTestIncorrectPassword {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mafraha\\Downloads\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the login page
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        // Fill in the login form with incorrect password
        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("your_email@example.com");

        WebElement inputPassword = driver.findElement(By.id("input-password"));
        inputPassword.sendKeys("incorrect_password");

        // Click on the login button
        WebDriverWait wait = new WebDriverWait(driver, 30); // Increase timeout to 30 seconds
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit'].btn.btn-primary")));
        loginButton.click();

        // Verification
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger")));
        if (errorMessage.isDisplayed()) {
            System.out.println("Test Passed - Error message displayed for incorrect password!");
        } else {
            System.out.println("Test Failed - No error message displayed for incorrect password.");
        }

        // Close the browser
        driver.quit();
    }
}
