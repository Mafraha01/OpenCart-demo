package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginButtonDisabledTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mafraha\\Downloads\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Step 1: Navigate to the login page
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        // Step 2: Verify the state of the login button (it should be disabled)
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit'].btn.btn-primary"));
        if (!loginButton.isEnabled()) {
            System.out.println("Login button is initially disabled.");
        } else {
            System.out.println("Login button is initially enabled.");
        }

        // Step 3: Enter a valid email
        WebElement emailField = driver.findElement(By.id("input-email"));
        emailField.sendKeys("your_email@example.com");

        // Step 4: Enter a valid password
        WebElement passwordField = driver.findElement(By.id("input-password"));
        passwordField.sendKeys("your_password");

        // Expected Result: The login button should become enabled only after both fields are filled
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        if (loginButton.isEnabled()) {
            System.out.println("Test Passed - Login button is enabled after filling both fields.");
        } else {
            System.out.println("Test Failed - Login button is not enabled after filling both fields.");
        }

        // Close the browser
        driver.quit();
    }
}
