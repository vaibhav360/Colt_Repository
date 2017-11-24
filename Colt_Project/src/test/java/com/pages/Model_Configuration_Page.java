package com.pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.constants.GlobalConstant;
import com.util.BasePage;
import com.util.DataModelCPQ;
import com.util.DriverTestCase.BuildingType;

public class Model_Configuration_Page extends BasePage {

	public Model_Configuration_Page(WebDriver driver) {
		super(driver);
		// PageFactory.initElements(driver, Model_Configuration_Page.class);
	}

	@FindBy(name = "serviceBandwidth")
	public WebElement serviceBandwidth;

	@FindBy(id = "resiliency")
	public WebElement resiliency;

	@FindAll({ @FindBy(id = "siteAddressAEnd"), @FindBy(name = "siteAddressAEnd") })
	public WebElement siteAddressAEnd;

	@FindAll({ @FindBy(id = "siteAddressBEnd"), @FindBy(name = "siteAddressBEnd") })
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

	@FindBy(name = "coveragePage2")
	public WebElement coverage;

	@FindBy(xpath = "//*[@id='bandwidthSpoke-1']")
	public WebElement bandwidthSpoke1;

	@FindBy(xpath = "//*[@id='siteAddressSpoke-1']")
	public WebElement siteAddressSpoke1;

	@FindBy(xpath = "//*[text()='Add to Quote']")
	public WebElement addtoquote;

	@FindBy(xpath = "//*[text()='Quote']")
	public WebElement gotoquote;

	@FindBy(name = "nRCDiscountType_t")
	public WebElement discount;

	@FindBy(xpath = "//*[text()='Percentage Off']")
	public WebElement percentageoff;

	@FindBy(id = "discountNRCPerc_t")
	public WebElement nrcdiscount;

	@FindBy(id = "discountMRCPerc_t")
	public WebElement mrcdiscount;

	@FindBy(xpath = "//*[text()='Approval']")
	public WebElement approval;

	@FindBy(id = "save")
	public WebElement save;

	@FindBy(name = "submitForReviewCheckbox_t")
	public WebElement submitcheckbox;

	@FindBy(xpath = "(//a[text()='Submit'])[2]")
	public WebElement submit;

	@FindBy(xpath = "div#loading-dialog")
	public WebElement loadingDailog;

	@FindBy(css = ".messages.clearfix p")
	public WebElement messageError;

	@FindBy(xpath = "//*[text()='BlankPrices: ']")
	public WebElement blankPriceMsg;

	@FindBy(xpath = "(//span[@data-varname='discountMRC_l'])[1]")
	public WebElement quoteDiscountMRC;

	@FindBy(xpath = "(//span[@data-varname='discountNRC_l'])[1]")
	public WebElement quoteDiscountNRC;

	@FindBy(css = ".bm-approval-history ul li")
	public WebElement approvalMsg;

	@FindBy(xpath = "(//input[@name='spokeContractTerm1'])[1]")
	public WebElement spokeContractTerm;

	@FindBy(id = "siteTypeAEnd")
	public WebElement buildingTypeA;

	@FindBy(id = "siteTypeBEnd")
	public WebElement buildingTypeB;

	@FindBy(xpath = "//*[text()='B end address is mandatory']")
	public WebElement errorAddressB;

	@FindBy(xpath = "//*[text()='A end address is mandatory']")
	public WebElement errorAddressA;

	@FindBy(name = "premiseNumberAEnd")
	public WebElement premiseNumberAEnd;

	@FindBy(name = "premiseNumberBEnd")
	public WebElement premiseNumberBEnd;

	@FindBy(name = "streetNameAEnd")
	public WebElement streetNameAEnd;

	@FindBy(name = "streetNameBEnd")
	public WebElement streetNameBEnd;

	@FindBy(name = "cityAEnd")
	public WebElement cityAEnd;

	@FindBy(name = "cityBEnd")
	public WebElement cityBEnd;

	@FindBy(name = "countryAEnd")
	public WebElement countryAEnd;
	
	@FindBy(name = "countryBEnd")
	public WebElement countryBEnd;

	@FindBy(name = "postCodeAEnd")
	public WebElement postCodeAEnd;

	@FindBy(name = "postCodeBEnd")
	public WebElement postCodeBEnd;

