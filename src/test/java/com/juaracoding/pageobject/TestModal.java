package com.juaracoding.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.Modal;

public class TestModal {
	public static WebDriver driver;
	private Modal modal;

	@BeforeClass
	public void setUP() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url = "https://demoqa.com/modal-dialogs";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		modal = new Modal();
	}

	@Test
	public void testmodal() {
		modal.clickSmallModal();
		System.out.println(modal.getTitleModal());
		System.out.println(modal.getBodyModal());
	}

	@AfterClass
	public void CloseBrowser() {
		delay(5);
		driver.quit();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
