package br.com.framework.core.configuration;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ExemploTestRules {
	
	private static WebDriver driver;
	private static ExtentHtmlReporter extentHtmlReporter;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	
	/**
	 * Get WebDriver
	 */
	public static WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * Get ExtentTest
	 */
	public static ExtentTest getExtentTest() {
		return extentTest;
	}
	
	@Before // Set Up
	public void beforeScenario(Scenario scenario) {
		
		try {
			if(extentReports == null) {
				extentReports = new ExtentReports();
				extentHtmlReporter = new ExtentHtmlReporter("target/htmlReporter.html");
				extentReports.attachReporter(extentHtmlReporter);
			}
			extentTest = extentReports.createTest(scenario.getName());
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to("http://www.inmrobo.tk/");
		} catch (Exception e) {
			Assert.fail();
		}
		
	}
	
	@After // Tear Down
	public void afterScenario(Scenario scenario) {
		
		try {
			
			if (scenario.isFailed()) {
				extentTest.log(Status.FAIL, "Cenário \"" + scenario.getName() + "\" executado falhas.");
				extentReports.flush();
			} else {
				extentTest.log(Status.PASS, "Cenário \"" + scenario.getName() + "\" executado com sucesso.");
				extentReports.flush();
			}
			
			if (driver != null) {
				driver.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
}
