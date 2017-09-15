package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.util.BasePage;
import com.util.GlobalConstants;
import com.util.DriverTestCase.BuildingType;

public class Product_List_Page extends BasePage {

	public Product_List_Page(WebDriver webdriver) {
		super(webdriver);

	}

	@FindBy(xpath = "//a[contains(text(),'Oracle')]")
	public WebElement oracleQuoteToOrderManagerLink;

	@FindBy(xpath = "//a[text()='Ethernet']")
	public WebElement ethernetButton;

	@FindBy(xpath = "//a[text()='Ethernet Line']")
	public WebElement ethernetLineLink;

	@FindBy(xpath = "//a[text()='Ethernet Hub and Spoke']")
	public WebElement ethernetHubSpokeLink;

	public void AddproductType(String type) throws InterruptedException {

		//mouseOver(ethernetButton);
		if (type.equals("Ethernet"))
			ethernetLineLink.click();
		if (type.equals("Hub"))
			ethernetHubSpokeLink.click();
		
		waitForAjaxRequestsToComplete();

	}
	
	public void clickOnOrderManagerLink()
	{
		javascriptScrollIntoView(oracleQuoteToOrderManagerLink);
		//waitForElementVisible(oracleQuoteToOrderManagerLink);
		waitAndClick(oracleQuoteToOrderManagerLink);
		_waitForJStoLoad();
		reportLog("Click on Order Manager Link");
	}
}
