package com.scripts;

import org.testng.annotations.Test;

import com.locators.LocatorReader;
import com.util.DriverTestCase;
import com.util.Utilities;

public class C4CApplicationTests extends DriverTestCase {

	@Test
	public void test_01_CreateNewOpportunity() throws InterruptedException
	{
		String username = propertyReader.readApplicationFile("C4C_Username");
		String password = propertyReader.readApplicationFile("C4C_Password");
		System.out.println(username+"  "+password);
		String name = "Test_"+Utilities.getRandomInteger(1000,9999);
		
		// Open application URL
		getWebDriver().get(c4c_url);
		reportLog("Navigating Application URl");
		waitForAjaxRequestsToComplete();
		
		c4c_Helper.loginInToC4CApplication(username, password);
		reportLog("Login in to C4C with:"+username +" Password: "+password);
		
		boolean flag = c4c_Helper.verifyMultipleLoginPopUp("MultilogonPopUp");
		reportLog("Multiple Login Pop up is displayed: "+flag);
		if(flag)
		c4c_Helper.clickOnMultipleLoginPopUp("PopUpYes");
		
		c4c_Helper.clickOnNewItem("Opportunity");
		reportLog("Click on Opportunity");
		
		c4c_Helper.fillMandatoryOpportunityDetails(name,"pepa","Joanne Perkins","24.02.2019","12","New Business","US Dollar");
		reportLog("Fill opportunity details");
		
		c4c_Helper.goToHomePage();
		reportLog("Go to Home Page");
		
		c4c_Helper.goToOpportunityPage();
		reportLog("Go to opportunity Page");
		
		c4c_Helper.verifyTitle("Opportunities - SAP Hybris Cloud for Customer");
		
		opportunityPage.searchOpportunity(name);
		reportLog("Search opportunity: "+name);
		
		opportunityPage.verifyDataInOpportunityTable();
		reportLog("Verify data in Opportunity table");
	}
	
	public void test_02_VerifySubmenuOfSalesMenu() throws InterruptedException
	{
		String username = propertyReader.readApplicationFile("C4C_Username");
		String password = propertyReader.readApplicationFile("C4C_Password");
		System.out.println(username+"  "+password);
		
		// Open application URL
		getWebDriver().get(c4c_url);
		reportLog("Navigating Application URl");
		waitForAjaxRequestsToComplete();
		
		c4c_Helper.loginInToC4CApplication(username, password);
		reportLog("Login in to C4C with:"+username +" Password: "+password);
		
		boolean flag = c4c_Helper.verifyMultipleLoginPopUp("MultilogonPopUp");
		reportLog("Multiple Login Pop up is displayed: "+flag);
		if(flag)
		c4c_Helper.clickOnMultipleLoginPopUp("PopUpYes");
		
		String[] subMenu = {"","","","",""};
		//String txt = c4c_Helper.verifySalesMenuSubLinks("Sales");
		
		
	}
	
	
}
