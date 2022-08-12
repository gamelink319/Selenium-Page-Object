package com.juaracoding.pageobject.main;

import org.openqa.selenium.WebDriver;
import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;

public class MainApp {

	public static void main(String[] args) {
		
		DriverSingleton.getInstance("Firefox");
		WebDriver driver = DriverSingleton.getDriver();
		String url ="https://opensource-demo.orangehrmlive.com";
		driver.get(url);
		
		LoginPage loginpage =new LoginPage();
		loginpage.login();
		
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
