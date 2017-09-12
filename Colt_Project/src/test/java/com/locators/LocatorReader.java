package com.locators;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.util.PropertyReader;

public class LocatorReader {

	private Document doc;
	private PropertyReader propObj;

	public LocatorReader(String xmlName) {
		SAXReader reader = new SAXReader();
		try {
			propObj = new PropertyReader();
			String localPath = propObj.getFilePath();
			localPath = localPath + File.separator + "src" + File.separator + "com" + File.separator + "locators"
					+ File.separator;
			// doc = reader.read(localPath+xmlName);
			System.out.println(System.getProperty("user.dir") + "\\src\\test\\java\\com\\locators\\" + xmlName);
			doc = reader.read(System.getProperty("user.dir") + "\\src\\test\\java\\com\\locators\\" + xmlName);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public String getLocator(String locator) {

		String loc = null;
		try {
			loc = doc.selectSingleNode("//" + locator.replace('.', '/')).getText();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.print(e.getStackTrace());
		}
		return loc;
	}
}
