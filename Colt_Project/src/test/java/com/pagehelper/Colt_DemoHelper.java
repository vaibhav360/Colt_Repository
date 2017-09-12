package com.pagehelper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.locators.LocatorReader;
import com.util.DataModelCPQ;
import com.util.DriverHelper;
import com.util.GlobalConstants;

public class Colt_DemoHelper extends DriverHelper {

	public By outsideBHI_Site_A = By.id("outsideBusinessHoursInstallationAEnd_true");
	public By outsideBHI_Site_B = By.id("outsideBusinessHoursInstallationBEnd_true");
	public By dual_Entry_Site_A = By.id("dualEntryAEnd_true");
	public By dual_Entry_Site_B = By.id("dualEntryBEnd_true");
	public By longLining_A = By.id("longLiningAEnd_true");
	public By longLining_B = By.id("longLiningBEnd_true");
	public By ic_Site_A = By.id("internalCablingAEnd_true");
	public By ic_Site_B = By.id("internalCablingBEnd_true");
	public By lag_Site_A = By.id("linkAggregationLAGAEnd_true");
	public By lag_Site_B = By.id("linkAggregationLAGBEnd_true");
	public By diversity = By.id("diversity_true");
	public By cos = By.id("classOfServiceAddon_true");
	public By pr = By.id("performanceReportingAddon_true");
	public By pam = By.id("proactiveManagementAddon_true");
	public By fastTrack = By.id("fasttrackAddon_true");
	public By sync = By.id("outOfBusinessHoursPrim");
	public By crossEnd_A = By.id("carrierHotelCrossConnectAEnd_true");
	public By crossEnd_B = By.id("carrierHotelCrossConnectBEnd_true");

	public String contractTerm = "contractTermInMonths";
	public String addOnTab = "//span[text()='Add On']";
	public String manuallyEnterA = "//span[text()='Manually enter A End Address']";
	public String manuallyEnterB = "//span[text()='Manually enter B End Address']";
	public String buildingInputBox_A = "premiseNumberAEnd";
	public String buildingInputBox_B = "premiseNumberBEnd";

	private static LocatorReader locatorReader;
	// protected PropertyReader propertyReader = new PropertyReader();

	public Colt_DemoHelper(WebDriver webDriver) {
		super(webDriver);
		locatorReader = new LocatorReader("Colt_Demo.xml");
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
		click("Update");
		reportLog("Click on to Update button");
	}

	public void enterBuildingNumberManually(String locator) {
		String[] data;
		String num;
		String tmp = getAttribute(locator, "value");
		if (tmp.contains("-")) {
			data = tmp.split("-");
			num = data[1];
			sendKeys(locator, num);
		}
	}

	public void loginToApplication(String username, String password) throws InterruptedException {
		// LocatorReader loctorReader = new LocatorReader("Colt_Demo.xml");

		type("Username", username);
		Thread.sleep(3000);
		type("Password", password);
		Thread.sleep(3000);
		// click("Login");
		pressEnterKey();
		waitForAjaxRequestsToComplete();
	}

	// Click on button
	public void click(String button) {
		try {
			String locator = locatorReader.getLocator(button);
			clickOn(locator);
			waitForAjaxRequestsToComplete();
		} catch (Exception e) {
			reportLog(e.getMessage());
		}
	}

	// Enter text into the input field
	public void type(String field, String text) {
		try {
			String locator = locatorReader.getLocator(field);
			sendKeys(locator, text);
		} catch (Exception e) {
			reportLog(e.getMessage());
		}
	}

	public void selectItem(String xpath, int index) {
		String locator = locatorReader.getLocator(xpath);
		waitForElementPresent(locator, 20);
		List<WebElement> el = getWebDriver().findElements(byLocator(locator));
		el.get(index).click();
		waitForWorkAroundTime(5000);
	}

	// To verify field displayed or not
	public boolean verifyFieldDisplayed(String xpath) {
		String locator = locatorReader.getLocator(xpath);
		waitForWorkAroundTime(2000);
		return isElementPresent(locator);
	}

	// To get the text of first element where multiple element of same locator
	// available e.g. 5.0, 5.4

	public String getFirstText(String xpath) {
		String locator = locatorReader.getLocator(xpath);
		waitForElementPresent(xpath, 20);
		List<WebElement> el = getWebDriver().findElements(byLocator(locator));
		return el.get(0).getText();
	}

	// To get the text of a single element
	public String getFieldText(String xpath) {
		String locator = locatorReader.getLocator(xpath);
		return getText(locator);
	}

