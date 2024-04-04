package dsalgo.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.CommonConfigs;

public class GraphPage {

	private WebDriver driver;
	private CommonConfigs commonConfigs;
	private By grpahGetStartedLoc = By.xpath("//h5[contains(text(),'Graph')]/..//a");
	WebElement graphTopics;
	

	public GraphPage(WebDriver driver, CommonConfigs commonConfigs) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
	}

	public CommonConfigs getCommonConfigs() {
		return commonConfigs;
	}

	public void graphGetStartedClick() {
		driver.findElement(grpahGetStartedLoc).click();
	}

	public void graphConceptsClick(String graphconcept) {
		By graphConcepts = By.xpath("//ul//a[text()='" + graphconcept + "']");
		driver.findElement(graphConcepts).click();

	}

}
