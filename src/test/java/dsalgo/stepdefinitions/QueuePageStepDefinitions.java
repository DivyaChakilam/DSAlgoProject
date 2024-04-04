package dsalgo.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import dsalgo.pageobjects.ArraysPage;
import dsalgo.pageobjects.LoginPage;
import dsalgo.pageobjects.QueuePage;
import dsalgo.pageobjects.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import utilities.TestContextSetup;



public class QueuePageStepDefinitions {

	public LoginPage loginpage;
	TestContextSetup testContSetup ;
	public RegisterPage registerpage;
	public ArraysPage arraypage;
	public QueuePage queuepage;
	public String expTitle;
	public String inputCode;
	public String expoutput;
	
	public QueuePageStepDefinitions(TestContextSetup testContSetup) {
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();
		this.arraypage = testContSetup.pageObjManager.getArraysPage();
		this.queuepage = testContSetup.pageObjManager.getQueuePage();
	}


@When("User Clicks Get Started below Queue DS")
public void user_clicks_get_started_below_queue_ds() {
	queuepage.queueGetStartedClick();
}

@Then("User should be redirected to Queue Page")
public void user_should_be_redirected_to_queue_page() {
	String ExpTitle = "Queue";
	Assert.assertEquals(arraypage.getTitleName(), ExpTitle);
	LoggerLoad.info("User Landed on Queue Page");
}

@Given("User is on Queue page")
public void user_is_on_queue_page() {
	LoggerLoad.info("\t user landed on Queue page");
}

@When("User clicks on {string} link under Queue page")
public void user_clicks_on_link_under_queue_page(String link) {
	expTitle = link;
	queuepage.queueTopicsClick(link);
}

@Then("User should be redirected to  clicked link Page")
public void user_should_be_redirected_to_clicked_link_page() {
	 Assert.assertEquals(arraypage.getTitleName(),expTitle);
}

@When("User clicks on Queue page Try Here Button")
public void user_clicks_on_queue_page_try_here_button() {
	arraypage.tryHereClick();
}

@Then("User should be redirected to Queue Editor's page with Run Button")
public void user_should_be_redirected_to_queue_editor_s_page_with_run_button() {
	Assert.assertEquals(arraypage.checkRunButton(), true);
}

@When("User clicks on Run Button after entering code {string} and {int}")
public void user_clicks_on_run_button_after_entering_code_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
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
}

@Then("User will be able to see the output on the console")
public void user_will_be_able_to_see_the_output_on_the_console() {
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

}
