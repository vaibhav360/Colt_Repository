package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.util.BasePage;

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

		waitForAjaxRequestsToComplete();
		transactionPage.clickOnAddProductBtn();
		reportLog("Click on to AddProduct button");
		_waitForJStoLoad();
		ethernetButton.click();
		reportLog("Mouse move to EtherNet link");

		if (type.equals("Ethernet")) {
			ethernetLineLink.click();
			reportLog("Click on to EnternetLine Product");

		}
		if (type.equals("Hub")) {
			ethernetHubSpokeLink.click();
		}
		_waitForJStoLoad();
		waitForAjaxRequestsToComplete();
		verifyTitle("Model Configuration");
		reportLog("Verifying the title 'Model Configuration'");

	}

	public void clickOnOrderManagerLink() {
		javascriptScrollIntoView(oracleQuoteToOrderManagerLink);
		// waitForElementVisible(oracleQuoteToOrderManagerLink);
		waitAndClick(oracleQuoteToOrderManagerLink);
		_waitForJStoLoad();
		reportLog("Click on Order Manager Link");
	}
}
