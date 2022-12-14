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
	
	@FindBy(xpath = "//span[@id='spanMessage']")
	private WebElement msgError;
	
	@FindBy(xpath = "//h1[normalize-spave()='Dashboard']")
	private WebElement txtDashboard;
	
	public void login(String username,String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		btnlogin.click();
	}
	
	public String msgInvalid() {
		return msgError.getText();
	}
	public String getTxtDashBoard() {
		return txtDashboard.getText();
	}
}
