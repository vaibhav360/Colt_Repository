package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.util.BasePage;

public class Transaction_Page extends BasePage {

	public Transaction_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "quoteName_t")
	public WebElement quoteName;

	@FindBy(id = "title_t")
	public WebElement quoteDescription;

	@FindBy(id = "add_product")
	public WebElement addProductButton;

	@FindBy(id = "save")
	public WebElement saveButtons;

	@FindBy(id = "//*[@name='pricingSegment_t']")
	public WebElement smeSegment;

	@FindBy(id = "readonly_1_currency_t")
	public WebElement currency;

	@FindBy(xpath = "//*[@id='field_wrapper_1_pricingSegment_t']/div[1]")
	public WebElement segment;
	
	public void enterQuoteNameDescription(String name, String desc) {
		verifyElementPresent(quoteName);
	}

	public String getUICurrencyType() {
		String type = currency.getText();
		return type;
	}
	
	public String getUISegment() {
		String type = segment.getText();
		return type;
	}

	public void clickOnAddProductBtn()
	{
		javascriptScrollIntoView(addProductButton);
		click(addProductButton);
	}
}
