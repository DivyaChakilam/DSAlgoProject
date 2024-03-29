package dsalgo.stepdefinitions;
import org.testng.Assert;
import org.testng.AssertJUnit;

import config.CommonLocators;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.chrome.ChromeDriver;

import dsalgo.pageobjects.DSAlgoIntroductionPage;
import dsalgo.pageobjects.DataStructuresPage;
import dsalgo.pageobjects.LandingPage;
import dsalgo.pageobjects.LinkedListPage;
import dsalgo.pageobjects.LoginPage;
import dsalgo.pageobjects.RegisterPage;
import dsalgo.pageobjects.TreePage;
import io.cucumber.java.en.*;
//import junit.framework.Assert;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class LinkedListStepDefinitions
{
		public LoginPage loginpage;
		TestContextSetup testContSetup ;
		public RegisterPage registerpage;
		public DataStructuresPage dataStructurespage;
		public LinkedListPage linkedlistpage;
		public String inputCode;
		public String expTitle;
		public String expOutput;
		//public TreePage treepage;
		public String outputMessage = "Hello,World!";

		public LinkedListStepDefinitions(TestContextSetup testContSetup) 
		{
			this.testContSetup = testContSetup;
			this.loginpage = testContSetup.pageObjManager.getLoginPage();
			this.linkedlistpage = testContSetup.pageObjManager.getLinkedListPage();
			//this.treepage = testContSetup.pageObjManager.getTreePage();
		}

		@Given("^User has logged in and landed on Home Page$")
		public void user_logged_in_and_landed_on_home_page()
		{
			/*
			 * LandingPage landingPage = testContSetup.pageObjManager.getLandingPage();
			 * landingPage.getStartedClick(); DSAlgoIntroductionPage dsalgoIntroduction =
			 * testContSetup.pageObjManager.getDSAlgoIntroductionPage();
			 * dsalgoIntroduction.clickLogin();
			 */
			loginpage.enterUsername(linkedlistpage.getCommonConfigs().getUserName());
			loginpage.enterPassword(linkedlistpage.getCommonConfigs().getPassword());
			loginpage.submitLogin();
		}
	@When("User Clicks Get Started below LinkedList Page")
	public void user_clicks_get_started_below_linkedlist_page() 
	{
		linkedlistpage.GetStartedClick();
    }

	@Then("User should be redirected to LinkedList Page")
	public void user_should_be_redirected_to_linkedlist_page() {
		String ExpTitle = "Linked List";
		Assert.assertEquals(linkedlistpage.getTitleName(), ExpTitle);
		LoggerLoad.info("User should be redirected to LinkedList Page");
	}

	@Given("User is on the LinkedList Page")
	public void user_is_on_the_linkedlist_page()
	{
		LoggerLoad.info("\t user landed on the LinkedList Page");
	}

	@When("User clicks on {string} under LinkedList Page")
	public void user_clicks_on_under_linkedlist_page(String link) 
	{
	    expTitle = link;
	    linkedlistpage.llConceptsClick(link);
	    
	}	
	
	@Then("User should be redirected to the clicked Linked List link Page")
	public void user_should_be_redirected_to_the_clicked_linked_list_link_page() {
		
		Assert.assertEquals(linkedlistpage.getTitleName(),expTitle);
	}

	
	@When("User clicks on Linked List Try Here Button")
	public void user_clicks_on_try_here_button() 
	{
		linkedlistpage.TryHereClick();
	}

	@Then("User should be redirected to Linked List Editor's page with Run Button")
	public void user_should_be_redirected_to_editor_s_page_with_run_button()
	{
		LoggerLoad.info("\t user landed on editor's page with Run button");
		Assert.assertEquals(linkedlistpage.checkRunButton(),true);
	}
	
	@When("User clicks on Run Button entering Linked List code {string} and {int}")
	public void user_clicks_on_run_button_entering_code_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException
	{
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
	//	Thread.sleep(500);
		CommonLocators.sendCodeToEditor(inputCode, this.linkedlistpage.driver);
		CommonLocators.runButtonClick(this.linkedlistpage.driver);
		Thread.sleep(500);
		
	}
	
	@Then("User will be able to see the output on the Linked List console")
	public void user_should_be_able_to_see_the_output_on_the_stack_data_structure_console() {
		if(inputCode.equals(" ")) {
			Assert.assertEquals(expOutput, CommonLocators.getOutput(this.linkedlistpage.driver));
		} else if(inputCode.equalsIgnoreCase("hello world")) {
			LoggerLoad.info("Entered this condition");
			CommonLocators.navigateToAlert(this.linkedlistpage.driver);
			Assert.assertEquals(expOutput, CommonLocators.alertMessage);
			CommonLocators.acceptAlert(this.linkedlistpage.driver);
		} else if(inputCode.equals("print('Hello, world!'")) {
			Assert.assertEquals(expOutput, CommonLocators.getOutput(this.linkedlistpage.driver)); 
		}
	}
}