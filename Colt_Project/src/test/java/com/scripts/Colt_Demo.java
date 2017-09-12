package com.scripts;

import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.util.DriverTestCase;

public class Colt_Demo extends DriverTestCase
{
	@Test(priority=1)
	public void testColt_Demo() throws Exception
	{
		//Colt_DemoHelper colt_DemoHelper = new Colt_DemoHelper(getWebDriver());
		//PropertyReader propertyReader = new PropertyReader();		
		
		String username = propertyReader.readApplicationFile("Username");
		String password = propertyReader.readApplicationFile("Password");
		System.out.println(application_url);
		//Open application URL
		getWebDriver().navigate().to(application_url);

		Thread.sleep(5000);
		Reporter.log("THIS DE TO CHECK");
		Reporter.log(Reporter.getCurrentTestResult().toString());
		//Verify title
		colt_DemoHelper.verifyTitle("Product List");
		
		loginToApplication(username,password);
		
		colt_DemoHelper.verifyTitle("Product List");
		
		colt_DemoHelper.click("OrderManager");
		
		colt_DemoHelper.verifyTitle("Commerce Management");
		
		colt_DemoHelper.click("NewTransaction");
		
		colt_DemoHelper.verifyTitle("Transaction");
		
		colt_DemoHelper.type("QuoteName", "T_Demo_Quote");
		
		colt_DemoHelper.type("Description", "T_Demo_Description");
		
		colt_DemoHelper.click("AddProduct");
		
		colt_DemoHelper.verifyTitle("Product List");
		
		colt_DemoHelper.mouseMove("EtherNet");
		
		colt_DemoHelper.click("EnternetLine");
		
		colt_DemoHelper.verifyTitle("Model Configuration");
		
		colt_DemoHelper.selectDropdown("Resiliency", "Unprotected");

		colt_DemoHelper.selectDropdown("BandWidth","100 Gbps");
		
		colt_DemoHelper.type("SiteAAddress", "Rue Friant, Paris");
		colt_DemoHelper.selectAddress("SiteAAddress",Keys.DOWN);
		colt_DemoHelper.selectAddress("SiteAAddress",Keys.ENTER);
		
		colt_DemoHelper.type("SiteBAddress", "16 Rue Friant, Paris");
		colt_DemoHelper.selectAddress("SiteBAddress",Keys.DOWN);
		colt_DemoHelper.selectAddress("SiteBAddress",Keys.ENTER);
		
		colt_DemoHelper.waitForWorkAroundTime(4000);
		
		colt_DemoHelper.click("Update");
		
		colt_DemoHelper.waitForWorkAroundTime(10000);
		
		colt_DemoHelper.click("CheckConnectivity");
		
		colt_DemoHelper.waitForWorkAroundTime(15000);
		
		colt_DemoHelper.click("Addon");
		
		colt_DemoHelper.waitForWorkAroundTime(2000);
		
		colt_DemoHelper.click("Options1");
		colt_DemoHelper.waitForWorkAroundTime(5000);
		colt_DemoHelper.click("Options2");
		colt_DemoHelper.waitForWorkAroundTime(5000);
		colt_DemoHelper.click("Options3");
		colt_DemoHelper.waitForWorkAroundTime(5000);
		colt_DemoHelper.click("Options4");
		colt_DemoHelper.waitForWorkAroundTime(5000);
		
		colt_DemoHelper.click("Update");
		colt_DemoHelper.waitForWorkAroundTime(10000);
		
		colt_DemoHelper.verifyAddedAddOns("SelectedOption1","SelectedOption2","SelectedOption3","SelectedOption4");
			
		String[] value = colt_DemoHelper.getValues("table");
				
		colt_DemoHelper.click("AddToTransaction");
		colt_DemoHelper.waitForWorkAroundTime(5000);
		
		String[] value1 = colt_DemoHelper.getAttributeValues("table1");
		
		colt_DemoHelper.compareValues(value,value1);
		
		colt_DemoHelper.click("Logout");
	}
}
