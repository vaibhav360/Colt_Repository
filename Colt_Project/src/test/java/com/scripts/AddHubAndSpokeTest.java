package com.scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.util.DataModelCPQ;
import com.util.DataProviderRepository;
import com.util.DriverTestCase;
import com.util.ExcelDataBaseConnector;
import com.util.PropertyReader;
import com.util.Utilities;

public class AddHubAndSpokeTest extends DriverTestCase{
	
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
		
		
	@Test(dataProviderClass = DataProviderRepository.class, dataProvider = "testDataProvider")
	public void test_02_check_Connectivity_and_price_of_sites_for_HubAndSpoke(Object obj) throws Exception {

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
		productListPage.click(productListPage.ethernetHubSpokeLink);
		// colt_DemoHelper.click("EnternetLine");
		reportLog("Click on to Enternet Hub&Spoke");

		colt_DemoHelper.verifyTitle("Model Configuration");
		reportLog("Verifying the title 'Model Configuration'");

		
		//modelConfigurationPage.selectDropDownByText(modelConfigurationPage.hubType, cpqModel.getHubType());
		//reportLog("Select H: " + cpqModel.getHubType());
		
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

		/*modelConfigurationPage.sendKeys(modelConfigurationPage.siteAddressBEnd, cpqModel.getSite_B_Add());
		colt_DemoHelper._waitForJStoLoad();
		modelConfigurationPage.pressDownArrowKey();
		modelConfigurationPage.pressEnterKey();
		reportLog("Enter Site B address: " + cpqModel.getSite_B_Add());
		colt_DemoHelper._waitForJStoLoad();*/
		
		modelConfigurationPage.spokeRequired_true.click();
		reportLog("Click on Spoke Required");
		colt_DemoHelper._waitForJStoLoad();
		
		scrollDown("400");
		
		//modelConfigurationPage.numberOfSpokes.sendKeys(cpqModel.getNumberOfSpoke());;
		//reportLog("Enter Number of Spoke Required");
		//colt_DemoHelper._waitForJStoLoad();
		
		modelConfigurationPage.selectDropDownByText(modelConfigurationPage.bandwidthSpoke, "1 Gbps");
		reportLog("Select Spoke Bandwidth: " + "1 Gbps");	
		colt_DemoHelper._waitForJStoLoad();
		
		modelConfigurationPage.sendKeys(modelConfigurationPage.siteAddressSpoke, cpqModel.getSite_A_Add());
		colt_DemoHelper._waitForJStoLoad();
		modelConfigurationPage.pressDownArrowKey();
		modelConfigurationPage.pressEnterKey();
		reportLog("Enter Spoke Address: " + cpqModel.getSite_B_Add());
		colt_DemoHelper._waitForJStoLoad();
		

		modelConfigurationPage.click(modelConfigurationPage.update);
		reportLog("Click on to Update button");
		

		//modelConfigurationPage.enterAddressManually(cpqModel.getBuilding_Type());
		
		modelConfigurationPage.click(modelConfigurationPage.checkConnectivityButton);
		reportLog("Click on to CheckConnectivity button");

		scrollDown("350");
		//modelConfigurationPage.verifyConnectivity();

		//colt_DemoHelper.verifyBlankPriceMessage();

		//colt_DemoHelper.verifyBuildingType(cpqModel.getBuilding_Type());

		String contractTerm = cpqModel.getContract_Term();
		modelConfigurationPage.enterContractTerm(contractTerm);

		modelConfigurationPage.click(modelConfigurationPage.addToTransaction);
		
		//modelConfigurationPage.selectHubAndSpokeAddOns(cpqModel);

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
}
