package com.waitEx;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class WaitEx {
	WebDriver driver;
	Action a;
	Actions act;
	
	public void waitForElement(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	@Test
	public void test01() {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//timeOut
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//noSuchElement
				
		WebElement email= driver.findElement(By.id("email"));
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(email));
		
		WebElement password= driver.findElement(By.id("password"));
		wait.until(ExpectedConditions.visibilityOf(password));
		
		
		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).
				withTimeout(30, TimeUnit.SECONDS).
				pollingEvery(3,TimeUnit.SECONDS).
				ignoring(NoSuchElementException.class);
		
		w.until(ExpectedConditions.visibilityOf(password));
		
		driver.navigate().to("http://javabykiran.com/playground/");
		act = new Actions(driver);
		
		WebElement link = driver.findElement(By.linkText("GET Single User"));
		
		act.moveToElement(link).perform();
		
	}
}
