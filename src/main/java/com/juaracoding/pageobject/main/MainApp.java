package com.juaracoding.pageobject.main;

import org.openqa.selenium.WebDriver;
import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.loginRegister.login;
import com.juaracoding.pageobject.loginRegister.register;

public class MainApp {

	public static void main(String[] args) {
		
		DriverSingleton.getInstance("Firefox");
		WebDriver driver = DriverSingleton.getDriver();
		String url ="https://shop.demoqa.com";
		driver.get(url);
		
		register Register =new register();
		Register.RegShop();
		
		delay(5);
		
		login Login =new login();
		Login.loginShop();
		Login.loginsucces();
		
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
