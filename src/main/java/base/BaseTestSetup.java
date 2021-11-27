package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.commons.io.FileUtils;

/**
 * @author yhamid This java class consists of all settings that need to be done
 * before running a test i.e. setting the browser preferences and
 * creating and killing the driver.
 *
 */
public class BaseTestSetup extends WebDriverSetUp {

	protected static Logger log;

	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	protected static ExtentTest test;

	/**
	 * This method initializes different extent report objects defined above
	 */
	@BeforeSuite
	public void beforeSuite() {
		// extent report logic
		htmlReporter = new ExtentHtmlReporter(Constants.EXTENT_REPORT_PATH + System.currentTimeMillis() + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	/**
	 * @param ctx
	 * This method sets the extent report name, title and its theme.
	 */
	@BeforeTest
	public void beforeTest(ITestContext ctx) {
		// extent report logic

		htmlReporter.config().setReportName("Test Report" + ctx.getCurrentXmlTest().getSuite().getName());
		htmlReporter.config().setDocumentTitle("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	/**
	 * @BeforeMethod - runs once before every test method. This java method creates
	 *               the chrome driver instance and sets implicit and explicit waits.
	 */
	@BeforeMethod
	public void setUpDriver() {
		
		initializeDriver();	

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		log = Logger.getLogger("global");
		
		initialiseExplicitWait();
	}

	/**
	 * @param result
	 * This method creates entry in extent report for each test by their test method name
	 */
	@BeforeMethod
	public static void before(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	/**
	 * @param result
	 * @throws IOException
	 * @AfterMethod - runs once after every test method
	 * This method gets the failure message in extent report for failed and skipped tests. It also closes the browser and kills the driver instance.
	 */
	@AfterMethod
	public void getTestResultInExtentReport(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot()).build());
		}

		if (result.getStatus() == ITestResult.SKIP)
			test.skip(result.getThrowable().getMessage());

		extent.flush();
		driver.close();
	}

	/**
	 * @return
	 * This method takes screenshot when called and stores them at the specified path
	 */
	public String screenshot() {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destFile = Constants.SCREENSHOT_PATH + System.currentTimeMillis() + ".jpg";

		try {
			FileUtils.copyFile(srcFile, new File(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}

}