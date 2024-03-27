package dsalgo.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import dsalgo.pageobjects.DSAlgoIntroductionPage;
import dsalgo.pageobjects.LandingPage;
import dsalgo.pageobjects.LoginPage;
import dsalgo.pageobjects.RegisterPage;
import dsalgo.pageobjects.TreePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LocatorUtility;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class TreePageStepDefinitions {

	public LoginPage loginpage;
	TestContextSetup testContSetup ;
	public RegisterPage registerpage;
	public TreePage treepage;
	public String outputmessage = "Hello, world!";
	public String expTitle;
	public String expOutput;
	public String inputCode;

	public TreePageStepDefinitions(TestContextSetup testContSetup) {
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();
		this.treepage = testContSetup.pageObjManager.getTreePage();
		
	}

	@Given("^User logged in and landed on Home Page$")
	public void user_logged_in_and_landed_on_home_page() {
		LandingPage landingPage  = testContSetup.pageObjManager.getLandingPage();
		landingPage.getStartedClick();
		DSAlgoIntroductionPage dsalgoIntroduction = testContSetup.pageObjManager.getDSAlgoIntroductionPage();
		dsalgoIntroduction.clickLogin();
		loginpage.enterUsername(treepage.getCommonConfigs().getUserName());
		loginpage.enterPassword(treepage.getCommonConfigs().getPassword());
		loginpage.submitLogin();
	}

	@When("User Clicks Get Started below Tree DS")
	public void user_clicks_get_started_below_tree_ds() {
		treepage.treeGetStartedClick();
	}

	@Then("User should be redirected to Tree Page")
	public void user_should_be_redirected_to_tree_page() {
		String ExpTitle = "Tree";
		Assert.assertEquals(treepage.getTitleName(), ExpTitle);
		LoggerLoad.info("User Landed on Tree Page");
	}

	@Given("User is on Tree page")
	public void user_is_on_tree_page() {
		LoggerLoad.info("\t user landed on tree page");
	}

	@When("User clicks on {string} under tree page")
	public void user_clicks_on_under_tree_page(String link) {
		expTitle = link;
		//LocatorUtility.conceptsClick(link, treepage.getDriver());
		treepage.treeConceptsClick(link);
	}

	@Then("User should be redirected to the clicked link Page")
	public void user_should_be_redirected_to_the_clicked_link_page() {
		Assert.assertEquals(treepage.getTitleName(),expTitle);
	}

	@When("User clicks on Try Here Button")
	public void user_clicks_on_try_here_button() {
		treepage.tryHereClick();
	}

	@Then("User should be redirected to Editor's page with Run Button")
	public void user_should_be_redirected_to_editor_s_page_with_run_button() {
		Assert.assertEquals(treepage.checkRunButton(), true);
	}

	@When("User clicks on Run Button entering code {string} and {int}")
	public void user_clicks_on_run_button_entering_code_and(String sheetName, Integer rowNumber) 
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
		Thread.sleep(700);
		treepage.sendCodeToEditor(inputCode);
		treepage.runButtonClick();

	}

	@Then("User should be able to see the output on the console")
	public void user_should_be_able_to_see_the_output_on_the_console() {
		if(inputCode.equals(" ")) {
			Assert.assertEquals(expOutput, treepage.getOutput());
		} else if(inputCode.equalsIgnoreCase("hello world")) {
			LoggerLoad.info("Entered this condition");
			treepage.navigateToAlert();
			Assert.assertEquals(expOutput, treepage.alertMessage);
			treepage.acceptAlert();
		} else if(inputCode.equals("print('Hello, world!'")) {
			Assert.assertEquals(expOutput, treepage.getOutput()); 
		}
	}
}
