package dsalgo.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import dsalgo.pageobjects.DSAlgoIntroductionPage;
import dsalgo.pageobjects.LandingPage;
import dsalgo.pageobjects.LoginPage;
import dsalgo.pageobjects.RegisterPage;
import dsalgo.pageobjects.StackPage;
import dsalgo.pageobjects.TreePage;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class StackPageStepDefinitions {

	public LoginPage loginpage;
	TestContextSetup testContSetup ;
	public RegisterPage registerpage;
	public StackPage stackpage;
	public String outputmessage = "Hello, world!";
	public String expTitle;
	public String inputCode;
	public String expOutput;
	public TreePage treepage;
	
	public StackPageStepDefinitions(TestContextSetup testContSetup) {
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();
		this.stackpage = testContSetup.pageObjManager.getStackPage();
		this.treepage = testContSetup.pageObjManager.getTreePage();
	}

	@Given("^User is logged in and landed on Home Page$")
	public void user_logged_in_and_landed_on_home_page() {
		LandingPage landingPage  = testContSetup.pageObjManager.getLandingPage();
		landingPage.getStartedClick();
		DSAlgoIntroductionPage dsalgoIntroduction = testContSetup.pageObjManager.getDSAlgoIntroductionPage();
		dsalgoIntroduction.clickLogin();
		loginpage.enterUsername(stackpage.getCommonConfigs().getUserName());
		loginpage.enterPassword(stackpage.getCommonConfigs().getPassword());
		loginpage.submitLogin();
	}

	@When("User Clicks Get Started below Stack DS")
	public void user_clicks_get_started_below_stack_ds() {
		stackpage.stackGetStartedClick();
	}

	@Then("User should be redirected to Stack Page")
	public void user_should_be_redirected_to_stack_page() {
		String ExpTitle = "Stack";
		Assert.assertEquals(stackpage.getTitleName(), ExpTitle);
		LoggerLoad.info("User Landed on Stack Page");
	}

	@Given("User is on Stack page")
	public void user_is_on_stack_page() {
		LoggerLoad.info("\t user landed on stack page");
	}

	@When("User clicks on {string} under stack page")
	public void user_clicks_on_under_stack_page(String link) 
	{
	    expTitle = link;
	    stackpage.stackConceptsClick(link);
	    
	}
	
	@Then("User should be redirected to the clicked stack link Page")
	public void user_should_be_redirected_to_the_clicked_link_page()
	{
		Assert.assertEquals(stackpage.getTitleName(),expTitle);
	}

	@When("User clicks on stack Try Here Button")
	public void user_clicks_on_try_here_button() {
		stackpage.tryHereClick();
	}

	@Then("User should be redirected to stack Editor's page with Run Button")
	public void user_should_be_redirected_to_editor_s_page_with_run_button() {
		LoggerLoad.info("\t user landed on editor's page with Run button");
		Assert.assertEquals(stackpage.checkRunButton(), true);
	}
	
	@When("User clicks on Run Button entering stack code {string} and {int}")
	public void user_clicks_on_run_button_entering_code_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> userData = 
				reader.getData("src/test/resources/TestData/PythonCode.xlsx", sheetName);
		LoggerLoad.info(userData.toString());

		String heading = userData.get(rowNumber).get("subjectheading");
		LoggerLoad.info("Hearder: "+heading);
	    inputCode = userData.get(rowNumber).get("Input");
		LoggerLoad.info("code enterd : "+inputCode);

		String expOutput = userData.get(rowNumber).get("Output");
		LoggerLoad.info("Expected Output : "+expOutput);
		stackpage.sendCodeToEditor(inputCode);
		stackpage.runButtonClick();
		
	}
	
	@Then("User will be able to see the output on the stack data structure console")
	public void user_should_be_able_to_see_the_output_on_the_stack_data_structure_console() {
		if(inputCode.equals(" ")) {
			Assert.assertEquals(expOutput, treepage.getOutput());
		} else if(inputCode.equalsIgnoreCase("hello world")) {
			LoggerLoad.info("Entered this condition");
			treepage.navigateToAlert();
			Assert.assertEquals(expOutput, stackpage.alertMessage);
			treepage.acceptAlert();
		} else if(inputCode.equals("print('Hello, world!'")) {
			Assert.assertEquals(expOutput, treepage.getOutput()); 
		}
	}
	
}
