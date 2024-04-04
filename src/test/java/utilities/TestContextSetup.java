package utilities;

import dsalgo.pageobjects.PageObjectManager;

public class TestContextSetup {
	
	
	public PageObjectManager pageObjManager;
	public Base base;
	
	public TestContextSetup() throws Throwable {
		base = new Base();
		pageObjManager = new PageObjectManager(base.WebDriverManager(), base.getConfigs()); 
	}

}
