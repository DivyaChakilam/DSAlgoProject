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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class LoginPageStepDefinitions {
	
	public LoginPage loginpage;
	TestContextSetup testContSetup ;
	public RegisterPage registerpage;
	public int rowNum;
	public String Message;

	public LoginPageStepDefinitions(TestContextSetup testContSetup) {
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();
		this.registerpage = testContSetup.pageObjManager.getRegisterPage();
	}
	
	@Given("User landed on Login Page")
	public void user_landed_on_login_page() {
	    
		LandingPage landingPage  = testContSetup.pageObjManager.getLandingPage();
		landingPage.getStartedClick();
		DSAlgoIntroductionPage dsalgoIntroduction = testContSetup.pageObjManager.getDSAlgoIntroductionPage();
		dsalgoIntroduction.clickLogin();
		LoggerLoad.info("\t User Landed on Login Page");
	}

	@When("User clicks on Login button with entering invalid data sheet {string} and row {int}")
	public void user_clicks_on_login_button_with_entering_invalid_data_sheet_user_data_and_row(String sheetName,Integer rowNumber) throws InvalidFormatException, IOException {
	    rowNum=rowNumber;
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> userData = 
				reader.getData("src/test/resources/TestData/UserData.xlsx", sheetName);
		LoggerLoad.info(userData.toString());

		String heading = userData.get(rowNumber).get("subjectheading");
		LoggerLoad.info("Hearder: "+heading);
		String Username = userData.get(rowNumber).get("Username");
		LoggerLoad.info("username: "+Username);

		String Password = userData.get(rowNumber).get("Password");
		LoggerLoad.info("password :"+Password);

		Message = userData.get(rowNumber).get("Message");
		LoggerLoad.info("Expected message: "+Message);
		
		loginpage.enterUsername(Username);
		loginpage.enterPassword(Password);
		loginpage.submitLogin();	

	}

	@Then("User should get error validation message")
	public void user_should_get_error_validation_message() {
		if(rowNum == 0 || rowNum == 1 ) {
		    Assert.assertEquals(registerpage.inputFieldValMess(), Message );
		} else if(rowNum ==2 ||rowNum ==3 || rowNum ==4 ){
			LoggerLoad.info("I have entered else block");
			Assert.assertEquals(registerpage.getErrorMssg(),Message );
			Assert.assertEquals(registerpage.errorMessage, Message);
			registerpage.getErrorMssg();
			LoggerLoad.info("Expected Message :" + registerpage.getErrorMssg());
		}
	}

	@When("User clicks on Login button with entering valid data sheet {string} and row {int}")
	public void user_clicks_on_login_button_with_entering_valid_user_data(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> userData = 
				reader.getData("src/test/resources/TestData/UserData.xlsx", sheetName);
		LoggerLoad.info(userData.toString());

		String heading = userData.get(rowNumber).get("subjectheading");
		LoggerLoad.info("Hearder: "+heading);
		String Username = userData.get(rowNumber).get("Username");
		LoggerLoad.info("username: "+Username);

		String Password = userData.get(rowNumber).get("Password");
		LoggerLoad.info("password :"+Password);

		Message = userData.get(rowNumber).get("Message");
		LoggerLoad.info("Expected message: "+Message);
		
		loginpage.enterUsername(Username);
		loginpage.enterPassword(Password);
		loginpage.submitLogin();	
	}

	@Then("User should land on home page")
	public void user_should_land_on_home_page() {
		Assert.assertEquals(loginpage.checkSignoutLink(), true);
		LoggerLoad.info("You are logged in");
	}
	
	@When("User clicks on Login button with entering empty fields")
	public void user_clicks_on_login_button_with_entering_empty_fields() {
		loginpage.submitLogin();
	}
	
	@Then("User should get error validation message for emptyfields")
	public void user_should_get_error_validation_message_for_emptyfields() {
		LoggerLoad.info("Error validation message: "+registerpage.inputFieldValMess());
	}
}
