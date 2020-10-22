package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageFunctions.LoginFunction;

public class LoginTestCase extends LoginFunction {
	
	public LoginTestCase(WebDriver driver) {
		super(driver);
        PageFactory.initElements(driver, this);
    }
	
	public void loginTC() {
		
		
	}

}
