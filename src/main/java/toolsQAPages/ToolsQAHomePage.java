package toolsQAPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTestSetup;

public class ToolsQAHomePage extends BaseTestSetup {

	@FindBy(xpath = "//*[@class='btn btn-primary-shadow btn-block']")
	public WebElement goToRegistrationButton;

	@FindBy(id = "advertisement-url")
	private WebElement startFreeTrial;

	@FindBy(xpath = "//*[@class='overlay']")
	private WebElement closeAdPopUp;

	@FindBy(id = "enroll-form")
	private WebElement registrationForm;

	@FindBy(id = "accept-cookie-policy")
	private WebElement acceptCookiePolicy;
	
	@FindBy(xpath= "//ul[@class='active']//li[@class='active']")
	private WebElement activeTutorial;

	public void clickGoToRegistrationButton() throws InterruptedException {
		if (goToRegistrationButton.isEnabled()) {
			goToRegistrationButton.click();
			
			log.info("Go to Registration button is clicked ");
			test.info("Go to Registration button is clicked ");
		}
	}

	public boolean isRegistrationFormPresent() {
		boolean form =  registrationForm.isDisplayed();
		if(form) {
			log.info("Registration form is displayed");
			test.info("Registration form is displayed");
		}
		
		return form;
	}

	public void clickAcceptCookieBanner() {
		if (wait.until(ExpectedConditions.visibilityOf(acceptCookiePolicy)).isDisplayed()) {
			acceptCookiePolicy.click();
			
			log.info("Cookies accepted");
			test.info("Cookies accepted");
		}
	}
	
}