	@FindBy(name = "premises_master_id_a_end")
	public WebElement premises_master_id_a_end;

	@FindBy(name = "premises_master_id_b_end")
	public WebElement premises_master_id_b_end;

	@FindBy(name = "selectedConnectivityOptionsRowAEnd_hidden")
	public WebElement selectedConnectivityOptionsRowAEnd;

	@FindBy(name = "selectedConnectivityOptionsRowBEnd_hidden")
	public WebElement selectedConnectivityOptionsRowBEnd;

	@FindBy(name = "siteTypeAEnd")
	public WebElement siteTypeAEnd;

	@FindBy(name = "siteTypeBEnd ")
	public WebElement siteTypeBEnd;
	
	@FindBy(xpath = "//*[@id=\"chargesServiceLevel\"]/table/tbody/tr[2]/td[2]")
	public WebElement copyaddress;
	
	
	@FindBy(name = "resiliency") 
	public WebElement resilencyjavascript;
	
	
	@FindBy(name = "pricingSegment")
	public WebElement pricingSegment;
	
	
	@FindBy(xpath = "//div[@id='chargesServiceLevel']/table//tr[2]/td[2]") 
	public WebElement nrcPrice;
	
	
	@FindBy(xpath = "//div[@id='chargesServiceLevel']/table//tr[2]/td[3]")
	public WebElement mrcPrice;
	
	
	@FindBy(name = "contractTermInMonths")
	public WebElement contractTermInMonths;
	
	
	@FindBy(name = "currency")
	public WebElement currency;
	
	
	
	//div[@id='chargesServiceLevel']/table//tr[2]/td[3]

	public void enterHubAndSpokeAddress(DataModelCPQ cpqModel) {
		modelConfigurationPage.selectDropDownByText(modelConfigurationPage.resiliency, cpqModel.getResiliency());
		reportLog("Select Resiliency: " + cpqModel.getResiliency());

		modelConfigurationPage.selectDropDownByText(modelConfigurationPage.serviceBandwidth, cpqModel.getBandWidth());
		reportLog("Select BandWidth: " + cpqModel.getBandWidth());

		sendKeys(modelConfigurationPage.siteAddressAEnd, cpqModel.getSite_A_Add());
		_waitForJStoLoad();
		pressDownArrowKey();
		pressEnterKey();
		reportLog("Enter Site A address: " + cpqModel.getSite_A_Add());
		_waitForJStoLoad();

		modelConfigurationPage.spokeRequired_true.click();
		reportLog("Click on Spoke Required");
		_waitForJStoLoad();

		scrollDown("400");
		selectDropDownByText(modelConfigurationPage.bandwidthSpoke, cpqModel.getSpokeBandwidth());
		reportLog("Select Spoke Bandwidth: " + "1 Gbps");
		_waitForJStoLoad();

		sendKeys(modelConfigurationPage.siteAddressSpoke, cpqModel.getSite_A_Add());
		_waitForJStoLoad();
		pressDownArrowKey();
		pressEnterKey();
		reportLog("Enter Spoke Address: " + cpqModel.getSite_B_Add());
		_waitForJStoLoad();
	}

	/**
	 * This method is used for verifying the building types
	 * 
	 * @author himanshud
	 * @param type
	 */
	public void verifyBuildingType(String type) {

		String typeA = buildingTypeA.getAttribute("value");
		String typeB = buildingTypeB.getAttribute("value");
		type = type.replace("-", "_");
		BuildingType choice = BuildingType.valueOf(type);
		switch (choice) {
		case RB_RB:
			softAssert.assertTrue(typeA.equals(GlobalConstant.BUILDING_RETAIL), "Site A is not Retail Building");
			softAssert.assertTrue(typeB.equals(GlobalConstant.BUILDING_RETAIL), "Site B is not Retail Building");
			break;
		case RB_DC_K:
			softAssert.assertTrue(typeA.equals(GlobalConstant.BUILDING_RETAIL), "Site A is not Retail Building");
			softAssert.assertTrue(typeB.equals(GlobalConstant.BUILDING_KEY), "Site B is not DC Key Building");
			break;
		case RB_DC_S:
			softAssert.assertTrue(typeA.equals(GlobalConstant.BUILDING_RETAIL), "Site A is not Retail Building");
			softAssert.assertTrue(typeB.equals(GlobalConstant.BUILDING_STANDARD), "Site B is not DC Standard Building");
			break;
		case DC_K_DC_K:
			softAssert.assertTrue(typeA.equals(GlobalConstant.BUILDING_KEY), "Site A is not DC Key Building");
			softAssert.assertTrue(typeB.equals(GlobalConstant.BUILDING_KEY), "Site B is not DC Key Building");
			break;
		case DC_S_DC_S:
			softAssert.assertTrue(typeA.equals(GlobalConstant.BUILDING_STANDARD), "Site A is not DC Standard Building");
			softAssert.assertTrue(typeB.equals(GlobalConstant.BUILDING_STANDARD), "Site B is not DC Standard Building");
			break;
		case DC_S_DC_K:
			softAssert.assertTrue(typeA.equals(GlobalConstant.BUILDING_STANDARD), "Site A is not DC Standard Building");
			softAssert.assertTrue(typeB.equals(GlobalConstant.BUILDING_KEY), "Site B is not DC Key Building");
			break;
		default:
			softAssert.fail("Please specify the correct type of Building");
		}

	}

