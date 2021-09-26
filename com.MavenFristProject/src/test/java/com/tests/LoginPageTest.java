package com.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.UserPage;

public class LoginPageTest {
	static WebDriver driver;
	LoginPage lp;
	static DashboardPage dp;
	private Logger log= Logger.getLogger(LoginPageTest.class);	
	@BeforeSuite
	public void setup() {
		log.warn("user should use valid driver file");
		log.info("opening a new chrome browser");
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		lp= new LoginPage(driver);
	}
	@Test
	public void test02() {
		lp.inValidLogin("mangesh","asdfgh");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	@Test
	public void test03() {
		dp=lp.validLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
