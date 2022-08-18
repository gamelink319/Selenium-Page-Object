package com.juaracoding.pageobject.posttest18;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class PostTest18 {
	private WebDriver driver;

	public PostTest18() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='woocommerce-store-notice__dismiss-link']")
	private WebElement btndismiss;

	@FindBy(xpath = "//a[@class='noo-search']")
	private WebElement btnSearch;

	@FindBy(xpath = "//input[@name='s']")
	private WebElement Search;

	@FindBy(xpath = "//div[@class='yith-wcwl-add-button']")
	private WebElement AddToWishlist;

	@FindBy(xpath = "//a[normalize-space()='My Wishlist']")
	private WebElement BtnShowWishlist;

	@FindBy(xpath = "//h1[@class='page-title']")
	private WebElement sukses;

	public void Dismiss() {
		btndismiss.click();
		System.out.println("Btn Dismiss Telah Di klik");
	}

	public void Search(String isi) {
		btnSearch.click();
		System.out.println("Btn Search Telah Di klik");
		Search.sendKeys(isi);
		System.out.println("Telah mengisi search :" + isi);
		Search.sendKeys(Keys.ENTER);
		System.out.println("telah menekan tombol enter");
	}

	public void AddWishlist() {
		AddToWishlist.click();
		System.out.println("telah memasukan ke dalam wishlish");
	}

	public void ShowWishlist() {
		BtnShowWishlist.click();
		System.out.println("membuka wishlist");
	}

	public String WishlistSukses() {
		return sukses.getText();
	}
}
