package dsalgo.pageobjects;



import java.time.Duration;

import config.CommonConfigs;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QueuePage {

	public WebDriver driver;
	private CommonConfigs commonConfigs;

	private By queueGetStartedLoc = By.xpath("//a[@href='queue']");
	private By tryHere = By.xpath("//a[@href='/tryEditor']");
	private By runButtonLoc = By.xpath("//button[@type='button']");
	WebElement queuetopics;
	private By editorTextBoxLoc = By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	private By outputmsgline = By.id("output");
	public String outputMessage;
	public Alert alert;
	public String queuetopic;
	public String alertMessage;

	public QueuePage(WebDriver driver, CommonConfigs commonConfigs) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
	}

	public void queueGetStartedClick() {
		driver.findElement(queueGetStartedLoc).click();
	}

	public void queueTopicsClick(String queuetopic) {
		By queuetopics = By.xpath("//a[contains(text(),'"+queuetopic+"')]");
		driver.findElement(queuetopics).click();
	}

	public void tryHereClick() {
		driver.findElement(tryHere).click();
		;
	}

	public boolean checkRunButton() {
		return driver.findElement(runButtonLoc).isDisplayed();
	}

	public void runButtonClick() {
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(runButtonLoc).click();
	}

	public void sendCodeToEditor(String Code) {
		driver.findElement(editorTextBoxLoc).sendKeys(Code);

	}

	public String getTitleName() {
		return driver.getTitle();
	}

	public String getOutput() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		outputMessage = driver.findElement(outputmsgline).getText();
		System.out.println(outputMessage);
		return outputMessage;
	}

	public String navigateToAlert() {
		alert = driver.switchTo().alert();
		alertMessage = driver.switchTo().alert().getText();
		System.out.println("i am expecting output: " + alertMessage);
		return alertMessage;
	}

	public void acceptAlert() {
		alert.accept();
		driver.switchTo().defaultContent();
	}

	public CommonConfigs getCommonConfigs() {
		return commonConfigs;
	}

}
