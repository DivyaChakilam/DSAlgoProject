package dsalgo.stepdefinitions;

import org.testng.Assert;

import config.CommonLocators;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import dsalgo.pageobjects.DSAlgoIntroductionPage;
import dsalgo.pageobjects.DataStructuresPage;
import dsalgo.pageobjects.LandingPage;

import dsalgo.pageobjects.LoginPage;
import dsalgo.pageobjects.RegisterPage;
import dsalgo.pageobjects.TreePage;
import io.cucumber.java.en.*;

import utilities.ExcelReader;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class DataStructureStepDefinitions {
	public LoginPage loginpage;
	TestContextSetup testContSetup;
	public RegisterPage registerpage;
	public DataStructuresPage dataStructurespage;
	//public TreePage treepage;
	public String inputCode;
	public String expOutput;
	public String expTitle="Time Complexity";
	public String outputMessage = "Hello,World!";

	public DataStructureStepDefinitions(TestContextSetup testContSetup) {
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();
		//this.treepage = testContSetup.pageObjManager.getTreePage();
		this.dataStructurespage = testContSetup.pageObjManager.getDataStructuresPage();
	}

	@Given("User logged in and landed on the HomePage")
	public void user_logged_in_and_landed_on_the_homepage() {
		/*
		 * LandingPage landingPage = testContSetup.pageObjManager.getLandingPage();
		 * landingPage.getStartedClick(); DSAlgoIntroductionPage dsalgoIntroduction =
		 * testContSetup.pageObjManager.getDSAlgoIntroductionPage();
		 * dsalgoIntroduction.clickLogin();
		 */
		loginpage.enterUsername(dataStructurespage.getCommonConfigs().getUserName());
		loginpage.enterPassword(dataStructurespage.getCommonConfigs().getPassword());
		loginpage.submitLogin();
	}

	@When("User Clicks on the Get Started below DS Page")
	public void user_clicks_get_started_below_DS_page() {
		dataStructurespage.GetStartedClick();
	}

	@Then("User should be on the DS Introduction Page")
	public void user_should_be_on_the_DS_introduction_page() {
		String ExpTitle = "Data Structures-Introduction";
		Assert.assertEquals(dataStructurespage.getTitleName(), ExpTitle);
		LoggerLoad.info("User Landed on Data Structures-Introduction Page");
	}

	@Given("User is on DS Page")
	public void user_is_on_DS_page() {
		LoggerLoad.info("\t user landed on Data Structures-Introduction page");
	}

//	@When("User clicks on {string} under DS page")
//	public void user_clicks_on_ds_page(String link) {
//		expTitle = link;
//		dataStructurespage.dsConceptsClick(link);
//
//	}

	
	@When("User clicks on Time Complexity in DS Page")
	public void user_clicks_on_time_complexity_in_ds_page() {
		dataStructurespage.TimeComplexityClick();
		
	}
	@Then("User should be redirected to clicked link Page")
	public void user_should_be_redirected_to_clicked_link_page() {
		Assert.assertEquals(dataStructurespage.getTitleName(), expTitle);
		System.out.println(dataStructurespage.getTitleName());
	}

	@When("User clicks on the Try Here Button")
	public void user_clicks_on_the_try_here_button() {
		CommonLocators.tryHereClick(this.dataStructurespage.driver);
		
	}

	@Then("User should be redirected to DS Editor's page with Run Button")
	public void user_should_be_redirected_to_ds_editor_s_page_with_run_button() throws InterruptedException {
		Assert.assertEquals(dataStructurespage.checkRunButton(), true);
		System.out.println("Landed on editor's page ");
		
	}

	@When("User clicks on the Run after entering DS code {string} and {int}")
	public void user_clicks_on_the_run_after_entering_code_and(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> userData = 
				reader.getData("src/test/resources/TestData/PythonCode.xlsx", sheetName);
		LoggerLoad.info(userData.toString());
		String heading = userData.get(rowNumber).get("subjectheading");
		LoggerLoad.info("Hearder: "+heading);
		inputCode = userData.get(rowNumber).get("Input");
		LoggerLoad.info("code enterd : "+inputCode);
		expOutput = userData.get(rowNumber).get("Output");
		LoggerLoad.info("Expected Output : "+expOutput);
		
		CommonLocators.sendCodeToEditor(inputCode, this.dataStructurespage.driver);
		//Thread.sleep(500);
		CommonLocators.runButtonClick(this.dataStructurespage.driver);

	}

	@Then("User will see output on console")
	public void user_will_see_output_on_console() {
		if (inputCode.equals(" ")) {
			Assert.assertEquals(expOutput, dataStructurespage.getOutput());
		} else if (inputCode.equalsIgnoreCase("hello world")) {
			LoggerLoad.info("Entered this condition");
			dataStructurespage.navigateToAlert();
			Assert.assertEquals(expOutput, dataStructurespage.alertMessage);
			dataStructurespage.acceptAlert();
		} else if (inputCode.equals("print('Hello, world!'")) {
			Assert.assertEquals(expOutput, dataStructurespage.getOutput());
		}
	}
}
