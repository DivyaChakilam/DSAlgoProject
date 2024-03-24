package dsalgo.pageobjects;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import config.CommonConfigs;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StackPage {
	
	private WebDriver driver;
	private CommonConfigs commonConfigs;
	private By stackGetStartedLoc = By.xpath("//h5[contains(text(),'Stack')]/..//a");
	private By OperationsinStackLoc = By.xpath("//a[text()='Implementation']");
	private By tryHereLoc = By.xpath("//a[contains(text(),'Try here')]");
	private By runButtonLoc = By.xpath("//button");
	private By editorTextBoxLoc = By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	private By outputMessLoc = By.id("output");
	public String outputMessage;
	
	public StackPage(WebDriver driver, CommonConfigs commonConfigs ) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
	}

	public void stackGetStartedClick() {
		driver.findElement(stackGetStartedLoc).click();
	}

	public void operationsinStackClick()
	{
		driver.findElement(OperationsinStackLoc).click();
	}
	
	private By stackGetStartedBtn = By.xpath("//h5[text() = 'Stack']/..//*[text() = 'Get Started']");
	By operationInStack = By.linkText("Operations in Stack");
	public String alertMessage;
	
	public void clickOnGetStackStarted() {
		driver.findElement(stackGetStartedBtn).click();
	}
	
	public void clickOnTopicInStack() {
		driver.findElement(operationInStack).click();
	}
	public void verfyHeading(String expectedTxt) {
		String actualTxt = (driver.getTitle());
		//String actualTxt = driver.findElement(verifyHeading).getText();
		assertEquals(actualTxt, expectedTxt);
	}
	
	public void stackConceptsClick(String stackconcept) {
		By stackConcepts = By.xpath("//a[contains(text(),'"+stackconcept+"')]");
		driver.findElement(stackConcepts).click();

	}
	
	public void tryHereClick() {
		driver.findElement(tryHereLoc).click();
	}

	public boolean checkRunButton() {
		return driver.findElement(runButtonLoc).isDisplayed();
	}

	public void runButtonClick() {
		driver.findElement(runButtonLoc).click();
	}

	public void sendCodeToEditor(String code) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(editorTextBoxLoc).sendKeys(code);
	}

	public String getOutput() {
		outputMessage = driver.findElement(outputMessLoc).getText();
		System.out.println(outputMessage);
		return outputMessage;
	}

	public String navigateToAlert() {
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage = driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage);
		return alertMessage;

	}
	public String getTitleName() {
		return driver.getTitle();
	}

	
	public void setCommonConfigs(CommonConfigs commonConfigs) {
		this.commonConfigs = commonConfigs;
	}

	public CommonConfigs getCommonConfigs() {
		return this.commonConfigs = commonConfigs;
	}

	
}
