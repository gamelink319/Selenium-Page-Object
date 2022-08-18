package com.juaracoding.pageobject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.SampleAlert;

public class TestSampleAlert {

	public static WebDriver driver;
	private SampleAlert samplealert;

	@BeforeClass
	public void setUP() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url = "https://demoqa.com/alerts";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		samplealert = new SampleAlert();
	}

	@Test
	public void TestAlert() {
		
		samplealert.clickMe();
		delay(2);
		String txtalert = driver.switchTo().alert().getText();
		delay(1);
		driver.switchTo().alert().dismiss(); // bisa menggunakan Accept()
		System.out.println(samplealert.getTxtConfrimResult());
		String txt = samplealert.getTxtConfrimResult();
		System.out.println(txtalert);
		assertTrue(txt.contains("Cancel"));
	}

	@Test
	public void TestAlert2() {
		scroll(700);
		samplealert.clickMe2();
		delay(2);
		driver.switchTo().alert().sendKeys("test");
		delay(2);
		driver.switchTo().alert().accept();
		System.out.println(samplealert.getTxtPromtResult());
		String txt2 = samplealert.getTxtPromtResult();
		assertTrue(txt2.contains("test"));
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

	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0," + vertical + ")");
	}
}
