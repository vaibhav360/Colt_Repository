package com.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.util.DriverTestCase;

public class Sample extends DriverTestCase {

	
	@Test
	void checkAllLinks() {
		
		getWebDriver().navigate().to("http://toolsqa.com/selenium-webdriver/find-all-the-links/");
		
		List<WebElement> list = getWebDriver().findElements(By.tagName("a"));
		
		System.out.println(list.size());
		
		
		
		
		
	}
	
	
}
