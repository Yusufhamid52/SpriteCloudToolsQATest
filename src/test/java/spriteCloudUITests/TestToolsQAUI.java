package spriteCloudUITests;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTestSetup;
import base.Constants;
import toolsQAPages.ToolsQAHomePage;
import toolsQAPages.TutorialsPage;

/**
 * @author yhamid This java class consists of tests on ToolsQA website. The test details can be found 
 * on the Sprite Cloud UI tests doc attached to this project. Please refer test case 2 and 3.
 *
 */
public class TestToolsQAUI extends BaseTestSetup {

	private ToolsQAHomePage toolsQaHomePage;
	private TutorialsPage tutorialsPage;
	
	@BeforeMethod
	public void beforeMethod() {
		toolsQaHomePage = PageFactory.initElements(driver, ToolsQAHomePage.class);
		tutorialsPage = PageFactory.initElements(driver, TutorialsPage.class);
	}
	
	/**
	 * @param url - passes the browser url to the tests directly from TestNG suite.
	 * @BeforeMethod - runs once before every test method. This java method navigates to the given url.
	 */
	@BeforeMethod
	@Parameters({ "ToolsQAURL" })
	public void setUpBrowser(@Optional(Constants.TOOLSQA_HOME_PAGE_URL) String url) {
		
		driver.get(url);
		test.log(Status.INFO, "The website "+url+" is loaded");
	}
	
	@Test
	public void testSearchTutorials() throws InterruptedException {
		toolsQaHomePage.clickAcceptCookieBanner();
		tutorialsPage.searchByTutorialName("Java Tutorial");
		tutorialsPage.verifyTutorialInSearchResults("Java Tutorial");
	}
	
	@Test
	public void testTutorialsTabMenu() throws InterruptedException {
		toolsQaHomePage.clickAcceptCookieBanner();
		tutorialsPage.clickOnTutorialsButton();
		tutorialsPage.checkEachMenuItemIsDisplayed();
	}
}
