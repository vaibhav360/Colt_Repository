package com.scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.util.DataProviderRepository;
import com.util.DriverTestCase;
import com.util.PropertyReader;

public class Colt_Demo_Add_Hub_and_Spoke extends DriverTestCase{

	@Test(dataProviderClass = DataProviderRepository.class, dataProvider = "getData")
	public void test_01_check_Connectivity_and_price_of_sites(String QuoteName, String Description, String segment,String Resiliency,
			String BandWidth, String buildingType, String SiteAAddress, String SiteBAddress, String NRC_net,
			String MRC_net) throws Exception {
		
		//Colt_DemoHelper colt_DemoHelper = new Colt_DemoHelper(getWebDriver());
		PropertyReader propertyReader = new PropertyReader();
		
		String username = propertyReader.readApplicationFile("Username");
		String password = propertyReader.readApplicationFile("Password");
		// Open application URL
		getWebDriver().navigate().to(application_url);
		reportLog("Navigating Application URl");
		waitForAjaxRequestsToComplete();

		colt_DemoHelper.verifyTitle("Product List");
		reportLog("Product List Title present");

		c4c_Helper.loginInToC4CApplication(username, password);
		reportLog("Login in to C4C with:"+username +" Password: "+password);
		//loginToApplication(username, password);

		colt_DemoHelper.click("OrderManager");
		reportLog("Click on to Order Manager link");

		colt_DemoHelper.verifyTitle("Commerce Management");
		reportLog("Verifying the title Commerce Management");

		colt_DemoHelper.click("NewTransaction");
		reportLog("Click on to NewTransaction link");

		colt_DemoHelper.verifyTitle("Transaction");
		reportLog("Verifying the title 'Transaction'");

		colt_DemoHelper.type("QuoteName", QuoteName);
		reportLog("Type QuoteName: " + QuoteName);

		colt_DemoHelper.type("Description", Description);
		reportLog("Enter description: " + Description);

		colt_DemoHelper.click("smeSegment");
		colt_DemoHelper.selectDropdown("smeSegment",segment);
		reportLog("Select SME segment: " + segment);
		
		colt_DemoHelper.click("AddProduct");
		reportLog("Click on to AddProduct button");

		colt_DemoHelper.verifyTitle("Product List");
		reportLog("Verifying the title 'Product List'");

		colt_DemoHelper.mouseMove("EtherNet");
		reportLog("Mouse move to EtherNet link");

		colt_DemoHelper.click("EnternetLine");
		reportLog("Click on to EnternetLine");

		colt_DemoHelper.verifyTitle("Model Configuration");
		reportLog("Verifying the title 'Model Configuration'");

		colt_DemoHelper.selectDropdown("Resiliency", Resiliency);
		reportLog("Select Resiliency: " + Resiliency);

		colt_DemoHelper.selectDropdown("BandWidth", BandWidth);
		reportLog("Select BandWidth: " + BandWidth);

		colt_DemoHelper.type("SiteAAddress", SiteAAddress);
		colt_DemoHelper.selectAddress("SiteAAddress", Keys.DOWN);
		colt_DemoHelper.selectAddress("SiteAAddress", Keys.ENTER);
		reportLog("Enter Site A address: " + SiteAAddress);

		colt_DemoHelper.type("SiteBAddress", SiteBAddress);
		colt_DemoHelper.selectAddress("SiteBAddress", Keys.DOWN);
		colt_DemoHelper.selectAddress("SiteBAddress", Keys.ENTER);
		reportLog("Enter Site B address: " + SiteBAddress);

		// colt_DemoHelper.waitForWorkAroundTime(4000);
		waitForAjaxRequestsToComplete();
		colt_DemoHelper.click("Update");
		reportLog("Click on to Update button");

		// colt_DemoHelper.waitForWorkAroundTime(10000);
		waitForAjaxRequestsToComplete();
		colt_DemoHelper.click("CheckConnectivity");
		reportLog("Click on to CheckConnectivity button");

		// colt_DemoHelper.waitForWorkAroundTime(15000);
		waitForAjaxRequestsToComplete();

		String msg_A = colt_DemoHelper.getConnectivityMessageForAddress("A");
		reportLog("Site A connectivity Message: " + msg_A);
		String msg_B = colt_DemoHelper.getConnectivityMessageForAddress("B");
		reportLog("Site B connectivity Message: " + msg_B);
		if (msg_A.equals("Oops!!! Connectivity not found for selected site,")
				|| msg_B.equals("Oops!!! Connectivity not found for selected site,")) {
			Assert.fail("Site A or Site B address have connection issue");
		}

		colt_DemoHelper.verifyBuildingType(buildingType);

		colt_DemoHelper.click("AddToTransaction");
		reportLog("Click on to AddToTransaction button");
		// colt_DemoHelper.waitForWorkAroundTime(5000);
		waitForAjaxRequestsToComplete();
		scrollDown("400");
		String nrc_Net_Price = colt_DemoHelper.getProductPricingValues("Connectivity Charge", "NRC (net)");
		String mrc_Net_Price = colt_DemoHelper.getProductPricingValues("Connectivity Charge", "MRC (net)");
		Assert.assertTrue(nrc_Net_Price.equals(NRC_net),
				"Prices are not equal. Actual: " + nrc_Net_Price + " Expected: " + NRC_net);
		reportLog("Verifying the NRC(net) Price of Site A. Actual: " + nrc_Net_Price + " Expected: " + NRC_net);
		Assert.assertTrue(mrc_Net_Price.equals(MRC_net),
				"Prices are not equal. Actual: " + mrc_Net_Price + " Expected: " + MRC_net);
		reportLog("Verifying the MRC(net) Price of Site B. Actual: " + mrc_Net_Price + " Expected: " + mrc_Net_Price);
		Assert.assertTrue(mrc_Net_Price.equals(MRC_net),
				"Prices are not equal. Actual: " + mrc_Net_Price + " Expected: " + MRC_net);
		// test.log(LogStatus.FAIL, "Verifying the MRC(net) Price of Site B. Actual: " +
		// mrc_Net_Price + " Expected: " + mrc_Net_Price);

		colt_DemoHelper.click("Logout");
		reportLog("Log out from the application");
	}
}