	public String getBuildingTypeForSiteA() {
		String tmp = buildingTypeA.getAttribute("value");
		if (tmp.equals("DC- Standard"))
			return BuildingType.DC_S.toString();
		if (tmp.equals("Retail Building"))
			return BuildingType.RB.toString();
		if (tmp.equals("DC- Key"))
			return BuildingType.DC_C.toString();
		return tmp;
	}

	public String getBuildingTypeForSiteB() {
		return buildingTypeB.getAttribute("value");
	}

	public void verifyBlankPricesMessage() {
		boolean flag = isElementDisplayed(blankPriceMsg);
		boolean _flag = isElementDisplayed(messageError);
		if (flag) {
			String msg = blankPriceMsg.getText();
			Assert.fail("Error Message displays: " + msg);
		}
		if (_flag) {
			String msg = messageError.getText();
			System.out.println(msg);
			Assert.fail("Error Message displays: " + msg);
		}
		reportLog("Prices are available");
	}

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

	public void enterAddresses(String siteA, String siteB) {
		sendKeys(siteAddressAEnd, siteA);
		_waitForJStoLoad();
		pressDownArrowKey();
		pressEnterKey();
		reportLog("Enter Site A address: " + siteA);
		_waitForJStoLoad();

		sendKeys(siteAddressBEnd, siteB);
		_waitForJStoLoad();
		pressDownArrowKey();
		pressEnterKey();
		reportLog("Enter Site B address: " + siteB);
		_waitForJStoLoad();
	}

	public void selectBandwidthAndResiliencyInEthernet(String band, String res) {
		selectDropDownByText(resiliency, res);
		reportLog("Select Resiliency: " + res);

		selectDropDownByText(serviceBandwidth, band);
		reportLog("Select BandWidth: " + band);
	}

