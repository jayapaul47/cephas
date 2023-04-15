package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFunctions.LoginFunction;
import helper.ApplicationHelper;

public class LoginTestCase extends LoginFunction {
	ApplicationHelper helper;
	LoginFunction login;
	

	public LoginTestCase(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@BeforeTest
	
	public void browser() {
		helper.browserInvocation();
		
		
	}
	
	
	
	@Test
	public void loginTC() {
		
		login.login();

	}

}
