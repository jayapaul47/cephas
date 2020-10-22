package corebase.reports;

import corebase.Resources.PropertiesHelper;
import corebase.helper.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static String htmlpassLocation;
	public static String htmlfailLocation;
	public static String htmlreportname;
	public static String reportname;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	public void extentReport() {

		reportname = "report_" + Base.getDateTime() + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + reportname);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "windows");
		extent.setSystemInfo("Browser", PropertiesHelper.getProperties("BrowserName"));

		htmlReporter.config().setDocumentTitle("Automation");
		htmlReporter.config().setReportName("Automation");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void FlushExtentReport() {
		extent.flush();
	}

}
