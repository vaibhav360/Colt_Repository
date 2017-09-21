package com.scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.util.DataModelCPQ;
import com.util.DataProviderRepository;
import com.util.DriverTestCase;
import com.util.PropertyReader;
import com.util.Utilities;

public class TestData_Validation_With_AddOns extends DriverTestCase {

	@Test(dataProviderClass = DataProviderRepository.class, dataProvider = "getData")
	public void test_01_check_Connectivity_and_price_of_sites(String quoteName, String customer, String country,
			String segment, String contractTerm, String coverage, String buildingType, String SiteAAddress,
			String SiteBAddress, String longLining_A, String ic_Site_A, String dual_Entry_Site_A,
			String outsideBHI_Site_A, String longLining_B, String ic_Site_B, String dual_Entry_Site_B,
			String outsideBHI_Site_B, String sync, String Resiliency, String BandWidth, String lag_Site_A,
			String diversity, String pam, String pr, String fastTrack, String cos) throws Exception {

		// String QuoteName = "CPQ_Quote_" + Utilities.getRandomInteger(1, 9999);
		String Description = "Quote_Desc_" + Utilities.getRandomInteger(1, 9999);

		DataModelCPQ cpqModel = new DataModelCPQ();
		cpqModel.setContract_Term("12");
		cpqModel.setOutsideBHI_Site_A(outsideBHI_Site_A);
		cpqModel.setCos(cos);
		cpqModel.setDiversity(diversity);
		cpqModel.setDual_Entry_Site_A(dual_Entry_Site_A);
		cpqModel.setDual_Entry_Site_B(dual_Entry_Site_B);
		cpqModel.setFastTrack(fastTrack);
		cpqModel.setIc_Site_A(ic_Site_A);
		cpqModel.setIc_Site_B(ic_Site_B);
		cpqModel.setLag_Site_A(lag_Site_A);
		cpqModel.setLag_Site_B(lag_Site_A);
		cpqModel.setLongLining_A(longLining_A);
		cpqModel.setLongLining_B(longLining_B);
		cpqModel.setOutsideBHI_Site_A(outsideBHI_Site_A);
		cpqModel.setOutsideBHI_Site_B(outsideBHI_Site_B);
		cpqModel.setPam(pam);
		cpqModel.setPr(pr);
		cpqModel.setFastTrack(fastTrack);

		System.out.println(cpqModel.getContract_Term());

		String[] array = { longLining_A, ic_Site_A, dual_Entry_Site_A, outsideBHI_Site_A, longLining_B, ic_Site_B,
				dual_Entry_Site_B, outsideBHI_Site_B, outsideBHI_Site_A, lag_Site_A, diversity, pam, pr, fastTrack,
				cos };
		PropertyReader propertyReader = new PropertyReader();

		// colt_DemoHelper.selectAddOns(cpqModel);

		String username = propertyReader.readApplicationFile("Username");
		String password = propertyReader.readApplicationFile("Password");
		// Open application URL
		getWebDriver().navigate().to(application_url);
		reportLog("Navigating Application URl");
		waitForAjaxRequestsToComplete();

		colt_DemoHelper.verifyTitle("Product List");
		reportLog("Product List Title present");

		// c4c_Helper.loginInToC4CApplication(username, password);
		reportLog("Login in to C4C with:" + username + " Password: " + password);
		colt_DemoHelper.loginToApplication(username, password);

		colt_DemoHelper.click("OrderManager");
		reportLog("Click on to Order Manager link");

		colt_DemoHelper.verifyTitle("Commerce Management");
		reportLog("Verifying the title Commerce Management");

		colt_DemoHelper.click("NewTransaction");
		reportLog("Click on to NewTransaction link");

		colt_DemoHelper.verifyTitle("Transaction");
		reportLog("Verifying the title 'Transaction'");

		colt_DemoHelper.type("QuoteName", quoteName);
		reportLog("Type QuoteName: " + quoteName);

		colt_DemoHelper.type("Description", Description);
		reportLog("Enter description: " + Description);

		colt_DemoHelper.click("smeSegment");
		colt_DemoHelper.selectDropdown("smeSegment", segment);
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

		// colt_DemoHelper.click("Resiliency");
		colt_DemoHelper.selectDropdown("Resiliency", Resiliency);
		reportLog("Select Resiliency: " + Resiliency);

		// colt_DemoHelper.click("BandWidth");
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

		colt_DemoHelper.selectAddOns(cpqModel);

		colt_DemoHelper.click("AddToTransaction");
		reportLog("Click on to AddToTransaction button");
		// colt_DemoHelper.waitForWorkAroundTime(5000);
		waitForAjaxRequestsToComplete();
		boolean flag = colt_DemoHelper.isElementDisplayed("AddToTransaction");
		System.out.println("*********************" + flag);
		if (flag)
			colt_DemoHelper.click("AddToTransaction");

		waitForAjaxRequestsToComplete();

		scrollDown("400");
		String nrc_Net_Price = colt_DemoHelper.getProductPricingValues("Connectivity Charge", "NRC (net)");
		String mrc_Net_Price = colt_DemoHelper.getProductPricingValues("Connectivity Charge", "MRC (net)");
		Assert.assertTrue(nrc_Net_Price.equals(nrc_Net_Price),
				"Prices are not equal. Actual: " + nrc_Net_Price + " Expected: " + nrc_Net_Price);
		reportLog("Verifying the NRC(net) Price of Site A. Actual: " + nrc_Net_Price + " Expected: " + nrc_Net_Price);
		Assert.assertTrue(mrc_Net_Price.equals(mrc_Net_Price),
				"Prices are not equal. Actual: " + mrc_Net_Price + " Expected: " + mrc_Net_Price);
		reportLog("Verifying the MRC(net) Price of Site B. Actual: " + mrc_Net_Price + " Expected: " + mrc_Net_Price);
		Assert.assertTrue(mrc_Net_Price.equals(mrc_Net_Price),
				"Prices are not equal. Actual: " + mrc_Net_Price + " Expected: " + mrc_Net_Price);
		// test.log(LogStatus.FAIL, "Verifying the MRC(net) Price of Site B.
		// Actual: " +
		// mrc_Net_Price + " Expected: " + mrc_Net_Price);

		colt_DemoHelper.click("SaveBtn");
		waitForAjaxRequestsToComplete();

		colt_DemoHelper.click("OrderManager");
		reportLog("Click on to Order Manager link");

		colt_DemoHelper.click("Logout");
		reportLog("Log out from the application");
	}

