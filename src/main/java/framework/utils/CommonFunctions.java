package framework.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {

	private WebDriver driver;
	
	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public CommonFunctions() {
	}

	public WebDriver initDriver() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/exe/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("use-fake-ui-for-media-stream");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public WebDriver initDriverIncognito() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/exe/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions().addArguments("--incognito");
		opt.addArguments("use-fake-ui-for-media-stream");
		this.driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		return driver;
	}
	
	public boolean launchEnv(String url) {
		if(url.length() > 0) {
			driver.get(url);
			return true;
		}
		return false;
	}
	
	public boolean waitTillElementIsDisplayed(String elementLocation) {
		WebDriverWait objWait = new WebDriverWait(driver, 120);
		if(objWait.until(ExpectedConditions.presenceOfElementLocated(getWebElementByObj(elementLocation))) != null)
			return true;
		return false;
	}
	
	private By getWebElementByObj(String elementLocation) {
		return By.xpath(elementLocation);		
	}
	
	private WebElement getWebElement(String elementLocation) {
		return driver.findElement(By.xpath(elementLocation));		
	}
	
	private List<WebElement> getWebElements(String elementLocation) {
		return driver.findElements(By.xpath(elementLocation));		
	}
	
	public List<WebElement> getWebElementsList(String elementLocation) {
		waitTillElementIsDisplayed("(" + elementLocation + ")[1]");
		List<WebElement> webElementList = 	getWebElements(elementLocation);
		if(webElementList.size() > 0) {
			return webElementList;
		}
		return null;
	}
	
	public boolean clearTextFeild(String elementLocation) {
		if(waitTillElementIsDisplayed(elementLocation)) {
			getWebElement(elementLocation).clear();
			return true;
		}
		return false;	
	}
	
	public boolean enterValueInTextFeild(String elementLocation, String value) {
		if(waitTillElementIsDisplayed(elementLocation)) {
			getWebElement(elementLocation).sendKeys(value);
			return true;
		}
		return false;	
	}
	
	public boolean clearAndEnterValueInTextFeild(String elementLocation, String value) {
		if(waitTillElementIsDisplayed(elementLocation)) {
			WebElement webelement = getWebElement(elementLocation);
			webelement.clear();
			webelement.sendKeys(value);
			return true;
		}
		return false;	
	}
	
	public boolean clickAndEnterValueInTextFeild(String elementLocation, String value) {
		if(waitTillElementIsDisplayed(elementLocation)) {
			WebElement webelement = getWebElement(elementLocation);
			webelement.click();
			webelement.sendKeys(value);
			return true;
		}
		return false;	
	}
	
	public boolean clickOnElement(String elementLocation) {
		if(waitTillElementIsDisplayed(elementLocation)) {
			getWebElement(elementLocation).click();
			return true;
		}
		return false;	
	}
	
	
}
