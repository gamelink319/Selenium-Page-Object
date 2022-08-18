package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;

public class TestLogin {
	
	public static WebDriver driver;
	private LoginPage loginpage;
	
	@BeforeClass
	public void setUP() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url ="https://opensource-demo.orangehrmlive.com/";
		driver.get(url);
	}
	
	@BeforeMethod
	public void pageObject() {
		loginpage = new LoginPage();
	}
	
	@Test
	public void testMissingUsername() {
		loginpage.login("","admin1234");
		assertEquals(loginpage.msgInvalid(), "Username cannot be empty");
	}
	
	@Test
	public void testInvalidlogin() {
		loginpage.login("admin","admin1234");
		assertEquals(loginpage.msgInvalid(), "Invalid credentials");
	}
	
	@Test
	public void testValidlogin() {
		loginpage.login("admin","admin123");
		assertEquals(loginpage.getTxtDashBoard(),"Dashboard");	
	}
	
	@AfterClass
	public void CloseBrowser(){
	delay(5);
	driver.quit();
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
