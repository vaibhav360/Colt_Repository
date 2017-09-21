package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.util.BasePage;
import com.util.DataModelCPQ;
import com.util.DriverTestCase.BuildingType;

public class Model_Configuration_Page extends BasePage {

	public Model_Configuration_Page(WebDriver driver) {
		super(driver);
		// PageFactory.initElements(driver, Model_Configuration_Page.class);
	}

	@FindBy(id = "serviceBandwidth")
	public WebElement serviceBandwidth;

	@FindBy(id = "resiliency")
	public WebElement resiliency;

	@FindBy(id = "siteAddressAEnd")
	public WebElement siteAddressAEnd;

	@FindBy(id = "siteAddressBEnd")
	public WebElement siteAddressBEnd;

	@FindBy(xpath = "//*[@id='manuallyEnterAEndAddress']/span")
	public WebElement manuallyEnterHubEndAddress;

	@FindBy(xpath = "//*[@id='siteTelephoneNumberAEnd']")
	public WebElement siteTelephoneNumber;

	@FindBy(xpath = "//input[@id='spokeRequired_true']")
	public WebElement spokeRequired_true;

	@FindBy(xpath = "//input[@id='numberOfSpokes']")
	public WebElement numberOfSpokes;

	@FindBy(xpath = "//input[@id='manuallyEnterSpokeAddress_true']")
	public WebElement manuallyEnterSpokeAddress;

	@FindBy(xpath = "//*[@id='bandwidthSpoke-0']")
	public WebElement bandwidthSpoke;

	@FindBy(xpath = "//*[@id='siteAddressSpoke-0']")
	public WebElement siteAddressSpoke;

	@FindBy(xpath = "//*[@id='siteTelephoneNumberSpokeArray-0']")
	public WebElement siteTelephoneNumberSpokeArray;

	@FindBy(id = "update")
	public WebElement update;

	@FindBy(xpath = "//a[@name='next']")
	public WebElement checkConnectivityButton;

	@FindBy(id = "return_-_transaction")
	public WebElement returnToQuoteButton;

	@FindBy(id = "start_over")
	public WebElement start_over;

	@FindBy(id = "contractTermInMonths")
	public WebElement contractTerm;

	@FindBy(id = "tab-addOn")
	public WebElement addOnTab;

	@FindBy(id = "outsideBusinessHoursInstallationAEnd_true")
	public WebElement outsideBHI_Site_A;

	@FindBy(id = "outsideBusinessHoursInstallationBEnd_true")
	public WebElement outsideBHI_Site_B;

	@FindBy(id = "dualEntryAEnd_true")
	public WebElement dual_Entry_Site_A;

	@FindBy(id = "dualEntryBEnd_true")
	public WebElement dual_Entry_Site_B;

	@FindBy(id = "longLiningAEnd_true")
	public WebElement longLining_A;

	@FindBy(id = "longLiningBEnd_true")
	public WebElement longLining_B;

	@FindBy(id = "internalCablingAEnd_true")
	public WebElement ic_Site_A;

	@FindBy(id = "internalCablingBEnd_true")
	public WebElement ic_Site_B;

	@FindBy(id = "linkAggregationLAGAEnd_true")
	public WebElement lag_Site_A;

	@FindBy(id = "linkAggregationLAGBEnd_true")
	public WebElement lag_Site_B;

	@FindBy(id = "diversity_true")
	public WebElement diversity;

	@FindBy(id = "classOfServiceAddon_true")
	public WebElement cos;

	@FindBy(id = "performanceReportingAddon_true")
	public WebElement pr;

	@FindBy(id = "proactiveManagementAddon_true")
	public WebElement pam;

	@FindBy(id = "fasttrackAddon_true")
	public WebElement fastTrack;

	@FindBy(id = "outOfBusinessHoursPrim")
	public WebElement sync;

	@FindBy(id = "selectFloor_AEndPrim")
	public WebElement aEndFloor;

	@FindBy(id = "selectFloor_BEndPrim")
	public WebElement AEndFloor;

	@FindBy(xpath = "//*[@id='tab-defaultTab']/a/span/span/span")
	public WebElement sitedetails;

	@FindBy(xpath = "//span[text()='Manually enter A End Address']")
	public WebElement manuallyEnterA;

	@FindBy(xpath = "//span[text()='Manually enter B End Address']")
	public WebElement manuallyEnterB;

	@FindBy(id = "premiseNumberAEnd")
	public WebElement buildingInputBox_A;

	@FindBy(id = "premiseNumberBEnd")
	public WebElement buildingInputBox_B;

	@FindBy(xpath = "//*[@id='connectivityOptionsAEnd']/span")
	public WebElement connectivityMsgA;

	@FindBy(xpath = "//*[@id='connectivityOptionsBEnd']/span")
	public WebElement connectivityMsgB;

	@FindBy(id = "connectivityOptionsBEnd")
	public WebElement siteMsgB;

	@FindBy(id = "connectivityOptionsAEnd")
	public WebElement siteMsgA;

	@FindBy(id = "add_to_transaction")
	public WebElement addToTransaction;

	@FindBy(id = "save")
	public WebElement saveBtn;
	
	@FindBy(id = "carrierHotelCrossConnectAEnd_true")
	public WebElement crossEnd_A;
	
	@FindBy(id = "carrierHotelCrossConnectBEnd_true")
	public WebElement crossEnd_B;
	

