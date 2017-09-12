package com.util;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public abstract class DriverHelper extends DriverTestCase {
	// Define objects
	protected WebDriver driver;

	protected SoftAssert softAssert = new SoftAssert();

	// Declare objects
	public DriverHelper(WebDriver webdriver) {
		driver = webdriver;
	}

	// Return web driver object
	public WebDriver getWebDriver() {
		return driver;
	}

	// Print message on screen
	public void log(String logMsg) {
		System.out.println(logMsg);
	}

	// Handle locator type
	public By byLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else {
			result = By.id(locator.replace("id=", ""));
		}
		return result;
	}

	// Assert element present
	public Boolean isElementPresent(String locator) {
		Boolean result = false;
		try {
			// getWebDriver().findElement(byLocator(locator));
			fluentWait(locator);
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}

	public Boolean isElementPresent(By locator) {
		Boolean result = false;
		try {
			// getWebDriver().findElement(locator);
			fluentWait(locator);
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}

	// Wait for element present
	public void waitForElementPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Handle click action
	public void clickOn(String locator) {
		this.waitForElementPresent(locator, DEFAULT_WAIT_4_ELEMENT);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		el.click();
	}

	public void clickOn(By locator) {
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(locator);
		el.click();
	}

	// Handle send keys action
	public void sendKeys(String locator, String str) {
		this.waitForElementPresent(locator, DEFAULT_WAIT_4_ELEMENT);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		el.clear();
		el.sendKeys(str);
	}

	// Store text from a locator
	public String getText(String locator) {
		waitForElementPresent(locator, DEFAULT_WAIT_4_ELEMENT);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		String text = getWebDriver().findElement(byLocator(locator)).getText();
		return text;
	}

	// Get attribute value
	public String getAttribute(String locator, String attribute) {
		waitForElementPresent(locator, DEFAULT_WAIT_4_ELEMENT);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		String text = getWebDriver().findElement(byLocator(locator)).getAttribute(attribute);
		return text;
	}

	public Integer getXpathCount(String locator) {
		waitForElementPresent(locator, DEFAULT_WAIT_4_ELEMENT);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		int a = driver.findElements(By.xpath(locator)).size();
		return a;
	}

	public void waitForWorkAroundTime(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyTitle(String title) {
		waitForWorkAroundTime(4000);
		String actualTitle = getWebDriver().getTitle();
		Assert.assertTrue(actualTitle.contains(title));
		reportLog("Expected Title: " + title + "" + " <br /> Actual Title: " + actualTitle);
	}

	public void mouseOver(String locator) {
		this.waitForElementPresent(locator, DEFAULT_WAIT_4_ELEMENT);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		Actions action = new Actions(getWebDriver());
		action.moveToElement(el).build().perform();
	}

	public void selectByText(String locator, String text) {
		this.waitForElementPresent(locator, DEFAULT_WAIT_4_ELEMENT);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		Select select = new Select(el);
		select.selectByVisibleText(text);
	}

	/**
	 * Select drop down by value
	 * 
	 * @author himanshud
	 * @param locator
	 * @param value
	 */
	public void selectByValue(String locator, String value) {
		this.waitForElementPresent(locator, DEFAULT_WAIT_4_ELEMENT);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		Select select = new Select(el);
		select.selectByValue(value);
	}

	public void typeKeys(String locator, Keys key) {
		this.waitForElementPresent(locator, DEFAULT_WAIT_4_ELEMENT);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		el.sendKeys(key);
	}

	public void pressTabKey() {
		Actions builder = new Actions(getWebDriver());
		builder.sendKeys(Keys.TAB).perform();
	}

	public void pressEnterKey() {
		Actions builder = new Actions(getWebDriver());
		builder.sendKeys(Keys.ENTER).perform();
	}

	public void pressDownArrowKey() {
		Actions builder = new Actions(getWebDriver());
		builder.sendKeys(Keys.ARROW_DOWN).perform();
	}

	public void pressUpArrowKey() {
		Actions builder = new Actions(getWebDriver());
		builder.sendKeys(Keys.ARROW_UP).perform();
	}

	public void waitForElement(WebElement element) {
		// logger.info("waitForElement");
		WebDriverWait wait = new WebDriverWait(getWebDriver(), DEFAULT_WAIT_4_ELEMENT);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElement(String locator) {
		// logger.info("waitForElement");
		WebDriverWait wait = new WebDriverWait(getWebDriver(), DEFAULT_WAIT_4_ELEMENT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator(locator)));
	}

	public void javascriptButtonClick(String locator) {
		WebElement element = getWebDriver().findElement(byLocator(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void javascriptSendKeys(String locator, String data) {
		WebElement element = getWebDriver().findElement(byLocator(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + data + "'", element);
	}

	public void javascriptScrollIntoView(String locator) {
		WebElement element = getWebDriver().findElement(byLocator(locator));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

	public WebElement fluentWait(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return foo;
	};

	public WebElement fluentWait(final String locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(byLocator(locator));
			}
		});

		return foo;
	};

	public WebElement SafeFindElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);

		// wait.IgnoreExceptionTypes(typeof());
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			String error = "Unable to locate element: {\"method\":\"" + locator.getClass() + "\",\"selector\":\""
					+ locator.getClass() + "\"}";
			reportLog(e.getMessage());
		}
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			reportLog(e.getMessage());
			throw new NoSuchElementException(e.getMessage());
		}
	}
}