package dsalgo.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.junit.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import dsalgo.pageobjects.ArraysPage;
import dsalgo.pageobjects.DSAlgoIntroductionPage;
import dsalgo.pageobjects.LandingPage;
import dsalgo.pageobjects.LoginPage;
import dsalgo.pageobjects.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class ArrayPageStepDefinitions {

	public LoginPage loginpage;
	TestContextSetup testContSetup ;
	public RegisterPage registerpage;
	public ArraysPage arraypage;
	public String expTitle;
	public String inputCode;
	public String expoutput;
	
	public ArrayPageStepDefinitions(TestContextSetup testContSetup) {
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();
		this.arraypage = testContSetup.pageObjManager.getArraysPage();
	}

	@Given("User logged in and is on on DSHome Page")
	public void user_logged_in_and_is_on_on_ds_home_page() {
		LandingPage landingPage  = testContSetup.pageObjManager.getLandingPage();
		landingPage.getStartedClick();
		DSAlgoIntroductionPage dsalgoIntroduction = testContSetup.pageObjManager.getDSAlgoIntroductionPage();
		dsalgoIntroduction.clickLogin();
		loginpage.enterUsername(arraypage.getCommonConfigs().getUserName());
		loginpage.enterPassword(arraypage.getCommonConfigs().getPassword());
		loginpage.submitLogin();
	}

	@When("User Clicks Get Started below ArrayDS")
	public void user_clicks_get_started_below_array_ds() {
		arraypage.arrayGetStartedClick();
	}

	@Then("User should be redirected to Array Page")
	public void user_should_be_redirected_to_array_page() {
			System.out.println("redirected to Array page");
			String ExpTitle = "Array";
			Assert.assertEquals(arraypage.getTitleName(), ExpTitle);
			LoggerLoad.info("User Landed on Array Page");
	}

	@Given("User is on Array page")
	public void user_is_on_array_page() {
		System.out.println("Landed on Array Page");
		LoggerLoad.info("\t user landed on Array page");
	}

	@When("User clicks on {string} Link")
	public void user_clicks_on_link(String link) {
		  expTitle = link;
		  arraypage.arrayTopicsClick(link);
	}

	@Then("User should be redirected to clicked Page")
	public void user_should_be_redirected_to_clicked_page() {
		 Assert.assertEquals(arraypage.getTitleName(),expTitle);

	}
	@When("User clicks on TryHere button")
	public void user_clicks_on_try_here_button() {
		 arraypage.tryHereClick();
	}
	@Then("User should be redirected to Editor's Page with Run button")
	public void user_should_be_redirected_to_editor_s_page_with_run_button() {
		 Assert.assertEquals(arraypage.checkRunButton(), true);

	}

@When("User clicks on Run Button after entering code {string} and {int}")
public void User_clicks_on_Run_Button_after_entering_code_(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
	ExcelReader reader = new ExcelReader();
	List<Map<String,String>> userData = 
			reader.getData("src/test/resources/TestData/PythonCodeA.xlsx", sheetName);
	System.out.println(userData);
    
	String heading = userData.get(rowNumber).get("subjectheading");
	System.out.println("Hearder: "+heading);
    inputCode = userData.get(rowNumber).get("Input ");
	System.out.println("code enterd : "+inputCode);

	expoutput = userData.get(rowNumber).get("Output");
	System.out.println("Expected Output : "+expoutput);
	arraypage.sendCodeToEditor(inputCode);
	
	arraypage.runButtonClick();
	Thread.sleep(1500);

}
	
	@Then("User should be able to see the output in the console")
	public void user_should_be_able_to_see_the_output_in_the_console() {
		  if(inputCode.equals(" ")) {
			   Assert.assertEquals(expoutput, arraypage.getOutput());
			  
		   }
		   else if(inputCode.equalsIgnoreCase("hello world")) {
			   System.out.println("Entered this condition");
			   LoggerLoad.info("Entered this condition");
			   arraypage.navigateToAlert();
			  Assert.assertEquals(expoutput, arraypage.alertMessage);
			   arraypage.acceptAlert();
		   }
		   else if(inputCode.equals("print('Hello, world!'")) {
			   Assert.assertEquals(expoutput, arraypage.getOutput()); 
		   }

	}
	@When("User clicks on Arrays in Python Link")
	public void user_clicks_on_arrays_in_python_link() {
		arraypage.arrayinPythonClick();
		}
		

	@Then("User should be redirected to Arrays in Python Page")
	public void user_should_be_redirected_to_arrays_in_python_page() {
		System.out.println("Landed on Arrays in Python Page");
		 LoggerLoad.info("Entered this condition");
	}

	@When("User clicks on PracticeQuestion Link")
	public void user_clicks_on_practice_question_link() {
	   arraypage.practqtnLocClick();
	}

	@Then("User should be redirected to Practice question Page")
	public void user_should_be_redirected_to_practice_question_page() {
		System.out.println("Landed on Practice Question Page");
		 LoggerLoad.info("Entered this condition");
	}

	@When("User clicks on {string} Page")
	public void user_clicks_on_page(String link) {
		 expTitle = link;
		  arraypage.practiceQuesClick(link);
	}
	
	

@Then("User should be redirected to clicked Question Page with Run and Submit Button")
public void user_should_be_redirected_to_clicked_question_page_with_run_and_submit_button() {
	Assert.assertEquals(arraypage.checkRunButton(), true);
	Assert.assertEquals(arraypage.checkSubmitButton(), true);
}


@When("User clicks on Run button after entering code {string} and {int}")
public void User_clicks_on_Run_Button_after_entering_code_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
	
	ExcelReader reader = new ExcelReader();
	List<Map<String,String>> userData = 
			reader.getData("src/test/resources/TestData/PractQtns.xlsx", sheetName);
	System.out.println(userData);
    
	String heading = userData.get(rowNumber).get("subjectheading");
	System.out.println("Hearder: "+heading);
    inputCode = userData.get(rowNumber).get("Input ");
	System.out.println("code enterd : "+inputCode);

	expoutput = userData.get(rowNumber).get("RunOutput");
	System.out.println("Expected Output : "+expoutput);
	
	arraypage.sendCodeToPractice(inputCode);
	Thread.sleep(1000);
	arraypage.runButtonClick();
	
}



	
@Then("User should see Run output in the console")
public void user_should_see_run_output_in_the_console() {
	
	if(inputCode.equals(" ")) {
		   Assert.assertEquals(expoutput, arraypage.getOutput());
		  
	   }
	   else if(inputCode.equalsIgnoreCase("System.out.println(\"Hello World\");")) {
		   LoggerLoad.info("Entered this condition");
		   arraypage.navigateToAlert();
	 	   arraypage.acceptAlert();
	 	  Assert.assertEquals(expoutput, arraypage.alertMessage);
	   }
	   else if(inputCode.equals("print('Hello, world!'")) {
		   Assert.assertEquals(expoutput, arraypage.getOutput()); 
	   }
}
@When("User clicks on Submit Button after entering code {string} and {int}")
public void User_clicks_on_Submit_Button_after_entering_code_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> userData = 
				reader.getData("src/test/resources/TestData/PractQtns.xlsx", sheetName);
		System.out.println(userData);
	    
		String heading = userData.get(rowNumber).get("subjectheading");
		System.out.println("Hearder: "+heading);
	    inputCode = userData.get(rowNumber).get("Input ");
		System.out.println("code enterd : "+inputCode);

		expoutput = userData.get(rowNumber).get("SubmitOutput").trim();
		System.out.println("Expected Output : "+expoutput);
		arraypage.sendCodeToPractice(inputCode);
		
		arraypage.submitButtonClick();
		Thread.sleep(1000);
		
}



@Then("User should see Submit output in the console")
public void user_should_see_submit_output_in_the_console() {
	
	if(inputCode.equals(" ")) {
		   Assert.assertEquals(expoutput, arraypage.getOutput());
		  
	   }
	   else if(inputCode.equalsIgnoreCase("System.out.println(\"Hello World\");")) {
		
		   Assert.assertEquals(expoutput, arraypage.getOutput().trim());
	   }
	   else if(inputCode.equals("print('Hello, world!'")) {
		   Assert.assertEquals(expoutput, arraypage.getOutput()); 
	   }
}

}



	
	



	
	

		
	
	

	
	
	
	
	
	
	
	
	
	


	
	

	

	
	
	
	

