package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;
import com.juaracoding.pageobject.pages.LoginSiloan;

public class TestLoginSiloan {
	
	public static WebDriver driver;
	private LoginSiloan loginsiloan;
	
	@BeforeClass
	public void setUP() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url ="https://dev.ptdika.com/siloam/panel/login";
		driver.get(url);
	}
	
	@BeforeMethod
	public void pageObject() {
		loginsiloan = new LoginSiloan();
	}
	
	
	@Test
	public void testInvalidlogin() {
	loginsiloan.login("","");
	System.out.println(loginsiloan.getAttributeRequired());
	assertEquals(loginsiloan.getAttributeRequired(),"true");
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
