package dsalgo.stepdefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utilities.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	@After
	public void AfterScenario() throws Throwable
	{
		testContextSetup.base.WebDriverManager().quit();
	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws Throwable
	{
		WebDriver driver =testContextSetup.base.WebDriverManager();
		if(scenario.isFailed())
		{
			//screenshot
			File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}

	}

}
