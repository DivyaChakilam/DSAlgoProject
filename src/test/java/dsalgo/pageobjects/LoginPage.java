package dsalgo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.CommonConfigs;

public class LoginPage {

	private WebDriver driver;
	private CommonConfigs commonConfigs;
	public String messageStr;
	public String errorMessage;
	private WebElement activeElement;
	private By loginButton = By.xpath("//input[@type='submit']");
	private By userNameLoc = By.id("id_username");
	private By passwordLoc = By.id("id_password");
	private By signoutLinkLocator = By.xpath("//a[text()='Sign out']");
	private By errorMess = By.xpath("//div[contains(@class,'alert')]") ;

	public LoginPage(WebDriver driver, CommonConfigs commonConfigs) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
		//this.driver.get(commonConfigs.getLoginUrl());
	}

	public CommonConfigs getCommonConfigs() {
		return commonConfigs;
	}

	public void setCommonConfigs(CommonConfigs commonConfigs) {
		this.commonConfigs = commonConfigs;
	}
	
	public void enterUsername(String username) {
		driver.findElement(userNameLoc).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLoc).sendKeys(password);
	}

	public void submitLogin() {
		driver.findElement(loginButton).click();
	}

	public boolean checkSignoutLink() {
		return driver.findElement(signoutLinkLocator).isDisplayed();	 
	}
	
	public String getErrorMssg() {
		errorMessage = driver.findElement(errorMess).getText();
		//System.out.println(errorMessage);
		return errorMessage;
	}
	
	public String inputFieldValMess() {
		activeElement = driver.switchTo().activeElement();
		messageStr = activeElement.getAttribute("validationMessage");
		System.out.println("\t Actual message appeared on screen: " + messageStr);
		return messageStr;
	}
	
}
