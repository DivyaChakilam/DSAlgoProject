package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;

import config.CommonConfigs;

public class ArraysPage {

	private WebDriver driver;
	private CommonConfigs commonConfigs;

	public ArraysPage(WebDriver driver, CommonConfigs commonConfigs ) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
	}
	
	public CommonConfigs getCommonConfigs() {
		return commonConfigs;
	}
}
