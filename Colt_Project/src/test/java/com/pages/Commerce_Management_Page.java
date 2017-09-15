package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.BasePage;

public class Commerce_Management_Page extends BasePage {
	
	public Commerce_Management_Page(WebDriver driver) {
		super(driver);
	}
	
	 @FindBy(id="new_transaction")
	 public  WebElement newTransactionButton ;
	 
	 @FindBy(id="copy")
	 public  WebElement copyButton ;
	 
	 @FindBy(xpath="//img[@title='Home']")
	 public  WebElement homePageButton ;
	
	 @FindBy(id="refresh")
	 public  WebElement refreshButton ;
	 
	 @FindBy(id="search")
	 public  WebElement searchButton ;
	 
	 public void clickOnAddTransactionButton()
		{
			//waitForElementVisible(newTransactionButton);
			waitAndClick(newTransactionButton);
			_waitForJStoLoad();
		}

}
