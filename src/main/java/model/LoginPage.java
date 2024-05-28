package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
     WebDriver driver;

    @FindBy(name = "uid")
     WebElement userIdInput;

    @FindBy(name = "password")
     WebElement passwordInput;

    @FindBy(name = "btnLogin")
     WebElement loginButton;

    @FindBy(name = "btnReset")
     WebElement resetButton;

    @FindBy(linkText = "Selenium")
     WebElement seleniumLink;

    @FindBy(linkText = "Insurance Project")
     WebElement insuranceProjectLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String userId, String password) {
        userIdInput.sendKeys(userId);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean isUserIdInputDisplayed() {
        return userIdInput.isDisplayed();
    }

    public boolean isPasswordInputDisplayed() {
        return passwordInput.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public boolean isResetButtonDisplayed() {
        return resetButton.isDisplayed();
    }

    public boolean isSeleniumLinkDisplayed() {
        return seleniumLink.isDisplayed();
    }

    public boolean isInsuranceProjectLinkDisplayed() {
        return insuranceProjectLink.isDisplayed();
    }
}