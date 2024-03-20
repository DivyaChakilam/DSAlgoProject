package dsalgo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage{

	private WebDriver driver;
	private By landpagemsgloctr = By.tagName("p");
	private By getstartedbtn = By.xpath("//button[@class='btn']");
	private By registerLinkLocator = By.xpath("//a[text()=' Register ']");
	private By signinLinkLocator = By.xpath("//a[text()='Sign in']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getStartedMessage() {
		return driver.findElement(landpagemsgloctr).getText();
	}

	public void getStartedClick() {
		driver.findElement(getstartedbtn).click();
	}

	public boolean checkRegisterLink() {
		System.out.println(driver.findElement(registerLinkLocator).getText());
		return driver.findElement(registerLinkLocator).isDisplayed();
	}
	
	public boolean checkSigninLink() {
		return driver.findElement(signinLinkLocator).isDisplayed();
	}
}
