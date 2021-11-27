package toolsQAPages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BaseTestSetup;


public class TutorialsPage extends BaseTestSetup {
	
	@FindBy(xpath = "//*[@class='navbar__tutorial-menu--text']")
	private WebElement tutorialButton;
	
	@FindBy(xpath = "//*[@class='icon-next']")
	private List<WebElement> tutorialSubTab;
	
	@FindBy(xpath = "//*[@class='second-generation']")
	private WebElement availableCoursesLink;
	
	@FindBy(xpath = "//*[@class='navbar__search--input']")
	private WebElement searchTab;
	
	@FindBy(xpath = "//*[@class='article__title']")
	private WebElement searchResultCourseTitle;
	
	
	public void searchByTutorialName(String tutorialName) {
		searchTab.sendKeys(tutorialName);
		searchTab.sendKeys(Keys.ENTER);
		
		log.info(String.format("Entered %s in the search tab", tutorialName));
		test.info(String.format("Entered %s in the search tab", tutorialName));
	}
	
	public void verifyTutorialInSearchResults(String tutorialTitle) {
		Assert.assertEquals(searchResultCourseTitle.getText(), tutorialTitle);
	}
	
	public void clickOnTutorialsButton() {
		tutorialButton.click();
	}
	
	public void checkEachMenuItemIsDisplayed() {
		Actions action = new Actions(driver);
		for(int i=0;i<tutorialSubTab.size();i++) {
			action.moveToElement(tutorialSubTab.get(i)).build().perform();
			availableCoursesLink.isDisplayed();
			
			log.info(String.format("Tutorial menu item %s is displayed", tutorialSubTab.get(i)));
			test.info(String.format("Tutorial menu item %s is displayed", tutorialSubTab.get(i)));
		}
	}
}
