package spriteCloudUITests;


import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import base.BaseTestSetup;
import base.Constants;
import toolsQAPages.DemoQAHomePage;
import toolsQAPages.ToolsQAHomePage;

/**
 * @author yhamid This java class consists of tests on Demo QA website. The test details can be found 
 * on the Sprite Cloud UI tests doc attached to this project. Please refer Test case 1.
 *
 */
public class TestDemoQAUI extends BaseTestSetup {

	private DemoQAHomePage demoQaHomePage;
	private ToolsQAHomePage toolsQaHomePage;
	
	@BeforeMethod
	public void beforeMethod() {
		demoQaHomePage = PageFactory.initElements(driver, DemoQAHomePage.class);
		toolsQaHomePage = PageFactory.initElements(driver, ToolsQAHomePage.class);
	}
	
	/**
	 * @param url - passes the browser url to the tests directly from TestNG suite.
	 * @BeforeMethod - runs once before every test method. This java method navigates to the given url.
	 */
	@BeforeMethod
	@Parameters({ "DemoQAURL" })
	public void setUpBrowser(@Optional(Constants.DEMOQA_HOME_PAGE_URL) String url) {
		
		driver.get(url);
		test.log(Status.INFO, "The website "+url+" is loaded");
	}
	
	@Test
	public void testRegistrationFormIsPresent() throws InterruptedException {
		demoQaHomePage.isSeleniumTrainingBannerPresent();
		demoQaHomePage.clickJoinNow();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
	    driver.close();
	    driver.switchTo().window(tabs.get(1));
		toolsQaHomePage.clickGoToRegistrationButton();
		Assert.assertTrue(toolsQaHomePage.isRegistrationFormPresent());
	}
	
//	@Test
//	public void testTutorialsTabs() {
//		demoQaHomePage.verifyCourseMaterialTabsPresentAndVerifyText();
//	}
}
