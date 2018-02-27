package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.util.BasePage;

public class C4CAppPage extends BasePage {

	public C4CAppPage(WebDriver webdriver) {
		super(webdriver);
	}

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = "//*[text()='Login']")
	public WebElement logInBtn;
	
	
	@FindBy(id = "__button0-content")
	public WebElement yesPopUp;
	

	@FindBy(xpath = "//*[text()='Customers']")
	public WebElement customers;

	@FindBy(xpath = "//*[text()='Sales']")
	public WebElement sales;

	@FindBy(xpath = "//*[text()='Opportunities']")
	public WebElement opportunities;

	@FindBy(xpath = "//*[text()='Accounts']")
	public WebElement accounts;

	@FindBy(css = "#panevariantm8HSa5dpNqg1z8nY0idosG_9-topRow>div>div>div:nth-child(3)>button>span>span")
	public WebElement myAccount1;
	
	@FindBy(xpath = "//*[@title='Select Variant']")
	public WebElement myAccount;

	@FindBy(xpath = "//*[text()='All']")
	public WebElement all;

	@FindBy(xpath = "//*[text()='TestJapanOCN']")
	public WebElement testJapanOCN;
	
	@FindBy(xpath = "//*[text()='Peap']")
	public WebElement opportunity_tmp;

	@FindBy(xpath = "(//*[text()='Quotes'])[1]")
	public WebElement quotes;

	@FindBy(xpath = "//*[text()='OVERVIEW']")
	public WebElement overview;

	@FindBy(xpath = "//*[text()='Add']")
	public WebElement add;

	@FindBy(id = "add_product")
	public WebElement addproduct;
	
	@FindBy(name = "username")
	public WebElement usernameCPQ;
	
	@FindBy(id = "psword")
	public WebElement pwdCPQ;
	
	@FindBy(id = "log_in")
	public WebElement loginBtnCPQ;

	public void loginInToC4CApplication(String name, String pwd) {
		username.sendKeys(name);
		//reportLog("Enter Username: "+name);
		password.sendKeys(pwd);
		//reportLog("Enter Password: "+pwd);
		logInBtn.click();
		//reportLog("Click on Login Button");
		_waitForJStoLoad();
		waitForAjaxRequestsToComplete();
		sleepExecution(3);
		try {
			if(yesPopUp.isDisplayed())
				yesPopUp.click();
				_waitForJStoLoad();
				waitForAjaxRequestsToComplete();
		}
		catch(Exception ex)
		{
			System.out.println("Pop up didn't show up");
		}
		

	}
	
	public void loginInToCPQApplication(String name, String pwd) {
		sendKeys(usernameCPQ, name);
		//reportLog("Enter Username: "+name);
		sendKeys(pwdCPQ, pwd);
		//reportLog("Enter Password: "+pwd);
		loginBtnCPQ.click();
		//reportLog("Click on Login Button");
		_waitForJStoLoad();
		waitForAjaxRequestsToComplete();

	}

	public void goToOpportunityPage()
	{
		waitAndClick(sales);
		//reportLog("Click on Sales Link");

		waitAndClick(opportunities);
		//reportLog("Click on Opportunity Link");
		_waitForJStoLoad();

		sleepExecution(4);
		waitAndClick(myAccount);
		//reportLog("Click on downarrow button");
		_waitForJStoLoad();
		
		waitAndClick(all);
		//reportLog("Select all from dialog");
		_waitForJStoLoad();
	}
	
	public void navigateFromSalesToProduct() throws Exception {
		goToOpportunityPage();

		waitAndClick(opportunity_tmp);
		reportLog("Select opportunity_tmp from account list");
		_waitForJStoLoad();
		waitForAjaxRequestsToComplete();

		quotes.click();
		reportLog("Click on Quote tab");
		_waitForJStoLoad();

		waitAndClick(add);
		reportLog("Click on Add button");
		_waitForJStoLoad();
		waitForAjaxRequestsToComplete();
		switchWindow("Transaction");
		reportLog("Switching on CQP tab");
		sleepExecution(2);
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
