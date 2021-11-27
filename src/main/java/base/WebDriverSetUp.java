package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yhamid 
 * This java class consists of web driver initialization.
 */

public class WebDriverSetUp {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	

	protected void initializeDriver() {
		System.setProperty(Constants.systemKeyChrome, System.getProperty("user.dir") + Constants.systemValueChrome);
		driver = new ChromeDriver();	
		
	}
	
	protected void initialiseExplicitWait() {
		wait = new WebDriverWait(driver, 30);
	}

}