package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;
public class Base 
{
	public WebDriver driver;
	Properties properties;

	@BeforeMethod(alwaysRun = true) // alwaysRun = true ensures that this method runs even if there are failures in
									// the test methods
	@Parameters("browser")
	public void browserInitilization(String browser) throws Exception {
		try {
			properties = new Properties();
			FileInputStream fileInputStream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("File Not Found!!");
		}
		if (browser.equalsIgnoreCase("chrome")) // equalIgnoreCaes is not case sensitive
		{
			driver = new ChromeDriver(); // Initialize the ChromeDriver
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(); // Initialize the FirefoxDriver
		} else {
			throw new Exception("Browser not supported");
		}

		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize(); // window maximization
	}

	@AfterMethod(alwaysRun = true)
	public void browserQuitAndClose(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility scrShot = new ScreenShotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit(); // close all window
	}

}