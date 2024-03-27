package dsalgo.stepdefinitions;

import org.testng.Assert;

import dsalgo.pageobjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class LandingPageStepdefinitions{
	//public WebDriver driver;
	LandingPage landingpage;
	TestContextSetup testContSetup ;

	public LandingPageStepdefinitions(TestContextSetup testContSetup) {
		this.testContSetup = testContSetup;
		this.landingpage = testContSetup.pageObjManager.getLandingPage();
	}

	@Given("user opened a browser and landed on dsalgo portal")
	public void user_opened_a_browser_and_landed_on_dsalgoportal() {
		LoggerLoad.info("/t user opens browser");
		String message = landingpage.getStartedMessage();
		Assert.assertTrue(message.contains("You are at the right place"));
	}

	@When("user clicks on GetStarted button")
	public void user_clicks_on_get_started_button() {
		landingpage.getStartedClick();
	}

	@Then("user should land on dsalgo introduction page with register and signin links")
	public void user_should_land_on_dsalgo_introduction_page_with_register_and_signin_links()
			throws InterruptedException {
	//	Thread.sleep(1000);
		Assert.assertEquals(landingpage.checkRegisterLink(), true);
		Assert.assertEquals(landingpage.checkSigninLink(), true);
	}
}
