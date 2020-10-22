package PageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageObjects.SelfcareLoginPage;
import corebase.helper.Base;

public class LoginFunction extends SelfcareLoginPage{
	
	public LoginFunction(WebDriver driver) {
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void login() {
		
		try {
			Base.LaunchURL("https://selfcare.yes.my/myselfcare/doLogin.do");
			
			checkforElement(getName(), "usernamefield");
			
			inputValue(getName(), "0186936180@yes.my", "Username");
			
			checkforElement(getPassword(), "password field");
			
			inputValue(getPassword(), "Praisethelord", "password");
			
			checkforElement(getLogin(), "Login");
			
			ClickOnElement(getLogin(), "LoginBtn");
		} catch (Exception e) {
			
			System.out.println("failed at login method");
		}
	}

}
