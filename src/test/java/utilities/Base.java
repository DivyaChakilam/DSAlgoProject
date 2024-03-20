package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import config.CommonConfigs;
import config.ConfigLoader;
//import utilities.LoggerLoad;


public class Base {

	public WebDriver driver;
	String url = "https://dsportalapp.herokuapp.com/";
	public CommonConfigs configs;
	
	public WebDriver WebDriverManager() throws Throwable {
		
		String browser = ConfigLoader.getBrowserType();
		if(driver == null) {
			loadCommonConfigs();
			if (browser.equalsIgnoreCase("firefox")) {
				LoggerLoad.info("Testing on firefox");
				//WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("chrome")) {
				LoggerLoad.info("Testing on chrome");
				//WebDriverManager.chromedriver().browserVersion("108.0.0").setup();
				System.setProperty("webdriver.chrome.silentOutput","true");
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("safari")) {
				LoggerLoad.info("Testing on safari");
				//WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();

			} else if (browser.equalsIgnoreCase("edge")) {
				LoggerLoad.info("Testing on Edge");
				//WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			//driver = new ChromeDriver();
			driver.manage().window().maximize();
			  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// Set Page load timeout
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.get(configs.getUrl());
		}
		return driver;
	}
	
	public void loadCommonConfigs() {

		FileInputStream fis = null;
		configs = new CommonConfigs();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+
					"//src//test//resources//config//global.properties");

			Properties prop = new Properties();
			prop.load(fis);
			configs.setUrl(prop.getProperty("url"));
			//configs.setBrowser(prop.getProperty("browser"));
			configs.setUserName(prop.getProperty("userName"));
			configs.setPassword(prop.getProperty("password"));		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CommonConfigs getConfigs() {
		return configs;
	}
}
