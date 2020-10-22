package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import corebase.helper.Base;

public class SelfcareLoginPage extends Base {
	
	public SelfcareLoginPage(WebDriver driver) {
//        super(driver);
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//*[@id='name']")
	private WebElement name;
	
	@FindBy(xpath = "//*[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "(//*[@type='submit'])[3]")
	private WebElement login;

	public WebElement getName() {
		return waitForExpectedCondition(name);
	}

	public WebElement getPassword() {
		return waitForExpectedCondition(password);
	}

	public WebElement getLogin() {
		return waitForExpectedCondition(login);
	}
	
}
