package com.juaracoding.pageobject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.SampleFrame;

public class TestSampleFrame {

	public static WebDriver driver;
	private SampleFrame sampleframe;

	@BeforeClass
	public void setUP() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url = "https://demoqa.com/frames";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		sampleframe = new SampleFrame();
	}

	@Test
	public void TestFrame() {
		System.out.println(sampleframe.getTxtOutFrame());
		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		System.out.println(sampleframe.getTxtFrame());
		String txtFrame = sampleframe.getTxtFrame();
		assertTrue(txtFrame.contains("sample page"));	
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
