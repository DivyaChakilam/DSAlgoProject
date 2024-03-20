package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;

import config.CommonConfigs;

public class QueuePage {

	private WebDriver driver;
	private CommonConfigs commonConfigs;

	public QueuePage(WebDriver driver, CommonConfigs commonConfigs ) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
	}
	
	public CommonConfigs getCommonConfigs() {
		return commonConfigs;
	}
}
