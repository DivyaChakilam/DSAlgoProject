package dsalgo.pageobjects;

import java.time.Duration;

import org.openqa.selenium.Alert;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.CommonConfigs;
import utilities.TestContextSetup;

public class DataStructuresPage 
{
    private WebDriver driver;
	private CommonConfigs commonConfigs;
	private By dsgetStarted = By.xpath("//a[@href='data-structures-introduction']");
	private By timecomplexity = By.xpath("//a[text()='Time Complexity']");
	private By tryhereLoc = By.xpath("//a[contains(text(),'Try here')]"); 
	private By runButtonLoc = By.xpath("//button");
	private By editorTextBoxLoc = By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	private By outputMessloc = By.id("output");
	public String OutputMessage;
	public Alert alert;
	public String treetopic;
	public String alertMessage;
	WebDriverWait wait =  null;
		
	public DataStructuresPage(WebDriver driver, CommonConfigs commonConfigs ) 
	{
		this.driver = driver;
		this.commonConfigs = commonConfigs;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	public CommonConfigs getCommonConfigs() {
		return commonConfigs;
	}

	public void setCommonConfigs(CommonConfigs commonConfigs) {
		this.commonConfigs = commonConfigs;
	}
	public void GetStartedClick()
	{
		driver.findElement(dsgetStarted).click();
	}

	
//	public void dsConceptsClick(String dsconcept) {
//		By dsConcepts = By.xpath("//ul//a[text()='" + dsconcept + "']\"");
//		driver.findElement(dsConcepts).click();
//("//a[contains(text(),'"+dsconcept+"')]");
//	}
	public void TimeComplexityClick()
    {
    	driver.findElement(timecomplexity).click();
    }
	public void tryHereClick()
	{
		driver.findElement(tryhereLoc).click();
	}
	
	public boolean checkRunButton()
	{
		return driver.findElement(runButtonLoc).isDisplayed();
	}
	
	public void RunButtonClick()
	{
		driver.findElement(runButtonLoc).click();
	}
	public void sendCodeToEditor(String code)throws InterruptedException
	{
		
		driver.findElement(editorTextBoxLoc).sendKeys(code);
	}
	public String getOutput() {
		OutputMessage = driver.findElement(outputMessloc).getText();
		System.out.println(OutputMessage);
		return OutputMessage;
	}

	public String navigateToAlert() {
		alert = driver.switchTo().alert(); // switch to alert
		alertMessage = driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage);
		return alertMessage;
	}

	public void acceptAlert() {
		alert.accept();
		driver.switchTo().defaultContent();
	}

	public String getTitleName() {
		return driver.getTitle();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
