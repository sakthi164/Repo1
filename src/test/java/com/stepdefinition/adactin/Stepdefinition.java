package com.stepdefinition.adactin;

import org.openqa.selenium.WebDriver;

import com.adactin.baseclass.Baseclass;
import com.runner.adactin.Runner;
import com.ust.adactin.Homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition extends Baseclass {
	public WebDriver driver = Runner.driver;
	

	@Given("user launches the application")
	public void user_launches_the_application() {
	webpage("https://adactinhotelapp.com/");
		}

	@When("user enters the valid username in the username field")
	public void user_enters_the_valid_username_in_the_username_field() {
		
}
	@And("user enters the valid password in the password field")
	public void user_enters_the_valid_passwoed_in_the_password_field() {
		
	}
	@Then("user clicks the on the login button")
	public void user_clicks_the_on_the_login_button() {
		
	}


}