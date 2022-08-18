package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class SampleAlert {

	private WebDriver driver;

	public SampleAlert() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='confirmResult']")
	private WebElement txtConfrimResult;

	@FindBy(xpath = "//span[@id='promptResult']")
	private WebElement txtPromptResuld;

	@FindBy(xpath = "//button[@id='confirmButton']")
	private WebElement BtnConfrim;

	@FindBy(xpath = "//button[@id='promtButton']")
	private WebElement BtnPrompt;

	public void clickMe() {
		BtnConfrim.click();
	}

	public String getTxtConfrimResult() {
		return txtConfrimResult.getText();
	}

	public void clickMe2() {
		BtnPrompt.click();
	}

	public String getTxtPromtResult() {
		return txtPromptResuld.getText();
	}

}
