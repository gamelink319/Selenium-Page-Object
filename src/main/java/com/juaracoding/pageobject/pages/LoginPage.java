package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='txtUsername']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='txtPassword']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@name='Submit']")
	private WebElement btnlogin;
	
	public void login() {
		username.sendKeys("admin");
		password.sendKeys("admin1234");
		btnlogin.click();
	}
}
