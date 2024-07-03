package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenCartLoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mafraha\\Downloads\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the login page
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        // Fill in the login form
        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("your_email@example.com");

        WebElement inputPassword = driver.findElement(By.id("input-password"));
        inputPassword.sendKeys("your_password");

        // Click on the login button
        WebDriverWait wait = new WebDriverWait(driver, 30); // Increase timeout to 30 seconds
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit'].btn.btn-primary")));
        loginButton.click();

        // Verification
        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));
        if (myAccount.isDisplayed()) {
            System.out.println("Login Successful - Test Passed!");
        } else {
            System.out.println("Login Failed - Test Failed!");
        }

        // Close the browser
        driver.quit();
    }
}
