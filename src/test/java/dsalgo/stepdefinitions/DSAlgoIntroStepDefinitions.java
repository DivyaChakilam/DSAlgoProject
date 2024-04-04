package dsalgo.stepdefinitions;

import org.junit.Assert;

import dsalgo.pageobjects.DSAlgoIntroductionPage;
import dsalgo.pageobjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class DSAlgoIntroStepDefinitions {

	public String expErrMess = "You are not logged in";

	public DSAlgoIntroductionPage dsalgoIntroduction;
	TestContextSetup testContSetup ;

	public DSAlgoIntroStepDefinitions(TestContextSetup testContSetup) {
		this.testContSetup = testContSetup;
		this.dsalgoIntroduction = testContSetup.pageObjManager.getDSAlgoIntroductionPage();
	}
	
	@Given("User Landed on DsAlgo Introduction Page")
	public void user_landed_on_ds_algo_introduction_page() {
		LandingPage landingPage  = testContSetup.pageObjManager.getLandingPage();
		landingPage.getStartedClick();
	}

	@When("User clicks on DataStructure Dropdown")
	public void user_clicks_on_data_structure_dropdown() {
		dsalgoIntroduction.clickDropdownOptions();
	}

	@Then("User should see six different datastructures")
	public void user_should_see_different_datastructures() {
		dsalgoIntroduction.showDropDown();
	}

	@When("User clicks on any item from DataStructures DropDown")
	public void user_clicks_on_any_item_from_data_structures_drop_down() {
		dsalgoIntroduction.clickAnyDSItem("Stack"); 
	}

	@Then("User gets alert message")
	public void user_gets_alert_message() {
		dsalgoIntroduction.loginErrMess();
		LoggerLoad.info(dsalgoIntroduction.logErrmsg);
		Assert.assertEquals(dsalgoIntroduction.logErrmsg,expErrMess);
	}

	@When("User clicks on any GetStarted button")
	public void user_clicks_on_any_get_started_button() {
		dsalgoIntroduction.clickAnyGetStarted();
	}

	@When("User clicks on Register button")
	public void user_clicks_on_register_button() {
		dsalgoIntroduction.clickRegister();
	}

	@Then("User should land on Register page")
	public void user_should_land_on_register_page() {
		Assert.assertEquals(dsalgoIntroduction.checkRegButton(), true);
	}

	@When("User clicks on Login")
	public void user_clicks_on_login() {
		dsalgoIntroduction.clickLogin();
	}

	@Then("User lands on Login page with Register link below the textboxes")
	public void user_lands_on_login_page_with_register_link_below_the_textboxes() {
		Assert.assertEquals(dsalgoIntroduction.checkLoginButton(), true);

	}
}
