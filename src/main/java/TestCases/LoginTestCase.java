package TestCases;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ExtentReport.ExtentReport;
import PageFunctions.LoginFunction;
import helper.ApplicationHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestCase {
	ApplicationHelper helper;
	LoginFunction login;

	WebDriver driver;

	ExtentReport report;
	ExtentTest childTest;
	
	@BeforeTest
	public void launchAllInstances() {
		helper = new ApplicationHelper();

		driver = helper.browserInvocation();

		helper.LaunchURL();

		report = new ExtentReport();
		report.createReportInstance(); //instance

		report.createParentNode("Test case 1"); //one time
	}
	
	
	
	@Test
	public void loginTC() {

		childTest = report._createChildNode("Method Name");

		login = new LoginFunction(driver,childTest);

		login.login(); //Login Method

	}

	@AfterTest
	public void closeInstances() {
		report.FlushExtentReport();
		helper.closeBrowser();
	}
}