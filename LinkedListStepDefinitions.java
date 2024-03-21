package dsalgo.stepdefinitions;
import org.testng.AssertJUnit;
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
import io.cucumber.java.en.*;
import junit.framework.Assert;
import utilities.ExcelReader;
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
		public String outputMessage = "Hello,World!";

		public LinkedListStepDefinitions(TestContextSetup testContSetup) 
		{
			this.testContSetup = testContSetup;
			this.loginpage = testContSetup.pageObjManager.getLoginPage();
			this.linkedlistpage = testContSetup.pageObjManager.getLinkedListPage();
		}

		@Given("^User logged in and landed on Home Page$")
		public void user_logged_in_and_landed_on_home_page()
		{
			LandingPage landingPage  = testContSetup.pageObjManager.getLandingPage();
			landingPage.getStartedClick();
			DSAlgoIntroductionPage dsalgoIntroduction = testContSetup.pageObjManager.getDSAlgoIntroductionPage();
			dsalgoIntroduction.clickLogin();
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
		System.out.println("User should be redirected to LinkedList Page");
	}

	@Given("User is on the LinkedList Page")
	public void user_is_on_the_linkedlist_page()
	{
		System.out.println("\t user landed on the LinkedList Page");
	}

	@When("User clicks on {string} under LinkedList Page")
	public void user_clicks_on_under_linkedlist_page(String link) 
	{
	    expTitle = link;
	    linkedlistpage.llConceptsClick(link);
	    
	}		
	@Then("User should be redirected to the clicked link Page")
	public void user_should_be_redirected_to_the_clicked_link_page()
	{
				Assert.assertEquals(linkedlistpage.getTitleName(),expTitle);
	}
	@Then("User should be redirected to the Introduction in LinkedList Page")
	public void user_should_be_redirected_to_the_introduction_in_linkedlist_page()
	{
		System.out.println("\t user landed on introduction in LinkedList page");
	}


	@Given("User logged in and land on LinkedList Introduction Page")
	public void user_logged_in_and_land_on_linkedlist_introduction_page()
	{
		System.out.println("\t user is logged in and land on LinkedList Introduction page");
		linkedlistpage.IntroductionClick();
	}
	@Then("User should be redirect to the clicked link Page")
	public void user_should_be_redirect_to_the_clicked_link_page()
	{
				Assert.assertEquals(linkedlistpage.getTitleName(),expTitle);
	}
	
	@Given("User logged in and landed on the Creating LinkedLIst Page")
	public void user_logged_in_and_landed_on_the_creating_linkedlist_page()
	{
		System.out.println("\t user is logged in and landed on Creating LinkedList page");
		linkedlistpage.IntroductionClick();
	}
	
		@Then("User should be redirect to the click link Page")
		public void user_should_be_redirect_to_the_click_link_page()
		{
					Assert.assertEquals(linkedlistpage.getTitleName(),expTitle);
		}
		@Then("User should be redirected to Creating LinkedLIst in LinkedList Page")
		public void user_should_be_redirected_to_creating_linkedlist_in_linkedlist_page()
		{
			System.out.println("\t user should be redirected to Creating LinkedList in LinkedList page");
		}
		@Given("User logged in and land on Types of LinkedList Page")
		public void user_logged_in_and_land_on_types_of_linkedlist_page()
		{
			System.out.println("\t user is logged in and land on Types of LinkedList Page");
			linkedlistpage.IntroductionClick();
		}
	
	
	@Then("User should be redirected to Types of LinkedList in LinkedList Page")
	public void user_should_be_redirected_to_types_of_linkedlist_in_linkedlist_page()
	{
		System.out.println("\t user should be redirected to types of  LinkedList in LinkedList page");
	}
	
	@Given("User logged in and landed on Types of LinkedList Page")
	public void user_logged_in_and_landed_on_types_of_linkedlist_page()
	{
		System.out.println("\t user is logged in and landed on Types of LinkedList Page");
		linkedlistpage.IntroductionClick();
	}
	@Then("User should be redirected to Implement LinkedList in Python in LinkedList Page")
	public void user_should_be_redirected_to_implement_linkedlist_in_python_in_linkedlist_page()
	{
		System.out.println("\t user redirected to implement linkedlist in python in LinkedList Page");
	}
	@Given("User logged in and landed on Implement LinkedList in Python Page")
	public void user_logged_in_and_landed_on_implement_linkedlist_in_python_page()
	{
		System.out.println("\t user is logged in and landed on Implement LinkedList in Python Page");
		linkedlistpage.IntroductionClick();
	}
	@Then("User should be redirected to Traversal in LinkedList Page")
	public void user_should_be_redirected_to_traversal_in_linkedlist_page()
	{
		System.out.println("\t user should be redirected to Traversal in LinkedList Page");
	}
	@Given("User logged in and landed on Insertion Page")
	public void user_logged_in_and_landed_on_Insertion_page()
	{
		System.out.println("\t user is logged in and landed on Insertion Page");
		linkedlistpage.IntroductionClick();
	}
	@Then("User should be redirected to Insertion in LinkedList Page")
	public void user_should_be_redirected_to_insertion_in_linkedlist_page()
	{
		System.out.println("\t user should be redirected to Insertion in LinkedList Page");
	}
	@Given("User logged in and landed on Deletion Page")
	public void user_logged_in_and_landed_on_deletion_page()
	{
		System.out.println("\t user is logged in and landed on Deletion Page");
		linkedlistpage.IntroductionClick();
	}
	@Then("User should be redirected to Deletion in LinkedList Page")
	public void user_should_be_redirected_to_deletion_in_linkedlist_page()
	{
		System.out.println("\t user should be redirected to Deletion in LinkedList Page");
	}
	@When("User clicks on Try Here Button")
	public void user_clicks_on_try_here_button() 
	{
		linkedlistpage.TryHereClick();
	}

	@Then("User should be redirected to Editor's page with Run Button")
	public void user_should_be_redirected_to_editor_s_page_with_run_button()
	{
		System.out.println("\t user landed on editor's page with Run button");
		AssertJUnit.assertEquals(linkedlistpage.checkRunButton(), true);
	}
	
	@Given("User is on LinkedList Python Editor's page")
	public void user_is_on_linkedlist_python_editor_s_page()
	{
		linkedlistpage.IntroductionClick();
		linkedlistpage.TryHereClick();
		System.out.println("\t User is landed on LinkedList Python Editor's page");
	}

	@When("User clicks on Run Button without entering code")
	public void user_clicks_on_run_button_without_entering_code() {
		System.out.println("User clicks on Run button with out giving any code");
		linkedlistpage.RunButtonClick();
	}

	@Then("No error message is displayed")
	public void no_error_message_is_displayed()
	{
		System.out.println("No error message is displayed on screen");
	}

	@When("clicks Run button")
	public void clicks_run_button() {
		linkedlistpage.RunButtonClick();
	}

	@Then("User will be able to see the output on the console")
	public void user_will_be_able_to_see_the_output_on_the_console()
	{
		System.out.println("User should be able to see the output on the console");
		
	}
	
	@When("User clicks on Run Button entering code {string} and {int}")
	public void user_clicks_on_run_button_entering_code_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException
	{
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> userData = 
				reader.getData("src/test/resources/TestData/TestExcel.xlsx", sheetName);
		System.out.println(userData);

		String heading = userData.get(rowNumber).get("subjectheading");
		System.out.println("Header: "+heading);
	    inputCode = userData.get(rowNumber).get("Input");
		System.out.println("code entered : "+inputCode);

		String expOutput = userData.get(rowNumber).get("Output");
		System.out.println("Expected Output : "+expOutput);
		linkedlistpage.sendCodeToEditor(inputCode);
		linkedlistpage.RunButtonClick();
		
	}
}
