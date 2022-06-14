package com.stepdefinition.adactin;

import org.openqa.selenium.WebDriver;

import com.adactin.baseclass.Baseclass;
import com.runner.adactin.GoogleTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleStepDef extends Baseclass {

	public static WebDriver driver=GoogleTest.driver;

	@Given("Enters the google Url")
	public void enters_the_google_url() {
		webpage("http:www.google.com");
	}
	@When("Getting the Title of Google")
	public void getting_the_title_of_google() {
		System.out.println(driver.getTitle());
	}
	@Then("Close the Browser")
	public void close_the_browser() {
			Quit_tab();
	}
}
