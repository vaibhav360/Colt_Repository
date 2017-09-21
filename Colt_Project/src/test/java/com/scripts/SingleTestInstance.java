package com.scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.pages.Model_Configuration_Page;
import com.util.DataModelCPQ;
import com.util.DataProviderRepository;
import com.util.DriverTestCase;
import com.util.ExcelDataBaseConnector;
import com.util.Utilities;

public class SingleTestInstance extends DriverTestCase {

	@BeforeClass
	public void doLogin() throws InterruptedException {
		setUp();
		String username = propertyReader.readApplicationFile("Username");
		String password = propertyReader.readApplicationFile("Password");
		// Open application URL
		getWebDriver().navigate().to(application_url);
		// reportLog("Navigating Application URl");
		waitForAjaxRequestsToComplete();
		c4c_Helper.loginToApplication(username, password);
		listPriceConnection = ExcelDataBaseConnector.createConnection("List_Price_Small");
	}

	@AfterClass
	public void closeConn() {
		// close db
		try {
			ExcelDataBaseConnector.CloseTheConnection(listPriceConnection);
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(dataProviderClass = DataProviderRepository.class, dataProvider = "getData")
	public void test_01_check_Connectivity_and_price_of_sites(String quoteName, String customer, String country,
			String segment, String contractTerm, String coverage, String buildingType, String SiteAAddress,
			String SiteBAddress, String longLining_A, String ic_Site_A, String dual_Entry_Site_A,
			String outsideBHI_Site_A, String longLining_B, String ic_Site_B, String dual_Entry_Site_B,
			String outsideBHI_Site_B, String sync, String Resiliency, String BandWidth, String lag_Site_A,
			String diversity, String pam, String pr, String fastTrack, String cos) throws Exception {

		try {
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

			// colt_DemoHelper.selectAddOns(cpqModel);

			/*
			 * String username = propertyReader.readApplicationFile("Username"); String
			 * password = propertyReader.readApplicationFile("Password"); // Open
			 * application URL getWebDriver().navigate().to(application_url);
			 * reportLog("Navigating Application URl"); waitForAjaxRequestsToComplete();
			 * 
			 * colt_DemoHelper.verifyTitle("Product List");
			 * reportLog("Product List Title present");
			 * 
			 * // c4c_Helper.loginInToC4CApplication(username, password);
			 * reportLog("Login in to C4C with:" + username + " Password: " + password);
			 * colt_DemoHelper.loginToApplication(username, password);
			 */

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

			colt_DemoHelper.enterAddressManually(buildingType);

			// colt_DemoHelper.waitForWorkAroundTime(10000);
			// waitForAjaxRequestsToComplete();
			colt_DemoHelper.click("CheckConnectivity");
			reportLog("Click on to CheckConnectivity button");

			// colt_DemoHelper.waitForWorkAroundTime(15000);
			waitForAjaxRequestsToComplete();

			String msg_A = colt_DemoHelper.getConnectivityMessageForAddress("A");
			reportLog("Site A connectivity Message: " + msg_A);
			String msg_B = colt_DemoHelper.getConnectivityMessageForAddress("B");
			reportLog("Site B connectivity Message: " + msg_B);
			colt_DemoHelper.verifyConnectivityMessage(msg_A, msg_B);

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

			scrollDown("400");
			colt_DemoHelper.verify_NRC_MRC_Prices("", "");
			// test.log(LogStatus.FAIL, "Verifying the MRC(net) Price of Site B.
			// Actual: " +
			// mrc_Net_Price + " Expected: " + mrc_Net_Price);

			colt_DemoHelper.click("SaveBtn");

			colt_DemoHelper.click("OrderManager");
			reportLog("Click on to Order Manager link");

			colt_DemoHelper.softAsserAll();

			/*
			 * colt_DemoHelper.click("Logout"); reportLog("Log out from the application");
			 */
		} catch (Exception e) {
		}
	}

	@Test(dataProviderClass = DataProviderRepository.class, dataProvider = "testDataProvider")
	public void test_02_check_Connectivity_and_price_of_sites_with_dataModel(Object obj) throws Exception {

		String Description = "Quote_Desc_" + Utilities.getRandomInteger(1, 9999);
		DataModelCPQ cpqModel = (DataModelCPQ) obj;

		String mrc_Net_Price = ExcelDataBaseConnector.executeSQLQuery(listPriceConnection, cpqModel, "Zone 1 MRC");
		String _mrc_Net_Price = Utilities.mrcPriceAsPerContractTerm(cpqModel.getContract_Term(), mrc_Net_Price);
		System.out.println(_mrc_Net_Price);

		String nrc_Net_Price = ExcelDataBaseConnector.executeSQLQuery(listPriceConnection, cpqModel, "Zone 1 NRC");
		String _nrc_Net_Price = Utilities.nrcPriceAsPerContractTerm(cpqModel.getContract_Term(), nrc_Net_Price);
		System.out.println(_nrc_Net_Price);

		String currency = ExcelDataBaseConnector.executeSQLQuery(listPriceConnection, cpqModel, "Currency");
		System.out.println(currency);

		productListPage.clickOnOrderManagerLink();

		colt_DemoHelper.verifyTitle("Commerce Management");
		reportLog("Verifying the title Commerce Management");

		commerceManagementPage.clickOnAddTransactionButton();
		// colt_DemoHelper.click("NewTransaction");
		reportLog("Click on to NewTransaction link");

		colt_DemoHelper.verifyTitle("Transaction");
		reportLog("Verifying the title 'Transaction'");

		transactionPage.sendKeys(transactionPage.quoteName, cpqModel.getQuoteName());

		// colt_DemoHelper.type("QuoteName", cpqModel.getQuoteName());
		reportLog("Type QuoteName: " + cpqModel.getQuoteName());

		transactionPage.sendKeys(transactionPage.quoteDescription, Description);

		// colt_DemoHelper.type("Description", Description);
		reportLog("Enter description: " + Description);

		String currencyType = transactionPage.getUICurrencyType();
		reportLog("Currency Type On UI: " + currencyType);
		reportLog("Segment  On UI: " + cpqModel.getSegment());

		if (!(mrc_Net_Price.equals("NA") || mrc_Net_Price == null)) {
			String str = Utilities.currencyConvertor(_mrc_Net_Price, currency, currencyType);
			_mrc_Net_Price = str;
			System.out.println(str);
			reportLog("MRC_Net Price after conversion: " + str);
		}

		if (!(nrc_Net_Price.equals("NA") || nrc_Net_Price == null)) {
			String str = Utilities.currencyConvertor(_nrc_Net_Price, currency, currencyType);
			_nrc_Net_Price = str;
			System.out.println(str);
			reportLog("NRC_Net Price after conversion: " + str);
		}

		transactionPage.clickOnAddProductBtn();
		reportLog("Click on to AddProduct button");

		colt_DemoHelper.verifyTitle("Product List");
		reportLog("Verifying the title 'Product List'");

		colt_DemoHelper.mouseMove("EtherNet");
		reportLog("Mouse move to EtherNet link");

		productListPage.click(productListPage.ethernetButton);
		productListPage.click(productListPage.ethernetLineLink);
		// colt_DemoHelper.click("EnternetLine");
		reportLog("Click on to EnternetLine");

		colt_DemoHelper.verifyTitle("Model Configuration");
		reportLog("Verifying the title 'Model Configuration'");

		modelConfigurationPage.selectDropDownByText(modelConfigurationPage.resiliency, cpqModel.getResiliency());
		reportLog("Select Resiliency: " + cpqModel.getResiliency());

		modelConfigurationPage.selectDropDownByText(modelConfigurationPage.serviceBandwidth, cpqModel.getBandWidth());
		reportLog("Select BandWidth: " + cpqModel.getBandWidth());

		modelConfigurationPage.sendKeys(modelConfigurationPage.siteAddressAEnd, cpqModel.getSite_A_Add());
		colt_DemoHelper._waitForJStoLoad();
		modelConfigurationPage.pressDownArrowKey();
		modelConfigurationPage.pressEnterKey();
		reportLog("Enter Site A address: " + cpqModel.getSite_A_Add());
		colt_DemoHelper._waitForJStoLoad();

		modelConfigurationPage.sendKeys(modelConfigurationPage.siteAddressBEnd, cpqModel.getSite_B_Add());
		colt_DemoHelper._waitForJStoLoad();
		modelConfigurationPage.pressDownArrowKey();
		modelConfigurationPage.pressEnterKey();
		reportLog("Enter Site B address: " + cpqModel.getSite_B_Add());
		colt_DemoHelper._waitForJStoLoad();

		modelConfigurationPage.click(modelConfigurationPage.update);
		reportLog("Click on to Update button");

		//modelConfigurationPage.enterAddressManually(cpqModel.getBuilding_Type());
		
		modelConfigurationPage.click(modelConfigurationPage.checkConnectivityButton);
		reportLog("Click on to CheckConnectivity button");

		scrollDown("350");
		modelConfigurationPage.verifyConnectivity();

		colt_DemoHelper.verifyBlankPriceMessage();

		colt_DemoHelper.verifyBuildingType(cpqModel.getBuilding_Type());

		String contractTerm = cpqModel.getContract_Term();
		modelConfigurationPage.enterContractTerm(contractTerm);

		modelConfigurationPage.click(modelConfigurationPage.addToTransaction);
		
		//modelConfigurationPage.selectAddOns(cpqModel);

		//waitForAjaxRequestsToComplete();
		boolean flag = modelConfigurationPage.isElementDisplayed(modelConfigurationPage.addToTransaction);
		System.out.println("*********************" + flag);
		if (flag) {
			modelConfigurationPage.click(modelConfigurationPage.addToTransaction);
			modelConfigurationPage._waitForJStoLoad();
			flag = false;
		}
			scrollDown("500");

			colt_DemoHelper.verify_NRC_MRC_Prices(_nrc_Net_Price, _mrc_Net_Price);

			modelConfigurationPage.click(modelConfigurationPage.saveBtn);

			productListPage.clickOnOrderManagerLink();

			colt_DemoHelper.softAsserAll();
			/*
			 * colt_DemoHelper.click("Logout"); reportLog("Log out from the application");
			 */

		
	}
	
	@Test(dataProviderClass = DataProviderRepository.class, dataProvider = "testDataProvider")
	public void test_03_check_Connectivity_And_Price_Of_sites_On_Basis_Of_UI_Segment(Object obj) throws Exception {

		String Description = "Quote_Desc_" + Utilities.getRandomInteger(1, 9999);
		DataModelCPQ cpqModel = (DataModelCPQ) obj;

		/*String mrc_Net_Price = ExcelDataBaseConnector.executeSQLQuery(listPriceConnection, cpqModel, "Zone 1 MRC");
		String _mrc_Net_Price = Utilities.mrcPriceAsPerContractTerm(cpqModel.getContract_Term(), mrc_Net_Price);
		System.out.println(_mrc_Net_Price);

		String nrc_Net_Price = ExcelDataBaseConnector.executeSQLQuery(listPriceConnection, cpqModel, "Zone 1 NRC");
		String _nrc_Net_Price = Utilities.nrcPriceAsPerContractTerm(cpqModel.getContract_Term(), nrc_Net_Price);
		System.out.println(_nrc_Net_Price);

		String currency = ExcelDataBaseConnector.executeSQLQuery(listPriceConnection, cpqModel, "Currency");
		System.out.println(currency);*/

		productListPage.clickOnOrderManagerLink();

		colt_DemoHelper.verifyTitle("Commerce Management");
		reportLog("Verifying the title Commerce Management");

		commerceManagementPage.clickOnAddTransactionButton();
		// colt_DemoHelper.click("NewTransaction");
		reportLog("Click on to NewTransaction link");

		colt_DemoHelper.verifyTitle("Transaction");
		reportLog("Verifying the title 'Transaction'");

		transactionPage.sendKeys(transactionPage.quoteName, cpqModel.getQuoteName());

		// colt_DemoHelper.type("QuoteName", cpqModel.getQuoteName());
		reportLog("Type QuoteName: " + cpqModel.getQuoteName());

		transactionPage.sendKeys(transactionPage.quoteDescription, Description);
		reportLog("Enter description: " + Description);
		
		String currencyType = transactionPage.getUICurrencyType();
		String segment = transactionPage.getUISegment();
		
		String mrc_Net_Price = ExcelDataBaseConnector.executeSQLQuery(listPriceConnection, cpqModel, "Zone 1 MRC");
		String _mrc_Net_Price = Utilities.mrcPriceAsPerContractTerm(cpqModel.getContract_Term(), mrc_Net_Price);
		System.out.println(_mrc_Net_Price);

		String nrc_Net_Price = ExcelDataBaseConnector.executeSQLQuery(listPriceConnection, cpqModel, "Zone 1 NRC");
		String _nrc_Net_Price = Utilities.nrcPriceAsPerContractTerm(cpqModel.getContract_Term(), nrc_Net_Price);
		System.out.println(_nrc_Net_Price);

		String currency = ExcelDataBaseConnector.executeSQLQuery(listPriceConnection, cpqModel, "Currency");
		System.out.println(currency);

		if (!(mrc_Net_Price.equals("NA") || mrc_Net_Price == null)) {
			String str = Utilities.currencyConvertor(_mrc_Net_Price, currency, currencyType);
			_mrc_Net_Price = str;
			System.out.println(str);
			reportLog("MRC_Net Price after conversion: " + str);
		}

		if (!(nrc_Net_Price.equals("NA") || nrc_Net_Price == null)) {
			String str = Utilities.currencyConvertor(_nrc_Net_Price, currency, currencyType);
			_nrc_Net_Price = str;
			System.out.println(str);
			reportLog("NRC_Net Price after conversion: " + str);
		}

		transactionPage.clickOnAddProductBtn();
		reportLog("Click on to AddProduct button");

		colt_DemoHelper.verifyTitle("Product List");
		reportLog("Verifying the title 'Product List'");

		colt_DemoHelper.mouseMove("EtherNet");
		reportLog("Mouse move to EtherNet link");

		productListPage.click(productListPage.ethernetButton);
		productListPage.click(productListPage.ethernetLineLink);
		// colt_DemoHelper.click("EnternetLine");
		reportLog("Click on to EnternetLine");

		colt_DemoHelper.verifyTitle("Model Configuration");
		reportLog("Verifying the title 'Model Configuration'");

		modelConfigurationPage.selectDropDownByText(modelConfigurationPage.resiliency, cpqModel.getResiliency());
		reportLog("Select Resiliency: " + cpqModel.getResiliency());

		modelConfigurationPage.selectDropDownByText(modelConfigurationPage.serviceBandwidth, cpqModel.getBandWidth());
		reportLog("Select BandWidth: " + cpqModel.getBandWidth());

		modelConfigurationPage.sendKeys(modelConfigurationPage.siteAddressAEnd, cpqModel.getSite_A_Add());
		colt_DemoHelper._waitForJStoLoad();
		modelConfigurationPage.pressDownArrowKey();
		modelConfigurationPage.pressEnterKey();
		reportLog("Enter Site A address: " + cpqModel.getSite_A_Add());
		colt_DemoHelper._waitForJStoLoad();

		modelConfigurationPage.sendKeys(modelConfigurationPage.siteAddressBEnd, cpqModel.getSite_B_Add());
		colt_DemoHelper._waitForJStoLoad();
		modelConfigurationPage.pressDownArrowKey();
		modelConfigurationPage.pressEnterKey();
		reportLog("Enter Site B address: " + cpqModel.getSite_B_Add());
		colt_DemoHelper._waitForJStoLoad();

		modelConfigurationPage.click(modelConfigurationPage.update);
		reportLog("Click on to Update button");

		//modelConfigurationPage.enterAddressManually(cpqModel.getBuilding_Type());
		
		modelConfigurationPage.click(modelConfigurationPage.checkConnectivityButton);
		reportLog("Click on to CheckConnectivity button");

		modelConfigurationPage.verifyConnectivity();

		colt_DemoHelper.verifyBlankPriceMessage();

		colt_DemoHelper.verifyBuildingType(cpqModel.getBuilding_Type());

		String contractTerm = cpqModel.getContract_Term();
		modelConfigurationPage.enterContractTerm(contractTerm);

		modelConfigurationPage.click(modelConfigurationPage.addToTransaction);
		
		//modelConfigurationPage.selectAddOns(cpqModel);

		//waitForAjaxRequestsToComplete();
		boolean flag = modelConfigurationPage.isElementDisplayed(modelConfigurationPage.addToTransaction);
		System.out.println("*********************" + flag);
		if (flag) {
			modelConfigurationPage.click(modelConfigurationPage.addToTransaction);
			modelConfigurationPage._waitForJStoLoad();
			flag = false;
		}
			scrollDown("500");

			colt_DemoHelper.verify_NRC_MRC_Prices(_nrc_Net_Price, _mrc_Net_Price);

			modelConfigurationPage.click(modelConfigurationPage.saveBtn);

			productListPage.clickOnOrderManagerLink();
			reportLog("Click on to Order Manager link");

			colt_DemoHelper.softAsserAll();
			/*
			 * colt_DemoHelper.click("Logout"); reportLog("Log out from the application");
			 */

		
	}
}
