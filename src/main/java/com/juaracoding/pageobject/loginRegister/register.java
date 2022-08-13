package com.juaracoding.pageobject.loginRegister;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class register {

	private WebDriver driver;
	
	public register() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='woocommerce-store-notice__dismiss-link']")
	private WebElement btndismiss;
	
	@FindBy(xpath = "//a[@href='https://shop.demoqa.com/my-account/']")
	private WebElement btnmasuk;
	
	@FindBy(xpath = "//input[@id='reg_username']")
	private WebElement isinama;
	
	@FindBy(xpath = "//input[@id='reg_email']")
	private WebElement isiemail;
	
	@FindBy(xpath = "//input[@id='reg_password']")
	private WebElement isipassword;
	
	@FindBy(xpath = "//button[@name='register']")
	private WebElement btnReg;
	
	public void RegShop() {
	
		String reguser = "dhannaputra4";
		String regemail = "dhannaputra4@gmail.com";
		String regpass ="1sampai8888";
		
		btndismiss.click();
			System.out.println("alert berhasil di klik");
		btnmasuk.click();
			System.out.println("masuk ke account perdaftaran");
		delay(5);
		isinama.sendKeys(reguser);
			System.out.println("mengisi nama");
		isiemail.sendKeys(regemail);
			System.out.println("mengisi email");
		isipassword.sendKeys(regpass);
			System.out.println("mengisi password");
		btnReg.click();
			System.out.println("klik tombol register");
	}
	
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
	}	
}
