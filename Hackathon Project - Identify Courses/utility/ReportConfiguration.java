package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//Author: Sangam

//ExtentReport is an HTML reporting library 
//Can be integrated with Selenium WebDriver

public class ReportConfiguration implements ITestListener

{

	public ExtentSparkReporter sparkReporter; // defines the UI of the report
	public ExtentReports extent; // used populate common information on the report in the form of table
	public ExtentTest test; // creating test case entries in the report and update status of the test methods

	//sets the document title, report name,theme, attaches the sparkReporter to extent, 
	//sets system information
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/IdentifyCoursesReport.html");// specify location of the report
		sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Identify Courses");
		extent.setSystemInfo("Environment", "QEA:SDET");
		extent.setSystemInfo("Tester Name", "Vishnu, Anshu, Nishchay, Sangam");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser name", "Chrome,Firefox,Edge");
	}

	//called when a test case passes
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // create a new enty in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		test.addScreenCaptureFromPath("C:\\Users\\2317557\\eclipse-workspace\\CAS\\screenShot\\" + result.getName() + ".png");

	}

	//called when a test case fails
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
	}

	//called when a test case skipped
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
	}

	//push or prints the test information on to the report
	//when called again, it overwrite the previous information with the latest information
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
