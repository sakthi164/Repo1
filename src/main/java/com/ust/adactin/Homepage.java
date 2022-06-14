package com.ust.adactin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public WebDriver driver;
	
	@FindBy(name ="username")
	private WebElement user;
	@FindBy(id= "password")
	private WebElement pass;
	
	@FindBy(name = "login")
	private WebElement log;
	
	public Homepage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUser() {
		return user;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLog() {
		return log;
	}


	
	

}
