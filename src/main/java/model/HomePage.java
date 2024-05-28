package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(linkText = "Manager")
     WebElement managerLink;

    @FindBy(linkText = "New Customer")
     WebElement newCustomerLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isManagerLinkDisplayed() {
        return managerLink.isDisplayed();
    }

    public boolean isNewCustomerLinkDisplayed() {
        return newCustomerLink.isDisplayed();
    }

	public String getHomePageTitle() {
		// TODO Auto-generated method stub
		 return driver.getTitle();
	}
}