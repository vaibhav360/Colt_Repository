package com.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.locators.LocatorReader;
import com.util.BasePage;

public class C4CApplicationHelper extends BasePage {

	private static LocatorReader locatorReader;

	public enum CreateNew {
		Opportunity, Account, Contact, Lead, Appointment, Task;
	}

	public C4CApplicationHelper(WebDriver webdriver) {
		super(webdriver);
		locatorReader = new LocatorReader("C4C.xml");
	}

	public void loginInToC4CApplication(String username, String password) throws InterruptedException {
		String locator = null;
		locator = locatorReader.getLocator("username");
		sendKeys(locator, username);

		locator = locatorReader.getLocator("password");
		sendKeys(locator, password);

		locator = locatorReader.getLocator("logInBtn");
		clickOn(locator);

		_waitForJStoLoad();
	}

	public boolean verifyMultipleLoginPopUp(String xpath) {
		String locator = locatorReader.getLocator(xpath);
		waitForWorkAroundTime(2000);
		return isElementPresent(locator);
	}

	public void clickOnMultipleLoginPopUp(String locator) throws InterruptedException {
		String loc = locatorReader.getLocator(locator);
		clickOn(loc);
		_waitForJStoLoad();
	}

	public void clickOnNewItem(String input) throws InterruptedException {
		Thread.sleep(2000);
		CreateNew in = CreateNew.valueOf(input);
		String loc = null;
		clickOn(locatorReader.getLocator("CreateBtn"));

		switch (in) {
		case Opportunity:
			loc = locatorReader.getLocator("Opportunity");
			break;
		case Account:
			loc = locatorReader.getLocator("Opportunity");
			break;
		case Task:
			loc = locatorReader.getLocator("Opportunity");
			break;
		case Lead:
			loc = locatorReader.getLocator("Opportunity");
			break;
		default:
			Assert.fail("Please specify the correct type of Input");
			break;
		}
		clickOn(loc);
		_waitForJStoLoad();

	}

	public void fillMandatoryOpportunityDetails(String name, String account, String owner, String date, String contract,
			String offer, String currency) throws InterruptedException {
		String locator = null;
		Thread.sleep(3000);
		locator = locatorReader.getLocator("NameInputBox");
		sendKeys(locator, name);
		System.out.println(name);

		locator = locatorReader.getLocator("AccountInputBox");
		sendKeys(locator, account);
		Thread.sleep(2000);

		locator = locatorReader.getLocator("OwnerInputBox");
		sendKeys(locator, owner);
		Thread.sleep(2000);

		locator = locatorReader.getLocator("DateInputBox");
		sendKeys(locator, date);
		Thread.sleep(2000);

		locator = locatorReader.getLocator("ContractInputBox");
		sendKeys(locator, contract);
		Thread.sleep(2000);

		locator = locatorReader.getLocator("OfferInputBox");
		System.out.println(locator);
		waitForElement(locator);
		javascriptButtonClick(locator);
		// sendKeys(locator, offer);
		clickOn(locator);
		Thread.sleep(2000);
		pressDownArrowKey();
		pressTabKey();

		locator = locatorReader.getLocator("CurrencyInputBox");
		clickOn(locator);
		pressDownArrowKey();
		// sendKeys(locator, currency);
		Thread.sleep(2000);

		locator = locatorReader.getLocator("SaveBtn");
		clickOn(locator);
		Thread.sleep(2000);

	}

	public void goToOpportunityPage() throws InterruptedException {
		String loc = locatorReader.getLocator("SalesMenu");
		clickOn(loc);
		Thread.sleep(2000);
		loc = locatorReader.getLocator("OpportunityMenu");
		clickOn(loc);
		_waitForJStoLoad();
	}

	public void goToHomePage() throws InterruptedException {
		String loc = locatorReader.getLocator("HomeMenu");
		clickOn(loc);
		_waitForJStoLoad();
	}

	public void verifySalesMenuSubLinks(String menu, String[] sublinks) {
		String locator = "//*[text()='" + menu + "']/../following-sibling::div//a";
		String tmp = null;
		int count = getXpathCount(locator);
		int expectedCount = sublinks.length;

		Assert.assertTrue((count == expectedCount),
				"Number of Sublink present in the menu are not equal <br/> Expected: " + expectedCount + "+ Actual: "
						+ count);
		for (int i = 1; i < expectedCount; i++) {
			tmp = getText("//*[text()='" + menu + "']/../following-sibling::div/div[" + i + "]/a");
			Assert.assertTrue(tmp.equals(sublinks[i]),
					"Expected Sublink: " + sublinks[i] + "<br />Actual Sublink: " + tmp + " is not present/equal");
		}

	}
}
