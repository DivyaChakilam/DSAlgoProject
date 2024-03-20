package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;

import config.CommonConfigs;

public class PageObjectManager {

	public LandingPage landingPage;
	public DSAlgoIntroductionPage dsalgoIntroduction;
	public RegisterPage registerPage;
	public LoginPage loginPage;
	public TreePage treePage;
	public StackPage stackPage;
	public QueuePage queuePage;
	public GraphPage graphPage;
	public ArraysPage arraysPage;
	public DataStructuresPage dataStructuresPage;

	public WebDriver driver;
	private CommonConfigs commonConfigs;

	public PageObjectManager(WebDriver driver, CommonConfigs commonConfigs ) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
	}
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}

	public DSAlgoIntroductionPage getDSAlgoIntroductionPage() {
		dsalgoIntroduction= new DSAlgoIntroductionPage(driver);
		return dsalgoIntroduction;
	}

	public RegisterPage getRegisterPage() {
		registerPage= new RegisterPage(driver);
		return registerPage;
	}

	public LoginPage getLoginPage() {
		loginPage = new LoginPage(driver);
		return loginPage;
	}

	public TreePage getTreePage() {
		treePage = new TreePage(driver, commonConfigs);
		return treePage;
	}

	public StackPage getStackPage() {
		stackPage = new StackPage(driver, commonConfigs);
		return stackPage;
	}
	
	public QueuePage getQueuePage() {
		queuePage = new QueuePage(driver, commonConfigs);
		return queuePage;
	}
	
	public GraphPage getGraphPage() {
		graphPage = new GraphPage(driver, commonConfigs);
		return graphPage;
	}
	
	public ArraysPage getArraysPage() {
		arraysPage = new ArraysPage(driver, commonConfigs);
		return arraysPage;
	}
	
	public DataStructuresPage getDataStructuresPage() {
		dataStructuresPage = new DataStructuresPage(driver, commonConfigs);
		return dataStructuresPage;
	}
}
