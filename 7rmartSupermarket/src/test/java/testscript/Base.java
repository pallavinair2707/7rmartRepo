package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	public Properties properties;
	public FileInputStream fileinput;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void browserInitialization(String browser) throws Exception {
		try {
			properties = new Properties();
			fileinput = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinput);
		} catch (Exception e) {
			System.out.println(e);
		}

		if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			// To launch the browser. Here WebDriver is an Interface provided by selenium
			// and ChromeDriver is a class provided by selenium. Each browser has its own
			// drivers. For eg, if you want to open Edge browser give EdgeDriver instead of
			// ChromeDriver.
			// driver is the reference variable.
		} else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();

		} else {
			throw new Exception("Invalid");
		}

		// driver = new EdgeDriver();
		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(properties.getProperty("url"));
		// Syntax for implicit wait is
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));

	}

	@AfterMethod(alwaysRun = true)

	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility scrShot = new ScreenshotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit(); // Closes all browser windows or tabs
		// driver.close(); //closes only the current browser window or tab
	}
}