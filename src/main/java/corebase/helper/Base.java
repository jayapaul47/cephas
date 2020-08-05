package corebase.helper;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

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

	public void checkforElement(WebElement element, String elementName) {

		if (element.isDisplayed()) {

			System.out.println("");

		}

	}
}