	@Test(dataProviderClass = DataProviderRepository.class, dataProvider = "testDataProvider")
	public void test_02_check_Connectivity_and_price_of_sites(Object obj) throws Exception {

		// String QuoteName = "CPQ_Quote_" + Utilities.getRandomInteger(1, 9999);
		String Description = "Quote_Desc_" + Utilities.getRandomInteger(1, 9999);

		DataModelCPQ cpqModel = (DataModelCPQ)obj;
		System.out.println(cpqModel.getCustomer());
		System.out.println(cpqModel.getSite_B_Add());
		
		colt_DemoHelper.selectAddOns(cpqModel);
		
		cpqModel.setContract_Term("12");
		cpqModel.setOutsideBHI_Site_A("");
		cpqModel.setCos("");
		cpqModel.setDiversity("");
		cpqModel.setDual_Entry_Site_A("");
		cpqModel.setDual_Entry_Site_B("");
		cpqModel.setFastTrack("");

		PropertyReader propertyReader = new PropertyReader();

		// colt_DemoHelper.selectAddOns(cpqModel);

		String username = propertyReader.readApplicationFile("Username");
		String password = propertyReader.readApplicationFile("Password");
		// Open application URL
		getWebDriver().navigate().to(application_url);
		reportLog("Navigating Application URl");
		waitForAjaxRequestsToComplete();

		colt_DemoHelper.verifyTitle("Product List");
		reportLog("Product List Title present");

		// c4c_Helper.loginInToC4CApplication(username, password);
		reportLog("Login in to C4C with:" + username + " Password: " + password);
		colt_DemoHelper.loginToApplication(username, password);

		colt_DemoHelper.click("OrderManager");
		reportLog("Click on to Order Manager link");

		colt_DemoHelper.verifyTitle("Commerce Management");
		reportLog("Verifying the title Commerce Management");

		colt_DemoHelper.click("NewTransaction");
		reportLog("Click on to NewTransaction link");

		colt_DemoHelper.verifyTitle("Transaction");
		reportLog("Verifying the title 'Transaction'");

		colt_DemoHelper.type("QuoteName", "");
		reportLog("Type QuoteName: " + "");

		colt_DemoHelper.type("Description", Description);
		reportLog("Enter description: " + Description);

	/*	colt_DemoHelper.click("smeSegment");
		colt_DemoHelper.selectDropdown("smeSegment", segment);
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

		// colt_DemoHelper.click("Resiliency");
		colt_DemoHelper.selectDropdown("Resiliency", Resiliency);
		reportLog("Select Resiliency: " + Resiliency);

		// colt_DemoHelper.click("BandWidth");
		colt_DemoHelper.selectDropdown("BandWidth", BandWidth);
		reportLog("Select BandWidth: " + BandWidth);

		colt_DemoHelper.type("SiteAAddress", SiteAAddress);
		colt_DemoHelper.selectAddress("SiteAAddress", Keys.DOWN);
		colt_DemoHelper.selectAddress("SiteAAddress", Keys.ENTER);
		reportLog("Enter Site A address: " + SiteAAddress);

		colt_DemoHelper.type("SiteBAddress", SiteBAddress);
		colt_DemoHelper.selectAddress("SiteBAddress", Keys.DOWN);
		colt_DemoHelper.selectAddress("SiteBAddress", Keys.ENTER);
		reportLog("Enter Site B address: " + SiteBAddress);*/

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

		colt_DemoHelper.verifyBuildingType("");

		colt_DemoHelper.selectAddOns(cpqModel);

		colt_DemoHelper.click("AddToTransaction");
		reportLog("Click on to AddToTransaction button");
		// colt_DemoHelper.waitForWorkAroundTime(5000);
		waitForAjaxRequestsToComplete();
		boolean flag = colt_DemoHelper.isElementDisplayed("AddToTransaction");
		System.out.println("*********************" + flag);
		if (flag)
			colt_DemoHelper.click("AddToTransaction");

		waitForAjaxRequestsToComplete();

		scrollDown("400");
		String nrc_Net_Price = colt_DemoHelper.getProductPricingValues("Connectivity Charge", "NRC (net)");
		String mrc_Net_Price = colt_DemoHelper.getProductPricingValues("Connectivity Charge", "MRC (net)");
		Assert.assertTrue(nrc_Net_Price.equals(nrc_Net_Price),
				"Prices are not equal. Actual: " + nrc_Net_Price + " Expected: " + nrc_Net_Price);
		reportLog("Verifying the NRC(net) Price of Site A. Actual: " + nrc_Net_Price + " Expected: " + nrc_Net_Price);
		Assert.assertTrue(mrc_Net_Price.equals(mrc_Net_Price),
				"Prices are not equal. Actual: " + mrc_Net_Price + " Expected: " + mrc_Net_Price);
		reportLog("Verifying the MRC(net) Price of Site B. Actual: " + mrc_Net_Price + " Expected: " + mrc_Net_Price);
		Assert.assertTrue(mrc_Net_Price.equals(mrc_Net_Price),
				"Prices are not equal. Actual: " + mrc_Net_Price + " Expected: " + mrc_Net_Price);
		// test.log(LogStatus.FAIL, "Verifying the MRC(net) Price of Site B.
		// Actual: " +
		// mrc_Net_Price + " Expected: " + mrc_Net_Price);

		colt_DemoHelper.click("SaveBtn");
		waitForAjaxRequestsToComplete();

		colt_DemoHelper.click("OrderManager");
		reportLog("Click on to Order Manager link");

		colt_DemoHelper.click("Logout");
		reportLog("Log out from the application");
	}

}
