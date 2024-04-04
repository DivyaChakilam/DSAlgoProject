package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public  class LocatorUtility {
	
	public static void conceptsClick(String concept, WebDriver driver) {
		By conceptLocator = By.xpath("//a[contains(text(),'"+concept+"')]");
		driver.findElement(conceptLocator).click();
	}

}
