package dsalgo.pageobjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.CommonConfigs;

public class TreePage {

	private WebDriver driver;
	private CommonConfigs commonConfigs;
	private By treeGetStartedLoc = By.xpath("//h5[contains(text(),'Tree')]/..//a");
	private By tryHereLoc = By.xpath("//a[contains(text(),'Try here')]");
	private By runButtonLoc = By.xpath("//button");
	private By editorTextBoxLoc = By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	private By outputMessLoc = By.xpath("//*[@id='output']");
	//WebElement treeTopics;
	public String outputMessage;
	public Alert alert;
	public String treetopic;
	public String alertMessage;
	WebDriverWait wait =  null;

	public TreePage(WebDriver driver, CommonConfigs commonConfigs) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
		//this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	}

	public CommonConfigs getCommonConfigs() {
		return commonConfigs;
	}

	public void setCommonConfigs(CommonConfigs commonConfigs) {
		this.commonConfigs = commonConfigs;
	}

	public void treeGetStartedClick() {
		driver.findElement(treeGetStartedLoc).click();
	}
	
	public void treeConceptsClick(String treeconcept) {
		By treeConcepts = By.xpath("//a[contains(text(),'"+treeconcept+"')]");
		//wait.until(ExpectedConditions.elementToBeClickable(treeConcepts)).click();
		driver.findElement(treeConcepts).click();
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

	public void sendCodeToEditor(String code) throws InterruptedException {
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(editorTextBoxLoc)).sendKeys(code);
		Thread.sleep(500);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(editorTextBoxLoc).sendKeys(code);
	}

	public String getOutput() {
		outputMessage = driver.findElement(outputMessLoc).getText();
		System.out.println(outputMessage);
		return outputMessage;
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
