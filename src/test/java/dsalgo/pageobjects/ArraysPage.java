package dsalgo.pageobjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.CommonConfigs;

public class ArraysPage {

	private WebDriver driver;
	private CommonConfigs commonConfigs;
	
	private By arrayGetStartedLoc = By.xpath("//a[@href='array']");
	private By tryHere = By.xpath("//a[@href='/tryEditor']");
	private By runButtonLoc = By.xpath("//button[@type='button']");
	WebElement arraytopics;
	WebElement codeMirror;
	WebElement codeLine;
	WebElement textBox;
	
	private By editorTextBoxLoc = By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	//private By practiceBoxLoc = By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	private By outputmsgline=By.id("output");
	public String outputMessage;
	public Alert alert;
	public String arraytopic;
	public String alertMessage;
	private By arraysinPythonLoc = By.xpath("//a[@href='arrays-in-python']");
	private By practcQtnLoc = By.xpath("//a[@href='/array/practice']");
	private By submitButtonLoc=By.className("button");
	//By.xpath("//input[@type='submit']");
	public ArraysPage(WebDriver driver, CommonConfigs commonConfigs ) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
	}
	
	public void arrayGetStartedClick() {
		driver.findElement(arrayGetStartedLoc).click();
	}
	
	public void arrayTopicsClick(String arraytopic)  {
		 By arraytopics= By.xpath("//a[contains(text(),'"+arraytopic+"')]");
		driver.findElement(arraytopics).click();

	}
	public void arrayinPythonClick() {
		driver.findElement(arraysinPythonLoc).click();
		}
	
	public void practqtnLocClick() {
		driver.findElement(practcQtnLoc).click();
	}
	public void practiceQuesClick(String practQtn)  {
		 By practQtns= By.xpath("//div[@class='list-group']/a[contains(text(),'"+practQtn+"')]");
		driver.findElement(practQtns).click();
		
	}
	
	public void tryHereClick()
	{
		driver.findElement(tryHere).click();;
	}
	
	public boolean checkRunButton() {
		return driver.findElement(runButtonLoc).isDisplayed();
	}
	
	
	
	public void runButtonClick()
	{
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(runButtonLoc).click();
	}
	
	public void sendCodeToEditor(String Code) throws InterruptedException  {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(editorTextBoxLoc).sendKeys(Code);
		Thread.sleep(900);
	}
	public void sendCodeToPractice(String Code) {
		WebElement codeMirror=driver.findElement(By.className("CodeMirror"));
		WebElement codeLine=codeMirror.findElements(By.className("CodeMirror-line")).get(0);
		codeLine.click();
		WebElement textBox=codeMirror.findElement(By.cssSelector("textarea"));
		textBox.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		textBox.sendKeys(Code);
			
	}
	public boolean checkSubmitButton() {
		return driver.findElement(submitButtonLoc).isDisplayed();
	}
	
	
	public void submitButtonClick()
	{
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(submitButtonLoc).click();
		}
	
	
	public String getTitleName() {
		return driver.getTitle();
	}
	public String getOutput() {
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		outputMessage = driver.findElement(outputmsgline).getText();
		System.out.println(outputMessage);
		return outputMessage;
	}

	public String navigateToAlert() {
		alert = driver.switchTo().alert(); 
		alertMessage = driver.switchTo().alert().getText(); 
		System.out.println("i am expecting output: "+alertMessage );
		return alertMessage;
	}

	public void  acceptAlert() {
			alert.accept();
		driver.switchTo().defaultContent();
	}
	
	
	public CommonConfigs getCommonConfigs() {
		return commonConfigs;
	}

	

	
	
}
