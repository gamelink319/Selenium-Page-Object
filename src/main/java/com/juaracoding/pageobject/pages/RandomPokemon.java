package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class RandomPokemon {

	private WebDriver driver;
	
	public RandomPokemon() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@id='n']")
	private WebElement PilihJumlah;
	
	@FindBy(xpath = "//select[@id='region']")
	private WebElement PilihRegion;
	
	@FindBy(xpath = "//select[@id='type']")
	private WebElement PilihTipe;
	
	@FindBy(xpath = "//input[@id='sprites']")
	private WebElement ChkBoxSprites;
	
	@FindBy(xpath = "//input[@id='natures']")
	private WebElement ChkBoxNatures;
	
	@FindBy(xpath = "//input[@value='Generate']")
	private WebElement BtnGenerate;
	
	public void GeneratePokemon() {
		Select selectJumlah = new Select(PilihJumlah);
		Select selectRegion = new Select(PilihRegion);
		Select selectTipe = new Select(PilihTipe);
		selectJumlah.selectByValue("3");
		selectRegion.selectByValue("hoenn");
		selectTipe.selectByValue("dragon");
		ChkBoxNatures.click();
		ChkBoxSprites.click();
		BtnGenerate.click();
	}
	
}
