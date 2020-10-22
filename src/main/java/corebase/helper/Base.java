package corebase.helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Base {

	ExtentTest test;
	static WebDriver driver;
	public static String addScreenshot;
	WebDriverWait wait;

	public Base() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 90);

	}

	public static String addScreenshot(String elementName, String TestCaseResult) {

		String reportName = "report_" + getDateTime();

		String folderName = System.getProperty("user.dir") + reportName;

		File screenshotfolder = new File(folderName);

		File Imagefolder = new File(screenshotfolder + "\\" + TestCaseResult + "\\" + getDateTime());

		String fileName = elementName + "_" + getDateTime();

		try {
			if (!screenshotfolder.exists()) {
				screenshotfolder.mkdir();

				if (!Imagefolder.exists()) {
					Imagefolder.mkdir();

					File fileObject = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

					FileUtils.copyFile(fileObject, new File(Imagefolder + "\\" + fileName + ".png"));

				} else {
					File fileObject = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

					FileUtils.copyFile(fileObject, new File(Imagefolder + "\\" + fileName + ".png"));
				}
				addScreenshot = Imagefolder + "\\" + fileName + ".png";
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return addScreenshot;
	}

	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_H_mm_ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public void ScreenCapture(ExtentTest test, String elementName, String ElementStatus) {

		try {

			if (ElementStatus.toLowerCase().equalsIgnoreCase("pass")) {

				test.log(Status.PASS,
						"Snapshot below: " + test.addScreenCaptureFromPath(addScreenshot(elementName, "Pass")));

			} else if (ElementStatus.toLowerCase().equalsIgnoreCase("fail")) {

				test.log(Status.FAIL,
						"Snapshot below: " + test.addScreenCaptureFromPath(addScreenshot(elementName, "Fail")));

			}

		} catch (Exception io) {

		}

	}
	
	public WebElement waitForExpectedCondition(WebElement element)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception ex)
		{
			try 
			{
//				throw new Exception("Failed to find the element : " +ElementName);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return element;
	}

	public boolean checkforElement(WebElement element, String elementName) {

		boolean ElementDisplayed = false;

		try {
			if (element.isDisplayed() && element.isEnabled()) {
				ElementDisplayed = true;

				System.out.println(element + "is displayed");

				test.log(Status.PASS, "Able to find the " + elementName + " in the Page");

				ScreenCapture(test, elementName, "Pass");
			}
		} catch (ElementClickInterceptedException e) {
			ElementDisplayed = false;

			test.log(Status.FAIL, "Failed to find the " + elementName + " in the Page");

			ScreenCapture(test, elementName, "Fail");

			System.err.println("Error verifying the element!!");
		}
		return ElementDisplayed;
	}

	public void inputValue(WebElement element, String value, String elementName) {

		try {
			if (element.isDisplayed() && element.isEnabled()) {

				element.sendKeys(value);

				System.out.println(value + "entered sucessfully");

				test.log(Status.PASS, "Successfully entered " + value + " in the Page");

				ScreenCapture(test, elementName, "Pass");
			}
		} catch (Exception e) {

			test.log(Status.FAIL, "Failed to enter " + value + " in the Page");

			ScreenCapture(test, value, "Fail");

			System.err.println("Error verifying and enterving the Value");
		}
	}

	public void ClickOnElement(WebElement element, String elementName) {

		try {
			if (element.isDisplayed() && element.isEnabled()) {

				element.click();

				System.out.println(element + "Element clicked successfully");

				test.log(Status.PASS, "Successfully entered " + element + " in the Page");

				ScreenCapture(test, elementName, "Pass");
			}
		} catch (Exception e) {

			test.log(Status.FAIL, "Failed to enter " + element + " in the Page");

			ScreenCapture(test, elementName, "Fail");

			System.err.println("Error clicking the Value");
		}
	}
	
	public static void LaunchURL(String URL) {
		
		try {
			driver.navigate().to(URL);
			
			System.out.println(URL + "URL successfully Launched");

		} catch (Exception e) {
			
			System.err.println("Error clicking the Value");
		}
	}

}
