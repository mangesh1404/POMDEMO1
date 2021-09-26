package com.tests;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.UserPage;



public class DashboardPageTest {
	WebDriver driver;
	DashboardPage dp;
	static UserPage up;
	private Logger log= Logger.getLogger(DashboardPageTest.class);
	
	@Test
	public void test04() {
		ArrayList<String> expectedCourses =new ArrayList<String>();
		expectedCourses.add("Selenium");
		expectedCourses.add("Java / J2EE");
		expectedCourses.add("Python");
		expectedCourses.add("Php");
		Assert.assertEquals(LoginPageTest.dp.verifyCourses(), expectedCourses);
		
	}
	
	@Test
	public void test05() {
		up=LoginPageTest.dp.clickUsersLink();
		Assert.assertEquals(LoginPageTest.driver.getTitle(), "JavaByKiran | User1");
	}
}
