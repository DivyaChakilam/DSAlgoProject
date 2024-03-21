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
	public class DataStructuresStepDefinitions 
	{
			public LoginPage loginpage;
			TestContextSetup testContSetup ;
			public RegisterPage registerpage;
			public DataStructuresPage dataStructurespage;
			public LinkedListPage linkedlistpage;
			public String inputCode;
			public String expTitle;
			public String outputMessage = "Hello,World!";

			public DataStructuresStepDefinitions(TestContextSetup testContSetup) 
			{
				this.testContSetup = testContSetup;
				this.loginpage = testContSetup.pageObjManager.getLoginPage();
				this.linkedlistpage = testContSetup.pageObjManager.getLinkedListPage();
				this.dataStructurespage = testContSetup.pageObjManager.getDataStructuresPage();
			}

			/*@Given("^User logged in and landed on Home Page$")
			public void user_logged_in_and_landed_on_home_page()
			{
				LandingPage landingPage  = testContSetup.pageObjManager.getLandingPage();
				landingPage.getStartedClick();
				DSAlgoIntroductionPage dsalgoIntroduction = testContSetup.pageObjManager.getDSAlgoIntroductionPage();
				dsalgoIntroduction.clickLogin();
				loginpage.enterUsername(dataStructurespage.getCommonConfigs().getUserName());
				loginpage.enterPassword(dataStructurespage.getCommonConfigs().getPassword());
				loginpage.submitLogin();
			}*/
		@When("User Clicks on the Get Started below DS Page")
		public void user_clicks_get_started_below_DS_page() 
		{
			dataStructurespage.GetStartedClick();
	    }

		@Then("User should be on the DS Introduction Page")
		public void user_should_be_on_the_DS_introduction_page()
		{
			System.out.println("User should be on the DataStructure Introduction Page");
		}

		@Given("User is on DS Page")
		public void user_is_on_DS_page()
		{
			System.out.println("\t user landed on the DataStructure Page");
		}

		@When("User clicks on {string} under DS Page")
		public void user_clicks_on_under_DS_page(String link) 
		{
		    expTitle = link;
		    dataStructurespage.dsConceptsClick(link);
		    
		}		
		@Then("User should be redirected to clicked link Page")
		public void user_should_be_redirected_to_clicked_link_page()
		{
					Assert.assertEquals(dataStructurespage.getTitleName(),expTitle);
		}
		@Then("User should be redirected to the Introduction in DS Page")
		public void user_should_be_redirected_to_the_introduction_in_DS_page()
		{
			System.out.println("\t user landed on introduction in DataStructures page");
		}


		/*@Given("User logged in and land on DS Introduction Page")
		public void user_logged_in_and_land_on_DS_introduction_page()
		{
			System.out.println("\t user is logged in and land on DataStructure Introduction page");
			dataStructurespage.GetStartedClick();
		}
		@Then("User should be redirect to the clicked link Page")
		public void user_should_be_redirect_to_the_clicked_link_page()
		{
					Assert.assertEquals(dataStructurespage.getTitleName(),expTitle);
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
		}*/
		@When("User clicks on the Try Here Button")
		public void user_clicks_on_the_try_here_button() 
		{
			linkedlistpage.TryHereClick();
		}

		@Then("User should be redirected to the Editor's page with Run Button")
		public void user_should_be_redirected_to_the_editor_s_page_with_run_button()
		{
			System.out.println("\t user landed on editor's page with Run button");
			AssertJUnit.assertEquals(linkedlistpage.checkRunButton(), true);
		}
		
		/*@Given("User is on DataStructures Python Editor's page")
		public void user_is_on_datastructures_python_editor_s_page()
		{
			dataStructurespage.GetStartedClick();
			dataStructurespage.TryHereClick();
			System.out.println("\t User is landed on DataStructures Python Editor's page");
		}*/

		@When("User clicks on the Run Button without entering code")
		public void user_clicks_on_the_run_button_without_entering_code() {
			System.out.println("User clicks on Run button with out giving any code");
			linkedlistpage.RunButtonClick();
		}

		@Then("No error message will be displayed")
		public void no_error_message_will_be_displayed()
		{
			System.out.println("No error message is displayed on screen");
		}

		@When("clicks the Run button")
		public void clicks_the_run_button() {
			linkedlistpage.RunButtonClick();
		}

		@Then("User will be able to see the output on console")
		public void user_will_be_able_to_see_the_output_on_console()
		{
			System.out.println("User should be able to see the output on the console");
			
		}
		
		@When("User clicks on the Run Button entering code {string} and {int}")
		public void user_clicks_on_the_run_button_entering_code_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException
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

	
