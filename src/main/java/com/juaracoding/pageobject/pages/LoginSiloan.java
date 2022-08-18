package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class LoginSiloan {

	private WebDriver driver;
	
	public LoginSiloan() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnlogin;
	
	public void login(String username,String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		btnlogin.click();
	}
	public String getAttributeRequired() {
		return username.getAttribute("required");
	}
	
}
