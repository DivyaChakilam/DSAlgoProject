package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;

import config.CommonConfigs;

public class DataStructuresPage {

	private WebDriver driver;
	private CommonConfigs commonConfigs;

	public DataStructuresPage(WebDriver driver, CommonConfigs commonConfigs ) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
	}
	
	public CommonConfigs getCommonConfigs() {
		return commonConfigs;
	}
}
