package toolsQAPages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseTestSetup;

public class DemoQAHomePage extends BaseTestSetup {
	
	@FindBy(xpath = "//*[@class='home-banner']")
	private WebElement seleniumTrainingBanner;
	
	@FindBy(xpath = "//*[@class='card mt-4 top-card']")
	private List<WebElement> tutorialElement;
	
	@FindBy(xpath = "//*[@class='left-pannel']")
	private WebElement leftPanel;
	
	@FindBy(xpath = "//*[@class='col-12 mt-4 col-md-6']")
	private WebElement rightPanelMessage;
	
	public boolean isSeleniumTrainingBannerPresent() {
		boolean banner = seleniumTrainingBanner.isDisplayed();
		
		if(banner) {
			log.info("Selenium training banner is displayed");	
			test.info("Selenium training banner is displayed");
		}
		return banner;
		
	}

	public void clickJoinNow() {
		seleniumTrainingBanner.click();
		
		log.info("Selenium training banner clicked");
		test.info("Selenium training banner clicked");
	}
	
	public void verifyCourseMaterialTabsPresentAndVerifyText() {
		for (int i = 0; i < tutorialElement.size(); i++) {
			tutorialElement.get(i).click();
			
			log.info("Tutorial element clicked");
			test.info("Tutorial element clicked");
			
			Assert.assertTrue(leftPanel.isDisplayed());
			
			log.info("Left panel is displayed");
			test.info("Left panel is displayed");
			
			Assert.assertTrue(rightPanelMessage.isDisplayed());
			
			log.info("Right panel message is displayed");
			test.info("Right panel message is displayed");
			
			driver.navigate().back();
		}
	}
}
