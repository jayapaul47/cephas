package PageObjects;

import Resources.PropertiesHelper;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelfcareLoginPage extends Base {

	WebDriver driver;
	WebDriverWait wait;

	ExtentTest test;
	
	public SelfcareLoginPage(WebDriver _driver, ExtentTest _test) {
		super(_driver, _test);
		this.driver = _driver;
		this.test = _test;
		wait = new WebDriverWait(driver, Long.parseLong(PropertiesHelper.getProperties("WebDriverTimeout")));
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//*[@id='name']")
	private WebElement name;
	
	@FindBy(xpath = "//*[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "(//*[@type='submit'])[3]")
	private WebElement login;

	public void inputUserName(){
		wait.until(ExpectedConditions.visibilityOf(name));

		inputValue(name, "0186936180@yes.my","Username");
	}

	public void inputPassword(){
		wait.until(ExpectedConditions.visibilityOf(password));

		inputValue(password, "Praisethelord","Username");
	}

	public void clickonLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(login));

		ClickOnElement(login, "Login");
	}
}
