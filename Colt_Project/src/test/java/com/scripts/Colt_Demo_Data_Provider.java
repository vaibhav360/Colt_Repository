package com.scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.pagehelper.Colt_DemoHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.DataProviderRepository;
import com.util.DriverTestCase;
import com.util.PropertyReader;

//@Guice
public class Colt_Demo_Data_Provider extends DriverTestCase
{
	@Test(dataProviderClass=DataProviderRepository.class,dataProvider="getData")
	public void testColt_Demo(String QuoteName, String Description, String Resiliency, String BandWidth, String SiteAAddress, String SiteBAddress) throws Exception
	{
		Colt_DemoHelper colt_DemoHelper = new Colt_DemoHelper(getWebDriver());
		PropertyReader propertyReader = new PropertyReader();		
		
		String username = propertyReader.readApplicationFile("Username");
		String password = propertyReader.readApplicationFile("Password");
		//Open application URL
		getWebDriver().navigate().to(application_url);

		Thread.sleep(5000);
		Reporter.log("THIS DE TO CHECK");
		Reporter.log(Reporter.getCurrentTestResult().toString());
		//Verify title
		colt_DemoHelper.verifyTitle("Product List");
		test.log(LogStatus.PASS, "Product List Title present");
		loginToApplication(username,password);
		test.log(LogStatus.INFO, "Login into application with "+username+"and Password: "+password);
		colt_DemoHelper.click("OrderManager");
		test.log(LogStatus.INFO, "Click on to Order Manager link");
		
		colt_DemoHelper.verifyTitle("Commerce Management");
		
		colt_DemoHelper.click("NewTransaction");
		test.log(LogStatus.INFO, "Click on to NewTransaction link");
		
		colt_DemoHelper.verifyTitle("Transaction");
		
		colt_DemoHelper.type("QuoteName", QuoteName);
		
		colt_DemoHelper.type("Description", Description);
		
		colt_DemoHelper.click("AddProduct");
		
		colt_DemoHelper.verifyTitle("Product List");
		
		colt_DemoHelper.mouseMove("EtherNet");
		
		colt_DemoHelper.click("EnternetLine");
		
		colt_DemoHelper.verifyTitle("Model Configuration");

		colt_DemoHelper.selectDropdown("Resiliency", Resiliency);
		
		colt_DemoHelper.selectDropdown("BandWidth",BandWidth);
		
		colt_DemoHelper.type("SiteAAddress", SiteAAddress);
		colt_DemoHelper.selectAddress("SiteAAddress",Keys.DOWN);
		colt_DemoHelper.selectAddress("SiteAAddress",Keys.ENTER);
		
		colt_DemoHelper.type("SiteBAddress", SiteBAddress);
		colt_DemoHelper.selectAddress("SiteBAddress",Keys.DOWN);
		colt_DemoHelper.selectAddress("SiteBAddress",Keys.ENTER);
		
		colt_DemoHelper.waitForWorkAroundTime(4000);
		
		colt_DemoHelper.click("Update");
		
		colt_DemoHelper.waitForWorkAroundTime(10000);
		
		colt_DemoHelper.click("CheckConnectivity");
		
		colt_DemoHelper.waitForWorkAroundTime(15000);
		
		System.out.println(loctorReader_1.getLocator("connectivityMsgA"));
		String str =loctorReader_1.getLocator("connectivityMsgA");
		String siteAMsg = colt_DemoHelper.getFieldText(str);
		String siteBMsg = colt_DemoHelper.getFieldText(loctorReader_1.getLocator("connectivityMsgB"));
		if(siteAMsg.equals("Oops!!! Connectivity not found for selected site,"))
			Assert.fail("Site A address is not connected");
		
		colt_DemoHelper.click("Addon");
		
		colt_DemoHelper.waitForWorkAroundTime(5000);
		
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
