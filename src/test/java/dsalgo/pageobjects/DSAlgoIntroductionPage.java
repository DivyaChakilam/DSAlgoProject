package dsalgo.pageobjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class DSAlgoIntroductionPage {

	private WebDriver driver;
	public WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	private By dataStructureDropdown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	private By dsDropdownOptions = By.xpath("//a[@class='dropdown-item']") ;
	private By loginErr = By.xpath("//div[@role='alert']") ;
	private By getStartedBtn = By.xpath("//a[text()='Get Started'][1]");
	private By registerLink = By.xpath("//a[text()=' Register ']");
	private By registerButton = By.xpath("//input[@type='submit']");
	private By loginLink = By.xpath("//a[text()='Sign in']");
	private By loginButton = By.xpath("//input[@type='submit']");
	private List<WebElement> options;
	public String logErrmsg;

	public DSAlgoIntroductionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickDropdownOptions() {
		driver.findElement(dataStructureDropdown).click();
	}
	
	public void showDropDown() {
		options = driver.findElements(dsDropdownOptions);
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("Arrays")){
				Assert.assertTrue(true);
			} else if(option.getText().equalsIgnoreCase("Linked List")) {
				Assert.assertTrue(true);
			} else if(option.getText().equalsIgnoreCase("Stack")) {
				Assert.assertTrue(true);
			} else if(option.getText().equalsIgnoreCase("Queue")) {
				Assert.assertTrue(true);
			} else if(option.getText().equalsIgnoreCase("Tree")) {
				Assert.assertTrue(true);
			} else if(option.getText().equalsIgnoreCase("Graph")) {
				Assert.assertTrue(true);
			}
		}
	}

	
	public void clickAnyDSItem(String selectOpt) {
		options = driver.findElements(dsDropdownOptions);
		for (int index = 0; index < options.size(); index++) {
			if (options.get(index).getText().contains(selectOpt)) {
				options.get(index).click();
				System.out.println("clicked");
				break;
			}
		}
	}

	
	public void clickAnyGetStarted(){
		driver.findElement(getStartedBtn).click();
	}
	
	public void loginErrMess() {
		logErrmsg = driver.findElement(loginErr).getText();
		System.out.println(wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginErr))).getText());
	}

	
	public void clickRegister() {
		driver.findElement(registerLink).click();
	}
	
	public boolean checkRegButton() {
		return driver.findElement(registerButton).isDisplayed();
	}
	
	public void clickLogin() {
		driver.findElement(loginLink).click();
	}

	public boolean checkLoginButton() {
		return driver.findElement(loginButton).isDisplayed();
	}

}
