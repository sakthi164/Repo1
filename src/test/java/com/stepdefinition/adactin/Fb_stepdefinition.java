package com.stepdefinition.adactin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.adactin.baseclass.Baseclass;
import com.runner.adactin.Fb_runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Fb_stepdefinition  {
	public WebDriver driver; 
	@Given("user launch the application")
	public void user_launch_the_application() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\adactin\\Driver\\latest.exe" );
		driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		System.out.println("user launched the application");
	}

@When("user enters the valid {string} in the username field")
public void user_enters_the_valid_in_the_username_field(String username){
    driver.findElement(By.id("email")).sendKeys(username);
    System.out.println("user enters the username");
}

@When("user enters the valid {string} in the password field")
public void user_enters_the_valid_in_the_password_field(String password){
   driver.findElement(By.name("pass")).sendKeys(password);
   System.out.println("user enters the password");
}
	@When("user clicks the submit button")
	public void user_clicks_the_submit_button() {
		WebElement submit = driver.findElement(By.name("login"));
		submit.click();
		System.out.println("user clicked the submit button");
	}
	@Then("user verifies the homepage")
	public void user_verifies_the_homepage() {
		String title = driver.getTitle();
		boolean contains = title.contains("Home");
		System.out.println("verification : " +contains);
			}
}
