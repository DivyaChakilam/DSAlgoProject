package dsalgo.pageobjects;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import config.CommonConfigs;

public class LinkedListPage 
{
	
		private WebDriver driver;
		private CommonConfigs commonConfigs;
		private By llistgetStarted = By.xpath("//a[@href='linked-list']");
		private By introduction = By.xpath("//a[text()='Introduction']");
		
		private By tryhere = By.xpath("//a[text()='Try here>>>']");  
		private By runButton = By.xpath("//button[text()='Run']");
		private By editorTextBox = By.xpath("//form[@id='answer_form']/div/div/div/textarea");
		private By outputMessLoc = By.id("output");
		public String outputMessage = "Hello,World!";

		public LinkedListPage(WebDriver driver, CommonConfigs commonConfigs ) 
		{
			this.driver = driver;
			this.commonConfigs = commonConfigs;
		}

		public void GetStartedClick() 
		{
			driver.findElement(llistgetStarted).click();
		}

		public void IntroductionClick()
		{
			driver.findElement(introduction).click();
		}
		/*public void CreatingClick()
		{
			driver.findElement(creating).click();
		}
		public void TypesClick()
		{
			driver.findElement(types).click();
		}
		public void ImplementClick()
		{
			driver.findElement(implement).click();
		}
		public void TraversalClick()
		{
			driver.findElement(traversal).click();
		}
		public void InsertionClick()
		{
	      driver.findElement(insertion).click();;
		}
		public void DeletionClick()
		{
			driver.findElement(deletion).click();
		}*/
		public void llConceptsClick(String llconcept) {
			By llConcepts = By.xpath("//a[contains(text(),'"+llconcept+"')]");
			driver.findElement(llConcepts).click();

		}

		public void TryHereClick()
		{
			driver.findElement(tryhere).click();
		}
		
		public boolean checkRunButton()
		{
			return driver.findElement(runButton).isDisplayed();
		}
		
		public void RunButtonClick() {
			driver.findElement(runButton).click();
		}
		public void sendCodeToEditor(String code)throws InterruptedException
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			driver.findElement(editorTextBox).sendKeys(code);
		}
		

		public void GetOutput() {
			outputMessage = driver.findElement(outputMessLoc).getText();
			System.out.println(outputMessage);
		}

		public CommonConfigs getCommonConfigs() {
			return commonConfigs;
		}

		public void setCommonConfigs(CommonConfigs commonConfigs) {
			this.commonConfigs = commonConfigs;
		}
		public String getTitleName() 
		{
				return driver.getTitle();
			}

	}
