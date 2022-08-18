package com.juaracoding.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.SampleForm;

public class TestSampleForm {
	public static WebDriver driver;
	private SampleForm sampleform;

	@BeforeClass
	public void setUP() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url = "https://demoqa.com/automation-practice-form";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		sampleform = new SampleForm();
	}

	@Test
	public void testform() {
		sampleform.pilihgender(0);
		sampleform.pilihgender(1);
		sampleform.pilihgender(2);
	}

	@Test
	public void testformHobi() {
		sampleform.pilihhobbie(0);
		sampleform.pilihhobbie(1);
		sampleform.pilihhobbie(2);
	}

	@Test
	public void testformUpload() {
		sampleform.UploadGambar();
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
