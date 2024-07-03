package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTitleTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mafraha\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://demo.opencart.com");

            // Verify the page title
            String expectedTitle = "Your Store";
            String actualTitle = driver.getTitle();
            assert actualTitle.equals(expectedTitle) : "Page title mismatch. Expected: " + expectedTitle + " but got: " + actualTitle;

        } finally {
            driver.quit();
        }
    }
}

