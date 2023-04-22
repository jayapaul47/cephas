package PageFunctions;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageObjects.SelfcareLoginPage;
import helper.Base;

public class LoginFunction extends SelfcareLoginPage{
	
	public LoginFunction(WebDriver driver, ExtentTest _test) {
        super(driver, _test);
        PageFactory.initElements(driver, this);
    }
	
	public void login() {
		inputUserName();

		inputPassword();

		clickonLogin();
	}
}