package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

	
	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
