package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Resources.PropertiesHelper;

public class ApplicationHelper {

	WebDriver driver;

	public WebDriver browserInvocation() {
		String Browser = PropertiesHelper.getProperties("BrowserName");

		try {
			if (Browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("start-maximized");
				options.addArguments("disable-popup-blocking");
				options.addArguments("disable-default-apps");
				options.addArguments("test-type=browser");
				options.addArguments("disable-infobars");
				options.addArguments("--disable-notifications");

				System.setProperty("webdriver.chrome.driver", PropertiesHelper.getProperties("ChromeDriverPath"));

				driver = new ChromeDriver(options);

				driver.manage().window().maximize();

				driver.manage().deleteAllCookies();
			} else if (Browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", PropertiesHelper.getProperties("firefoxdriverpath"));

				driver = new FirefoxDriver();

				driver.manage().window().maximize();
				
				driver.manage().deleteAllCookies();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return driver;
 	}

	public void LaunchURL() {
		driver.navigate().to(PropertiesHelper.getProperties("Applicationurl"));
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
