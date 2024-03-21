package dsalgo.pageobjects;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import config.CommonConfigs;

public class DataStructuresPage 
{
    private WebDriver driver;
	private CommonConfigs commonConfigs;
	private By dsgetStarted = By.xpath("//a[@href='data-structures-introduction']");
	private By timecomplexity = By.xpath("//a[text()='Time Complexity']");
	private By tryhere = By.xpath("//a[@href='/tryEditor']");  
	private By runButton = By.xpath("//button[text()='Run']");
	private By editorTextBox = By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	private By outputMessloc = By.id("output");
	public String OutputMessage;
	
	
	public DataStructuresPage(WebDriver driver, CommonConfigs commonConfigs ) 
	{
		this.driver = driver;
		this.commonConfigs = commonConfigs;
		
	}
	
	public void GetStartedClick()
	{
		driver.findElement(dsgetStarted).click();
	}

	
	public void dsConceptsClick(String dsconcept) {
		By dsConcepts = By.xpath("//a[contains(text(),'"+dsconcept+"')]");
		driver.findElement(dsConcepts).click();

	}
    public void TimeComplexityClick()
    {
    	driver.findElement(timecomplexity).click();
    }
	public void TryHereClick()
	{
		driver.findElement(tryhere).click();
	}
	
	public boolean checkRunButton()
	{
		return driver.findElement(runButton).isDisplayed();
	}
	
	public void RunButtonClick()
	{
		driver.findElement(runButton).click();
	}
	public void sendCodeToEditor(String code)throws InterruptedException
	{
		
		driver.findElement(editorTextBox).sendKeys(code);
	}

	public String GetOutput() 
	{
		OutputMessage = driver.findElement(outputMessloc).getText();
		System.out.println(OutputMessage);
		return OutputMessage;
	}

	public CommonConfigs getCommonConfigs()
	{
		return commonConfigs;
	}

	public void setCommonConfigs(CommonConfigs commonConfigs)
	{
		this.commonConfigs = commonConfigs;
	}
public String getTitleName() 
{
		return driver.getTitle();
	}


}

	

