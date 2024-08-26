package org.example.skyhms.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators for login page elements
    private By propertyId = By.id("propId");
    private By usernameField = By.id("userId");
    private By passwordField = By.id("userPwd");
    private By loginButton = By.id("btnUser");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPropertyid(String propertyid) {
        driver.findElement(propertyId).sendKeys(propertyid);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
