package com.runner.adactin;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.adactin.baseclass.Baseclass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Public\\adactin\\src\\test\\java\\com\\feature\\adactin\\Adactin.feature",
glue = "com.stepdefinition.adactin",
monochrome = true,
dryRun = true,
stepNotifications = true,
publish = true)
public class Runner {
	public static WebDriver driver;
	@BeforeClass
	public static void setUp () {
		driver = Baseclass.BrowserLaunch("chrome");
		
	}

}