	public void enterBuildingNumberManually(WebElement locator) {
		String[] data;
		String num;
		String tmp = getAttribute(locator, "value");
		if (tmp.contains("-")) {
			data = tmp.split("-");
			num = data[1];
			sendKeys(locator, num);
		}
	}

	public void enterAddressManually(String type) throws InterruptedException {

		type = type.replace("-", "_");
		BuildingType choice = BuildingType.valueOf(type);
		switch (choice) {
		case RB_DC_K:
			clickOn(manuallyEnterB);
			enterBuildingNumberManually(buildingInputBox_B);
			break;
		case DC_K_DC_K:
			clickOn(manuallyEnterA);
			enterBuildingNumberManually(buildingInputBox_A);
			clickOn(manuallyEnterB);
			enterBuildingNumberManually(buildingInputBox_B);
			break;
		case DC_S_DC_K:
			clickOn(manuallyEnterB);
			enterBuildingNumberManually(buildingInputBox_B);
			break;
		default:
			reportLog("Building type nit contains DC_Key building");
		}
		waitAndClick(update);
		reportLog("Click on to Update button");
	}

	public void verifyConnectivity() {
		boolean flag = isElementDisplayed(connectivityMsgA);
		String siteA = null;
		String siteB = null;
		if (flag) {
			siteA = connectivityMsgA.getText();
			Assert.fail("Site A address have connection issue. Getting Msg: "+siteA);
		}
		flag = isElementDisplayed(connectivityMsgB);
		if (flag) {
			siteB = connectivityMsgB.getText();
			Assert.fail("Site A address have connection issue. Getting Msg: "+siteB);
		}

	}

	public String getConnectivityMessageForAddress(String site) {

		String siteA = connectivityMsgA.getText();
		String siteB = connectivityMsgB.getText();
		String site_A = siteMsgA.getText();
		String site_B = siteMsgB.getText();
		String msg = null;
		boolean flag = false;
		if (site.equals("A")) {
			flag = isElementPresent(siteA);
			if (flag)
				msg = getText(siteA);
			else
				msg = getText(site_A);
		}

		if (site.equals("B")) {
			flag = isElementPresent(siteB);
			if (flag)
				msg = getText(siteB);
			else
				msg = getText(site_B);
		}
		return msg;
	}
	
	public void selectAddOns(DataModelCPQ model) throws InterruptedException {

		javascriptButtonClick(addOnTab);
		reportLog("Click on to the Add On Tab");
		_waitForJStoLoad();

		clickParticularAddOn(outsideBHI_Site_B, model.getOutsideBHI_Site_B());
		reportLog("Select outsideBHI_Site_B add on");

		clickParticularAddOn(outsideBHI_Site_A, model.getOutsideBHI_Site_B());
		reportLog("Select outsideBHI_Site_A add on");

		clickParticularAddOn(dual_Entry_Site_A, model.getDual_Entry_Site_A());
		reportLog("Select dual_Entry_Site_A add on");

		clickParticularAddOn(dual_Entry_Site_B, model.getDual_Entry_Site_B());
		reportLog("Select dual_Entry_Site_B add on");

		if (isElementDisplayed(longLining_A)) {
			clickParticularAddOn(longLining_A, model.getLongLining_A());
			reportLog("Select longLining_A add on");
		} else {
			clickParticularAddOn(crossEnd_A, model.getLongLining_A());
			reportLog("Select crossEnd_A add on");
		}
		if (isElementPresent(longLining_B)) {
			clickParticularAddOn(longLining_B, model.getLongLining_A());
			reportLog("Select longLining_A add on");
		} else {
			clickParticularAddOn(crossEnd_B, model.getLongLining_A());
			reportLog("Select crossEnd_B add on");
		}

		clickParticularAddOn(ic_Site_A, model.getIc_Site_A());
		reportLog("Select Internal Cabelling Site_A add on");

		clickParticularAddOn(ic_Site_B, model.getIc_Site_B());
		reportLog("Select Internal Cabelling Site_B add on");

		clickParticularAddOn(lag_Site_A, model.getLag_Site_A());
		reportLog("Select lag_Site_A add on");

		clickParticularAddOn(lag_Site_B, model.getLag_Site_B());
		reportLog("Select lag_Site_B add on");

		clickParticularAddOn(diversity, model.getDiversity());
		reportLog("Select diversity add on");

		clickParticularAddOn(cos, model.getCos());
		reportLog("Select Class of Service add on");

		clickParticularAddOn(pr, model.getPr());
		reportLog("Select Performance Reporting add on");

		clickParticularAddOn(pam, model.getPam());
		reportLog("Select Pro Active Management add on");

		clickParticularAddOn(fastTrack, model.getFastTrack());
		reportLog("Select fastTrack add on");

	}
	
	public void clickParticularAddOn(WebElement locator, String data) throws InterruptedException {

		if (!(data == null || data.equals("No"))) {
			javascriptScrollIntoView(locator); 
			waitAndClick(locator);
			_waitForJStoLoad();
		}
	}
	
	public void enterContractTerm(String term)  {
		
		term= term.indexOf(".") < 0 ? term : term.replaceAll("0*$", "").replaceAll("\\.$", "");
		javascriptSendKeys(contractTerm,term);
		_waitForJStoLoad();
		reportLog("Contract Term: " + term);
	}

}
