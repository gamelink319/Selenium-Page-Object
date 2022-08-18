package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.posttest18.PostTest18;

public class TestPostTest18 {
	public static WebDriver driver;

	private PostTest18 posttest18;

	@BeforeClass
	public void setUP() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		posttest18 = new PostTest18();
	}

	@Test(priority = 1)
	public void testSearchSatu() {
		posttest18.Dismiss();
		posttest18.Search("Black Lux");
		delay(3);
		scroll(400);
		posttest18.AddWishlist();
		delay(3);
	}

	@Test(priority = 2)
	public void testSearchDua() {
		scroll(-400);
		posttest18.Search("Playboy X");
		scroll(400);
		delay(3);
		posttest18.AddWishlist();
		delay(3);
		scroll(-400);
		posttest18.ShowWishlist();
		assertEquals(posttest18.WishlistSukses(), "WISHLIST");
		System.out.println("Test Selesai");
		scroll(400);
	}

	@AfterClass
	public void CloseBrowser() {
		delay(5);
		driver.quit();
	}

	public void delay(int detik) {
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
