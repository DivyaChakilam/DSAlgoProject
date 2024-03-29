package config;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonLocators {
	
	 static By tryHereLoc = By.xpath("//a[contains(text(),'Try here')]");
	 static By runButtonLoc = By.xpath("//button");
	 static By editorTextBoxLoc = By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	 static By outputMessLoc = By.xpath("//*[@id='output']");
	 static String outputMessage;
	 static Alert alert;
	 public static String alertMessage;
	 
	 
	 public static void tryHereClick(WebDriver driver) {
			driver.findElement(tryHereLoc).click();
		}

		public static boolean checkRunButton(WebDriver driver) {
			return driver.findElement(runButtonLoc).isDisplayed();
		}

		public static void runButtonClick(WebDriver driver) {
			driver.findElement(runButtonLoc).click();
		}
		
		public static void sendCodeToEditor(String code, WebDriver driver) throws InterruptedException {
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(editorTextBoxLoc)).sendKeys(code);
				Thread.sleep(500);
			//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.findElement(editorTextBoxLoc).sendKeys(code);
			}
		public static String getOutput(WebDriver driver) {
			outputMessage = driver.findElement(outputMessLoc).getText();
			System.out.println(outputMessage);
			return outputMessage;
		}

		public static String navigateToAlert(WebDriver driver) {
			alert = driver.switchTo().alert(); // switch to alert
			alertMessage = driver.switchTo().alert().getText(); // capture alert message
			System.out.println(alertMessage);
			return alertMessage;
		}

		public static void acceptAlert(WebDriver driver) {
			alert.accept();
			driver.switchTo().defaultContent();
		}

		public static String getTitleName(WebDriver driver) {
			return driver.getTitle();
		}


}
