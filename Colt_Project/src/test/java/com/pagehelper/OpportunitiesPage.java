package com.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.locators.LocatorReader;
import com.util.BasePage;

public class OpportunitiesPage extends BasePage {

	private static LocatorReader locatorReader;

	public OpportunitiesPage(WebDriver webdriver) {
		super(webdriver);
		locatorReader = new LocatorReader("OpportunityPageUI.xml");
	}

	public void searchOpportunity(String name) throws InterruptedException {
		waitForAjaxRequestsToComplete();
		String searchBtn = locatorReader.getLocator("OpportunitySearchBtn");
		clickOn(searchBtn);

		String loc = locatorReader.getLocator("OpportunityInputBox");
		sendKeys(loc, name);
		pressEnterKey();
		waitForAjaxRequestsToComplete();
	}

	public void verifyDataInOpportunityTable() {
		String loc = locatorReader.getLocator("table");
		int count = getXpathCount(loc);

		Assert.assertTrue((count > 1), "No data is present in table!");
	}

}