	// To get the count of element of same locator
	public int getCount(String xpath) {
		String locator = locatorReader.getLocator(xpath);
		return getXpathCount(locator);
	}

	// To get the value of a attribute
	public String getAttributeValue(String field, String attribute) {
		String locator = locatorReader.getLocator(field);
		return getAttribute(locator, attribute);
	}

	public void mouseMove(String field) {
		String locator = locatorReader.getLocator(field);
		mouseOver(locator);
	}

	public void selectDropdown(String dropdown, String text) {
		String locator = locatorReader.getLocator(dropdown);
		selectByText(locator, text);
		waitForWorkAroundTime(4000);
	}

	/**
	 * Select value from drop down
	 * 
	 * @author himanshud
	 * @param dropdown
	 * @param value
	 * @throws InterruptedException
	 */
	public void selectDropdownByValue(String dropdown, String value) throws InterruptedException {
		String locator = locatorReader.getLocator(dropdown);
		selectByValue(locator, value);
		waitForAjaxRequestsToComplete();
	}

	public void selectAddress(String field, Keys key) {
		waitForWorkAroundTime(1000);
		String locator = locatorReader.getLocator(field);
		typeKeys(locator, key);
	}

	public void verifyAddedAddOns(String option1, String option2, String option3, String option4) {
		String locator = locatorReader.getLocator(option1);
		String locator1 = locatorReader.getLocator(option2);
		String locator2 = locatorReader.getLocator(option3);
		String locator3 = locatorReader.getLocator(option4);

		softAssert.assertTrue(isElementPresent(locator));
		softAssert.assertTrue(isElementPresent(locator1));
		softAssert.assertTrue(isElementPresent(locator2));
		softAssert.assertTrue(isElementPresent(locator3));
	}

	public String[] getValues(String table) {
		int size = getCount(table);

		String[] variables = new String[size - 1];

		String locator = locatorReader.getLocator(table);
		int start = 2;
		for (int i = 0; i < variables.length; i++) {
			String newLocator = locator + "[" + start + "]/td[3]";
			variables[i] = getText(newLocator);
			start++;
		}
		return variables;
	}

	public String[] getAttributeValues(String table) {
		int size = getCount(table);

		String[] variables = new String[size];

		String locator = locatorReader.getLocator(table);
		int start = 1;
		for (int i = 0; i < variables.length; i++) {
			String newLocator = locator + "[" + start + "]/td[4]/div/div/input";
			variables[i] = getAttribute(newLocator, "value");
			start++;
		}
		return variables;
	}

	public void compareValues(String[] value, String[] value1) {
		int j = 1;
		for (int i = 0; i < value.length - 1; i++) {
			Assert.assertTrue(value[i].contains(value1[j]));
			j++;
		}
		Assert.assertTrue(value[value.length - 1].contains(value1[0]));
	}

	public String getProductPricingValues(String product, String priceColumn) {

		String locator = null;
		if (priceColumn.equals("NRC (net)")) {
			locator = "//*[text()='" + product + "']/../../../following-sibling::td[4]";
		}

		if (priceColumn.equals("MRC (net)")) {
			locator = "//*[text()='" + product + "']/../../../following-sibling::td[8]";
		}
		String price = getText(locator);
		if (price.contains("$"))
			price = price.replace("$", "");
		else if (price.contains("€")) // Alt 0128
			price = price.replace("€", "");
		else if (price.contains("£")) // Alt 156
			price = price.replace("£", "");
		return price;
	}