	public void verifyConnectivity() {
		boolean flag = isElementDisplayed(connectivityMsgA);
		String siteA = null;
		String siteB = null;
		if (flag) {
			siteA = connectivityMsgA.getText();
			Assert.fail("Site A address have connection issue. Getting Msg: " + siteA);
		}
		flag = isElementDisplayed(connectivityMsgB);
		if (flag) {
			javascriptScrollIntoView(connectivityMsgB);
			siteB = connectivityMsgB.getText();
			Assert.fail("Site A address have connection issue. Getting Msg: " + siteB);
		}
		reportLog("Connectivity is available for both the addresses");
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

	public String enterContractTerm(String product, String term) {

		term = term.indexOf(".") < 0 ? term : term.replaceAll("0*$", "").replaceAll("\\.$", "");
		if (product.equals("Ethernet")) {
			javascriptSendKeys(contractTerm, term);
		}
		if (product.equals("Hub")) {
			sendKeys(spokeContractTerm, term);
		}
		// _waitForJStoLoad();
		reportLog("Contract Term for " + product + ": " + term);
		return term;
	}

	public String getUICoverage() {
		String value = coverage.getAttribute("Value");
		return value;
	}

	public void addDetailsfromEthernetLineTositedetails() throws InterruptedException {

		selectDropDownByText(resiliency, "Protected");
		reportLog("Select Resiliency: Protected ");

		selectDropDownByText(serviceBandwidth, "100 Gbps");
		reportLog("Select BandWidth: 100 Gbps");
		_waitForJStoLoad();

		// Enter End A site Address
		sendKeys(siteAddressAEnd, "72, Adersstraße, Düsseldorf, Germany, 40215");
		_waitForJStoLoad();
		pressDownArrowKey();
		pressEnterKey();
		reportLog("Enter Site A address: 91, Vogelsanger Weg, Düsseldorf, Germany, 40470");

		// Enter End B site Address
		sendKeys(siteAddressBEnd, "Humboldtstraße 4, Düsseldorf, Germany, 40237");
		_waitForJStoLoad();
		pressDownArrowKey();
		pressEnterKey();
		reportLog("Enter Site A address: 91, Vogelsanger Weg, Düsseldorf, Germany, 40470");
		_waitForJStoLoad();

		update.click();
		reportLog("Click on to Update button");
		_waitForJStoLoad();

		// Click on Check Connectivity Button
		checkConnectivityButton.click();
		reportLog("Click on to CheckConnectivity button");
		_waitForJStoLoad();

		verifyConnectivity();
		verifyBlankPricesMessage();

		addOnTab.click();
		reportLog("Select Internal Cabelling Site_A add on");
		_waitForJStoLoad();
		outsideBHI_Site_A.click();
		reportLog("Select OutSide Business Hour Installation Site A");

		outsideBHI_Site_B.click();
		reportLog("Select OutSide Business Hour Installation Site B");

		// dual_Entry_Site_A.click();
		reportLog("Select dual entry for Site A");

		// dual_Entry_Site_B.click();
		reportLog("Select dual entry for Site B");

		ic_Site_B.click();
		reportLog("Select Internal Cabelling Site_B add on");

		ic_Site_A.click();
		reportLog("Select Internal Cabelling Site_A add on");

		lag_Site_A.click();
		reportLog("Select LAG Site A");

		lag_Site_B.click();
		reportLog("Select LAG Site B");

		diversity.click();
		reportLog("Select Diversity");

		cos.click();
		reportLog("Select Class of Service add on");

		pr.click();
		reportLog("Select Performance Reporting add on");

		pam.click();
		reportLog("Select Pro Active Management add on");

		javascriptScrollIntoView(fastTrack);
		fastTrack.click();
		reportLog("Select Fast Track ");

		javascriptButtonClick(addtoquote);
		reportLog("Click on Add to Quote button");
		_waitForJStoLoad();

	}

	public void AddDetailsHubSpokeTositedetails() {

		selectDropDownByText(resiliency, "Protected");
		reportLog("Select Resiliency: Protected");

		selectDropDownByText(serviceBandwidth, "10 Gbps");
		reportLog("Select BandWidth: 100 Gbps");

		sendKeys(siteAddressAEnd, "Julius-Tandler-Platz 3 1090 Vienna, Austria");
		sleepExecution(2);
		pressDownArrowKey();
		pressEnterKey();
		reportLog("Enter Site A address: Julius-Tandler-Platz 3 1090 Vienna, Austria");
		_waitForJStoLoad();

		spokeRequired_true.click();
		reportLog("Click on Spoke Required");
		_waitForJStoLoad();

		scrollDown("400");
		javascriptSendKeys(numberOfSpokes, "2");
		pressEnterKey();
		_waitForJStoLoad();

		selectDropDownByText(bandwidthSpoke, "1 Gbps");
		reportLog("Select Spoke Bandwidth: 1 Gbps");
		_waitForJStoLoad();

		sendKeys(siteAddressSpoke, "Bahnsteggasse 27, Vienna, Austria");
		sleepExecution(2);
		pressDownArrowKey();
		pressEnterKey();
		reportLog("Enter Spoke One Address: 92, Uerdinger Straße, Düsseldorf, Germany, 40474");
		_waitForJStoLoad();
		scrollDown("350");

		Select dropdown1 = new Select(bandwidthSpoke1);
		dropdown1.selectByVisibleText("1 Gbps");
		_waitForJStoLoad();
		// Enter spoke 1 Address
		sendKeys(siteAddressSpoke1, "Kärntner Ring 12 1010 Vienna, Austria");
		sleepExecution(3);
		pressDownArrowKey();
		pressEnterKey();
		reportLog("Enter Spoke Two address: 92, Uerdinger Straße, Düsseldorf, Germany, 40474");
		_waitForJStoLoad();

		click(update);
		reportLog("Click on to Update button");

		click(checkConnectivityButton);
		reportLog("Click on to CheckConnectivity button");
		scrollDown("355");

		verifyBlankPricesMessage();
		click(addToTransaction);

	}

	public void verifyAddressError() {
		boolean flag = isElementDisplayed(errorAddressA);
		String siteA = null;
		String siteB = null;
		if (flag) {
			siteA = errorAddressA.getText();
			Assert.fail("Site A address have connection issue. Getting Msg: " + siteA);
		}
		flag = isElementDisplayed(errorAddressB);
		if (flag) {
			siteB = errorAddressB.getText();
			Assert.fail("Site A address have connection issue. Getting Msg: " + siteB);
		}
	}

	public void enterSiteADetailByJavascript(DataModelCPQ model) {
		String str = "0##Colt LANLink Point to Point (Ethernet Point to Point)"
				+ "**On-Net**Colt**I0042**SESTO-0000076039**Colt Fibre**3rd Party Leased Fibre"
				+ "**NO****NO**NO**ACTIVE**";
		javascriptSendKeys(siteAddressAEnd, model.getSite_A_Add());
		javascriptSendKeys(countryAEnd, model.getCountry());
		javascriptSendKeys(cityAEnd, model.getCityName());
		javascriptSendKeys(postCodeAEnd,removeDecimalValues(model.getPostCode()));
		javascriptSendKeys(premiseNumberAEnd, removeDecimalValues(model.getBuildingNumber()));
		javascriptSendKeys(premises_master_id_a_end, removeDecimalValues(model.getMasterId()));
		javascriptSendKeys(selectedConnectivityOptionsRowAEnd, str);
		javascriptSendKeys(streetNameAEnd, model.getStreetName());
		javascriptSendKeys(buildingTypeA, model.getBuilding_Type());
		

	}
	
	public void enterSiteBDetailByJavascript(DataModelCPQ model) {
		String str = "0##Colt LANLink Point to Point (Ethernet Point to Point)"
				+ "**On-Net**Colt**I0042**SESTO-0000076039**Colt Fibre**3rd Party Leased Fibre"
				+ "**NO****NO**NO**ACTIVE**";
		javascriptSendKeys(siteAddressBEnd, model.getSite_B_Add());
		javascriptSendKeys(countryBEnd, model.getCountry2());
		javascriptSendKeys(cityBEnd, model.getCityName2());
		javascriptSendKeys(postCodeBEnd, removeDecimalValues(model.getPostCode2()));
		javascriptSendKeys(premiseNumberBEnd, removeDecimalValues(model.getBuildingNumber2()));
		javascriptSendKeys(premises_master_id_b_end, removeDecimalValues(model.getMasterId2()));
		javascriptSendKeys(selectedConnectivityOptionsRowAEnd, str);
		javascriptSendKeys(streetNameBEnd, model.getStreetName2());
		javascriptSendKeys(buildingTypeB, model.getBuilding_Type2());
		javascriptSendKeys(serviceBandwidth, model.getBandWidth());
		javascriptSendKeys(resilencyjavascript, model.getResiliency());
		javascriptSendKeys(pricingSegment, model.getSegment());
		javascriptSendKeys(currency, model.getCurrency());
		javascriptSendKeys(contractTermInMonths, removeDecimalValues(model.getContract_Term()));

	}
	
	public void enterWriteProductPrices() throws IOException
	{
		String text = nrcPrice.getText();
		System.out.println("NRC Price :: " + text);
		
		String text1 = mrcPrice.getText();
		System.out.println("MRC Price:: "+ text1);		
		
		PrintWriter out = null;
	    BufferedWriter bufWriter;

	    try{
	        bufWriter =
	            Files.newBufferedWriter(
	                Paths.get("C:/Users/himanshud/Desktop/coltpad.txt"),
	                Charset.forName("UTF8"),	                             
	                StandardOpenOption.APPEND);	              
	        out = new PrintWriter(bufWriter, true);
	    }catch(IOException e){
	        
	    }
	    
	    //After successful creation of PrintWriter
	    out.println("NRC Price : "+  text + "  "+ "MRC Price : " + text1 );
	    
	    //After done writing, remember to close!
	    out.close();
		
		
	
		
	}
	

}
