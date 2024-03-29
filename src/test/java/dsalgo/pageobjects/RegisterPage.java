package dsalgo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.CommonConfigs;

public class RegisterPage {

	private WebDriver driver;
	private CommonConfigs commonConfigs;
	public String messageStr;
	public String errorMessage;
	private WebElement activeElement;
	private By RegisterButton = By.xpath("//input[@type='submit']");
	private By userNameLoc = By.name("username");
	private By passWordLoc = By.name("password1");
	private By confirmPassWordLoc = By.name("password2");
	private By errorMess = By.xpath("//div[contains(@class,'alert')]") ;

	public RegisterPage(WebDriver driver, CommonConfigs commonConfigs) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
		this.driver.get(commonConfigs.getRegisterUrl());

	}

	public CommonConfigs getCommonConfigs() {
		return commonConfigs;
	}

	public void setCommonConfigs(CommonConfigs commonConfigs) {
		this.commonConfigs = commonConfigs;
	}
	
	public void submitRegister() {
		driver.findElement(RegisterButton).click();
	}

	public String inputFieldValMess() {
		activeElement = driver.switchTo().activeElement();
		messageStr = activeElement.getAttribute("validationMessage");
		System.out.println("\t Actual message appeared on screen: " + messageStr);
		return messageStr;
	}

	public void enterUserName(String username) {
		driver.findElement(userNameLoc).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passWordLoc).sendKeys(password);
	}

	public void enterconfirmPassword(String confirmpassword) {
		driver.findElement(confirmPassWordLoc).sendKeys(confirmpassword);
	}

	public String getErrorMssg() {
		errorMessage = driver.findElement(errorMess).getText();
		//System.out.println(errorMessage);
		return errorMessage;
	}
}
