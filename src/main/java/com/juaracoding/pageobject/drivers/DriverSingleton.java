package com.juaracoding.pageobject.drivers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.juaracoding.pageobject.drivers.strategies.DriverStrategy;
import com.juaracoding.pageobject.drivers.strategies.DriverStrategyImplementer;

public class DriverSingleton {

	private static DriverSingleton instance = null;
	private static WebDriver driver;
	
	private DriverSingleton(String driver) {
		instantiate(driver);
	}
	
	//method
	public WebDriver instantiate(String strategy) {
		DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStategy(strategy);
		driver = driverStrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		return driver;
	}
	
	//method
	public static DriverSingleton getInstance(String drive) {
		if(instance == null) {
			instance = new DriverSingleton(drive);
		}
		return instance;
	}
	
	//method
	public static WebDriver getDriver() {
		return driver;
	}
}
