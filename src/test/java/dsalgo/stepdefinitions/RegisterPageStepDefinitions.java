package dsalgo.stepdefinitions;

import org.junit.Assert;

import dsalgo.pageobjects.DSAlgoIntroductionPage;
import dsalgo.pageobjects.LandingPage;
import dsalgo.pageobjects.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;
//import junit.framework.Assert;
import utilities.TestContextSetup;

public class RegisterPageStepDefinitions {

	public RegisterPage registerpage;
	TestContextSetup testContSetup ;

	public RegisterPageStepDefinitions(TestContextSetup testContSetup) {
		this.testContSetup = testContSetup;
		this.registerpage = testContSetup.pageObjManager.getRegisterPage();
	}
	
	//this is background for all the scenarios
	@Given("User landed on Register Page")
	public void user_landed_on_register_page() {
		/*
		 * LandingPage landingPage = testContSetup.pageObjManager.getLandingPage();
		 * landingPage.getStartedClick(); DSAlgoIntroductionPage dsalgoIntroduction =
		 * testContSetup.pageObjManager.getDSAlgoIntroductionPage();
		 * dsalgoIntroduction.clickRegister();
		 */
		LoggerLoad.info("\t User Landed on Register Page");
	}

	//user is giving all fields empty
	@Given("User leaves all fields empty")
	public void User_leaves_all_fields_empty() {
		LoggerLoad.info("\t User gives all empty fields");
	}

	//user is giving only user name and all other fields empty
	@Given("^User gives only (.*) field$")
	public void User_gives_only_username_field(String username) {
		LoggerLoad.info("\t User gives only username field");
		registerpage.enterUserName(username);
	}
	//user is giving only user name password and without confirm password
	@Given("^User gives (.*) and (.*) without confirm password field$")
	public void User_gives_username_password_without_confirmpasswordfield
						(String username, String password) {
		LoggerLoad.info("\t User gives only username password field without confirmpassword");
		registerpage.enterUserName(username);
		registerpage.enterPassword(password);
	}	

	@Given("^User gives invalid (.*) and (.*) and (.*)$")
	public void user_gives_invalid_username(String username, String password, String confirmpassword) {
		LoggerLoad.info("\t User gives invalid username with space and * characters");
		registerpage.enterUserName(username);
		registerpage.enterPassword(password);
		registerpage.enterconfirmPassword(confirmpassword);
	}

	@Given("^User gives valid credentials (.*) and (.*) and (.*)$")
	public void user_gives_valid_credentials(String username, String password, String confirmpassword) {
		LoggerLoad.info("\t User gives invalid username and password");
		registerpage.enterUserName(username);
		registerpage.enterPassword(password);
		registerpage.enterconfirmPassword(confirmpassword);
	}

	//user clicking on register button
	@When("User clicks RegisterButton")
	public void user_clicks_register_button() {
		registerpage.submitRegister();
	}

	//error validation message under username field
	@Then("^It should display an error (.*) below Username textbox$")
	public void it_should_display_an_error_below_username_textbox(String message) {
		registerpage.inputFieldValMess();
		Assert.assertEquals(registerpage.messageStr, message);
	}

	@Then("^It should display an error (.*) below password textbox$")
	public void it_should_display_an_error_below_password_textbox(String message) {
		registerpage.inputFieldValMess();
		Assert.assertEquals(registerpage.messageStr, message);
	}

	@Then("^It should display an error (.*) below confirm password textbox$")
	public void it_should_display_an_error_please_fill_out_this_field_below_confirm_password_textbox(String message) {
		registerpage.inputFieldValMess();
		Assert.assertEquals(registerpage.messageStr, message);
	}

	@Then("It is not showing valid error messages for invalid inputs")
	public void it_is_not_showing_valid_error_messages_for_invalid_inputs() {
		registerpage.getErrorMssg();
		LoggerLoad.info("\t Valid error message is not showing after giving invalid username");
		LoggerLoad.info("\t Error message showing is : " +registerpage.errorMessage);
	}

	@Then("^User should see password mismatch error message (.*)$")
	public void user_should_see_password_mismatch_error_message(String message) {
		registerpage.getErrorMssg();
		LoggerLoad.info("\t Error message showing is : " +registerpage.errorMessage);
		Assert.assertEquals(registerpage.errorMessage, message);
	}

	@Then("User should be directed to DsAlgo Home Page with succes message and signout button")
	public void user_should_be_directed_to_ds_algo_home_page_with_succes_message_and_signout_button() {
		LoggerLoad.info("\t User account created");
	}

	@Then("It is giving irrelavant error message with password mismatch")
	public void it_is_giving_irrelavant_error_message_with_password_mismatch() {
		LoggerLoad.info("\t When registering with existing credentials it is giving irreleavnt error message");
	}
}
