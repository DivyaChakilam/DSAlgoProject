package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import config.ConfigLoader;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", 
					glue = {"dsalgo.stepdefinitions"},
					tags = "@loginscenarios",
					plugin = {"pretty", "html:target/cucumber-Reports.html" , "json:target/cucumber.json",
							"junit:target/Cucumber.xml",
							"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"rerun:target/failed_scenarios.txt"},
					monochrome = true,
					publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {


	@Override
	@DataProvider(parallel = true) 
	public Object[][] scenarios() { return
			super.scenarios(); }

	@BeforeTest
	@Parameters({"browser"})
	public void defineBrowser(String browser) throws Throwable {
		ConfigLoader.setBrowserType(browser);
	}
}
