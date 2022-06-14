package com.runner.adactin;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/java/com/feature/adactin/fblogin.feature",glue="com.stepdefinition.adactin")

public class Fb_runner {
	
	}
	


