package com.juaracoding.pageobject.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class SampleForm {

	private WebDriver driver;

	public SampleForm() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	// label[contains(@for,'gender-radio')]
	@FindBy(xpath = "//label[contains(@for,'gender-radio')]")
	private List<WebElement> Gender;

	@FindBy(xpath = "//label[contains(@for,'hobbies-checkbox')]")
	private List<WebElement> Hobbie;

	@FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div/div[1]/span[1]/div[1]")
	private WebElement MenuElement;

	@FindBy(xpath = "//div[@class='element-list collapse show']//li[contains(@id='item')]")
	private List<WebElement> ListMenuElement;

	@FindBy(xpath = "//input[@id='uploadPicture']")
	private WebElement UploadFile;

	public void pilihgender(int pilih) {
		Gender.get(pilih).click();
		System.out.println(Gender.get(pilih).getText());
	}

	public void pilihhobbie(int pilihhobi) {
		Hobbie.get(pilihhobi).click();
		System.out.println(Hobbie.get(pilihhobi).getText());
	}

	public void pilihMenuElement() {
		MenuElement.click();
		ListMenuElement.get(0).click();
		System.out.println(ListMenuElement.get(0).getText());
	}

	public void UploadGambar() {
		UploadFile.sendKeys("C:\\Users\\Xh\\OneDrive\\Pictures\\ss.PNG");
	}
}
