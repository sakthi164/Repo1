package com.adactin.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Baseclass {
	public static WebDriver driver;

	// browser
	public static WebDriver BrowserLaunch(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\adactin\\Driver\\latest.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", ".//Driver//msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		return driver;
	}

	// url
	public static void webpage(String url) {
		driver.get(url);
	}

	// Navigate
	public static void navigate(String option, String tab) {
		if (option.equalsIgnoreCase("url")) {
			driver.navigate().to(tab);
		} else if (option.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		} else if (option.equalsIgnoreCase("backward")) {
			driver.navigate().back();
		} else if (option.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}

	}

	// click
	public static void click(WebElement element) {
		element.click();
	}

	// Actions
	public static void Actions_key(WebElement element, WebElement drop, String object) {
		Actions a = new Actions(driver);
		try {
			if (object.equalsIgnoreCase("movetoelement")) {
				a.moveToElement(element).build().perform();
			} else if (object.equalsIgnoreCase("doubleclick")) {
				a.doubleClick(element).build().perform();
			} else if (object.equalsIgnoreCase("drag & drop")) {
				a.dragAndDrop(element, drop).build().perform();
			} else if (object.equalsIgnoreCase("contextclick")) {
				a.contextClick(element).build().perform();
			} else {
				System.out.println("Invalid Action");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Frame
	public static void Frame_concept(WebElement element, String option, String value) {
		if (option.equalsIgnoreCase("index")) {
			int parseInt = Integer.parseInt(value);
			driver.switchTo().frame(parseInt);
		} else if (option.equalsIgnoreCase("value")) {
			driver.switchTo().frame(value);
		} else if (option.equalsIgnoreCase("WebElement")) {
			driver.switchTo().frame(element);
		}
	}

	// Select
	public static void Select_index(WebElement element, String option, String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("by Index")) {
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);
		} else if (option.equalsIgnoreCase("by value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("by VisibleText")) {
			s.selectByVisibleText(value);
		} else {
			System.out.println("Invalid");
		}
	}

	// Screenshot
	public static void Screenshot() throws IOException {
		TakesScreenshot s = (TakesScreenshot) driver;
		File source = s.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//screenshot//sample.png");
		FileUtils.copyFile(source, dest);
	}

	// Robot
	public static void Robotic(String option) throws AWTException {
		Robot r = new Robot();
		if (option.equalsIgnoreCase("up")) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		} else if (option.equalsIgnoreCase("down")) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		} else if (option.equalsIgnoreCase("enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
	}
	//locators
	public static void By_id(String object, String value, String value2) {
		if (object.equalsIgnoreCase("click")) {
			driver.findElement(By.id(value)).click();
		} else if (object.equalsIgnoreCase("sendkeys")) {
			driver.findElement(By.id(value)).sendKeys(value2);
		}
	}
	
	public static void By_name(String object, String value, String value2) {
		if (object.equalsIgnoreCase("click")) {
			driver.findElement(By.name(value)).click();
		} else if (object.equalsIgnoreCase("sendkeys")) {
			driver.findElement(By.name(value)).sendKeys(value2);
		}
	}

	public static void By_xpath(String object, String value, String value2) {
		if (object.equalsIgnoreCase("click")) {
			driver.findElement(By.xpath(value)).click();
		} else if (object.equalsIgnoreCase("sendkeys")) {
			driver.findElement(By.xpath(value)).sendKeys(value2);
		}
	}
	// Alert
	public static void Alert_concept(String option, String value) {
		Alert a = driver.switchTo().alert();
		if (option.equalsIgnoreCase("accept")) {
			a.accept();
		} else if (option.equalsIgnoreCase("dismiss")) {
			a.dismiss();
		} else if (option.equalsIgnoreCase("sendkeys")) {
			a.sendKeys(value);
		}
	}

	// multiple
	public static void multiselect(WebElement element) {
		Select s = new Select(element);
		List<WebElement> list = s.getOptions();
		for (WebElement fa : list) {
			System.out.println(fa.getText());
		}
	}

	// scroll
	public static void ScrollFunction(WebElement element, String option) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		if (option.equalsIgnoreCase("scroll")) {
			j.executeScript("arguments[0].scrollIntoView()", element);
		} else if (option.equalsIgnoreCase("click")) {
			j.executeScript("arguments[0].click", element);
		}

	}
	//tab
	public static void newtab(String option) {
		if (option.equalsIgnoreCase("tab")) {
			driver.switchTo().newWindow(WindowType.TAB);	
		}else if (option.equalsIgnoreCase("window")) {
			driver.switchTo().newWindow(WindowType.WINDOW);
		}
		
	}
	//wait
	public static void halt(int s) {
	driver.manage().timeouts().implicitlyWait(s, TimeUnit.SECONDS);

	}
	// Clear
	public static void Clear(WebElement element) {
		element.clear();
	}

	// Sendkeys
	public static void Inputdata(WebElement element, String s) {
		element.sendKeys(s);
	}
	public static WebDriver Close_tab() {
		driver.close();
		return driver;
	}
	public static WebDriver Quit_tab() {
		driver.quit();
		return driver;
	}
}

