package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mafraha\\Downloads\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        //Navigate to the login page
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        //Click on the "Forgot Password" link
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgotten Password"));
        forgotPasswordLink.click();

        // Expected Result: The system should redirect to the recovery page
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.urlContains("route=account/forgotten"));

        if (driver.getCurrentUrl().contains("route=account/forgotten")) {
            System.out.println("Test Passed - Redirected to the password recovery page!");
        } else {
            System.out.println("Test Failed - Not redirected to the password recovery page.");
        }

        // Close the browser
        driver.quit();
    }
}
