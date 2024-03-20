package dsalgo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By loginButton = By.xpath("//input[@type='submit']");
	private By userNameLoc = By.id("id_username");
	private By passwordLoc = By.id("id_password");
	private By signoutLinkLocator = By.xpath("//a[text()='Sign out']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
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
}
