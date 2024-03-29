package dsalgo.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import config.CommonLocators;
import dsalgo.pageobjects.GraphPage;
import dsalgo.pageobjects.LoginPage;
import dsalgo.pageobjects.RegisterPage;
import dsalgo.pageobjects.TreePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class GraphPageStepDefinitions {
	
	public LoginPage loginpage;
	TestContextSetup testContSetup ;
	public RegisterPage registerpage;
	//public TreePage treepage;
	public GraphPage graphPage;
	public String outputmessage = "Hello, world!";
	public String expTitle;
	public String expOutput;
	public String inputCode;

	public GraphPageStepDefinitions(TestContextSetup testContSetup) {
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();
		//this.treepage = testContSetup.pageObjManager.getTreePage();
		this.graphPage = testContSetup.pageObjManager.getGraphPage();
	}
	
	
	@When("User Clicks Get Started below Graph DS")
	public void user_clicks_get_started_below_graph_ds() {
		graphPage.graphGetStartedClick();
	}

	@Then("User should be redirected to Graph Page")
	public void user_should_be_redirected_to_graph_page() {
		String ExpTitle = "Graph";
		Assert.assertEquals(CommonLocators.getTitleName(this.graphPage.driver), ExpTitle);
		LoggerLoad.info("User Landed on Grpah Page");
	}

	@Given("User is on Graph page")
	public void user_is_on_graph_page() {
		LoggerLoad.info("\t user landed on graph page");
	}

	@When("User clicks on {string} under Grpah page")
	public void user_clicks_on_under_grpah_page(String link) {
		expTitle = link;
		graphPage.graphConceptsClick(link);
	}
	
	@Then("User should be redirected to the clicked Graph link Page")
	public void user_should_be_redirected_to_the_clicked_graph_link_page() {
		Assert.assertEquals(CommonLocators.getTitleName(this.graphPage.driver),expTitle);

	}

	@When("User clicks on graph Try Here Button")
	public void user_clicks_on_graph_try_here_button() {
		CommonLocators.tryHereClick(this.graphPage.driver);

	}

	@Then("User should be redirected to graph Editor's page with Run Button")
	public void user_should_be_redirected_to_graph_editor_s_page_with_run_button() {
		Assert.assertEquals(CommonLocators.checkRunButton(this.graphPage.driver), true);

	}

	@When("User clicks on Run Button for graph entering code {string} and {int}")
	public void user_clicks_on_run_button_for_graph_entering_code_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
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
		CommonLocators.sendCodeToEditor(inputCode, this.graphPage.driver);
		CommonLocators.runButtonClick(this.graphPage.driver);
	}

	@Then("User should be able to see the output on the graph console")
	public void user_should_be_able_to_see_the_output_on_the_graph_console() {
		if(inputCode.equals(" ")) {
			Assert.assertEquals(expOutput, CommonLocators.getOutput(this.graphPage.driver));
		} else if(inputCode.equalsIgnoreCase("hello world")) {
			LoggerLoad.info("Entered this condition");
			CommonLocators.navigateToAlert(this.graphPage.driver);
			Assert.assertEquals(expOutput, CommonLocators.alertMessage);
			CommonLocators.acceptAlert(this.graphPage.driver);
		} else if(inputCode.equals("print('Hello, world!'")) {
			Assert.assertEquals(expOutput, CommonLocators.getOutput(this.graphPage.driver)); 
		}
	}

}
