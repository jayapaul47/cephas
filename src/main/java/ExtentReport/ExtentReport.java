package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Resources.PropertiesHelper;
import helper.Base;

public class ExtentReport {

	String reportname; //this is used to store the report name

	ExtentHtmlReporter htmlReporter; //this is used to save the html file and add an congig properties
	ExtentReports extent; // this is used to implement the log to generate html file

	public static ExtentTest _childtest;

	public void createReportInstance() { //this will invoke plain html report file

		reportname = "report_" + Base.getDateTime() + ".html";

		String path = System.getProperty("user.dir")+ "//src//main//java//ExtentReport//" + reportname;
		htmlReporter = new ExtentHtmlReporter(path); //path to store the report file which is a html file

		extent = new ExtentReports(); //this is an object to invoke extent report class to use the in build methods to create an html file

		extent.attachReporter(htmlReporter); //this is used to attach the html path which is an html reporter variable to extent report
		extent.setSystemInfo("OS", "windows"); //this is an config to store the system data

		htmlReporter.config().setDocumentTitle("Automation"); // to give document title
		htmlReporter.config().setReportName("Automation"); // to set reprot name
		htmlReporter.config().setTheme(Theme.STANDARD); // to set the html file theme
	}

	public void createParentNode(String _scenarioName) //this will attach the parent module
	{
		_childtest = extent.createTest(_scenarioName);
	}

	// Creating the parent node for the extent test report
	public ExtentTest _createChildNode(String _childTestName) //this will attach the child module
	{
		return _childtest.createNode(_childTestName);
	}

	public void FlushExtentReport() { //this will flush the report to make it organised
		extent.flush(); //
	}

}