	public String getConnectivityMessageForAddress(String site) {
		String siteA = locatorReader.getLocator("connectivityMsgA");
		String siteB = locatorReader.getLocator("connectivityMsgB");
		String site_A = locatorReader.getLocator("siteMsgA");
		String site_B = locatorReader.getLocator("siteMsgB");
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

	public void verifyConnectivityMessage(String msgA, String msgB) {
		if (msgA.equals("Oops!!! Connectivity not found for selected site,")
				|| msgB.equals("Oops!!! Connectivity not found for selected site,")) {
			softAssert.fail("Site A or Site B address have connection issue");
		}
	}

	/**
	 * This method is used for verifying the building types
	 * 
	 * @author himanshud
	 * @param type
	 */
	public void verifyBuildingType(String type) {

		String typeA = getAttributeValue("siteTypeA", "value");
		String typeB = getAttributeValue("siteTypeB", "value");
		type = type.replace("-", "_");
		BuildingType choice = BuildingType.valueOf(type);
		switch (choice) {
		case RB_RB:
			softAssert.assertTrue(typeA.equals(GlobalConstants.BUILDING_RETAIL), "Site A is not Retail Building");
			softAssert.assertTrue(typeB.equals(GlobalConstants.BUILDING_RETAIL), "Site B is not Retail Building");
			break;
		case RB_DC_K:
			softAssert.assertTrue(typeA.equals(GlobalConstants.BUILDING_RETAIL), "Site A is not Retail Building");
			softAssert.assertTrue(typeB.equals(GlobalConstants.BUILDING_KEY), "Site B is not DC Key Building");
			break;
		case RB_DC_S:
			softAssert.assertTrue(typeA.equals(GlobalConstants.BUILDING_RETAIL), "Site A is not Retail Building");
			softAssert.assertTrue(typeB.equals(GlobalConstants.BUILDING_STANDARD),
					"Site B is not DC Standard Building");
			break;
		case DC_K_DC_K:
			softAssert.assertTrue(typeA.equals(GlobalConstants.BUILDING_KEY), "Site A is not DC Key Building");
			softAssert.assertTrue(typeB.equals(GlobalConstants.BUILDING_KEY), "Site B is not DC Key Building");
			break;
		case DC_S_DC_S:
			softAssert.assertTrue(typeA.equals(GlobalConstants.BUILDING_STANDARD),
					"Site A is not DC Standard Building");
			softAssert.assertTrue(typeB.equals(GlobalConstants.BUILDING_STANDARD),
					"Site B is not DC Standard Building");
			break;
		case DC_S_DC_K:
			softAssert.assertTrue(typeA.equals(GlobalConstants.BUILDING_STANDARD),
					"Site A is not DC Standard Building");
			softAssert.assertTrue(typeB.equals(GlobalConstants.BUILDING_KEY), "Site B is not DC Key Building");
			break;
		default:
			softAssert.fail("Please specify the correct type of Building");
		}

	}

	public void verify_NRC_MRC_Prices(String nrc, String mrc) {
		String nrc_Net_Price = getProductPricingValues("Connectivity Charge", "NRC (net)");
		String mrc_Net_Price = getProductPricingValues("Connectivity Charge", "MRC (net)");
		softAssert.assertTrue(nrc_Net_Price.equals(nrc_Net_Price),
				"Prices are not equal. Actual: " + nrc_Net_Price + " Expected: " + nrc_Net_Price);
		reportLog("Verifying the NRC(net) Price of Site A. Actual: " + nrc_Net_Price + " Expected: " + nrc_Net_Price);
		softAssert.assertTrue(mrc_Net_Price.equals(mrc_Net_Price),
				"Prices are not equal. Actual: " + mrc_Net_Price + " Expected: " + mrc_Net_Price);
		reportLog("Verifying the MRC(net) Price of Site B. Actual: " + mrc_Net_Price + " Expected: " + mrc_Net_Price);
		softAssert.assertTrue(mrc_Net_Price.equals(mrc_Net_Price),
				"Prices are not equal. Actual: " + mrc_Net_Price + " Expected: " + mrc_Net_Price);
	}

	public void clickParticularAddOn(By locator, String data) throws InterruptedException {
		
			SafeFindElement(locator);
		if (!(data == null || data.equals("No"))) {
			clickOn(locator);
			waitForAjaxRequestsToComplete();
		}
	}

	public void selectAddOns(DataModelCPQ model) throws InterruptedException {

		javascriptSendKeys(contractTerm, model.getContract_Term());
		reportLog("Entering the Contract Term: " + model.getContract_Term());

		javascriptButtonClick(addOnTab);
		reportLog("Click on to the Add On Tab");
		waitForAjaxRequestsToComplete();

		clickParticularAddOn(outsideBHI_Site_B, model.getOutsideBHI_Site_B());
		reportLog("Select outsideBHI_Site_B add on");

		clickParticularAddOn(outsideBHI_Site_A, model.getOutsideBHI_Site_B());
		reportLog("Select outsideBHI_Site_A add on");

		clickParticularAddOn(dual_Entry_Site_A, model.getDual_Entry_Site_A());
		reportLog("Select dual_Entry_Site_A add on");

		clickParticularAddOn(dual_Entry_Site_B, model.getDual_Entry_Site_B());
		reportLog("Select dual_Entry_Site_B add on");

		if (isElementPresent(longLining_A)) {
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
	
	public void softAsserAll()
	{
		softAssert.assertAll();
	}

}