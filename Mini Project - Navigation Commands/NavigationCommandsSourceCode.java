package sourceCode;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationCommandsSourceCode {

	public static void main(String[] args) throws IOException, InterruptedException {
		// IOException - for File Handling functionality
		// InterruptedException - for using Thread

		// TODO Auto-generated method stub

		// Initiating the Chrome driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Setting the base URL
		driver.get("https://www.google.com/");
		System.out.println("Opening the Google Chrome Landing Page...");

		// Locating the Google Search Text Box by class name
		WebElement googleSearchBar = driver.findElement(By.className("gLFyf"));
		googleSearchBar.sendKeys("Orange HRM demo");
		System.out.println("\nDisplaying the search results...");

		// Pressing the Enter key
		googleSearchBar.sendKeys(Keys.ENTER);
		System.out.println("\nEnter Key is pressed...");

		// Navigating to the previous tab
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("\nNavigating to previous page...");

		// Navigating to the next tab
		driver.navigate().forward();
		Thread.sleep(2000);
		System.out.println("\nNavigating to next page...");

		// Navigating to the Orange HRM Website
		driver.navigate().to("https://www.orangehrm.com/");
		System.out.println("\nNavigating to ORANGE HRM Home Page...");

		// Introducing Implicit Wait to provide time for the web elements to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("\nWaiting for the web elements to load within 10 seconds...");

		// Handling the pop-up using try-catch block
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CybotCookiebotDialog']")));
			WebElement popupAcceptButton = driver
					.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"));
			popupAcceptButton.click();
		} catch (Exception e) {

		}

		// Locating the Contact Sales button and clicking it
		WebElement contactSales = driver.findElement(By.linkText("Contact Sales"));
		contactSales.click();
		System.out.println("\nContact Sales button clicked...");

		// Locating the Full Name search box element and then sending the values into it
		WebElement fullName = driver.findElement(By.id("Form_getForm_FullName"));
		fullName.sendKeys("Vikram Rathode");

		// Locating the Phone Number text box element and then sending the values into
		// it
		WebElement phoneNumber = driver.findElement(By.id("Form_getForm_Contact"));
		phoneNumber.sendKeys("1234567890");

		// Locating the Job Title text box element and then sending the values into it
		WebElement jobTitle = driver.findElement(By.id("Form_getForm_JobTitle"));
		jobTitle.sendKeys("Fresher");

		// Locating the Country drop down menu element and then sending the values into
		// it
		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
		country.click();
		country.sendKeys("India");
		country.click();

		// Locating the Number of Employees down menu element and then sending the
		// values into it
		WebElement numberOfEmployees = driver.findElement(By.id("Form_getForm_NoOfEmployees"));
		numberOfEmployees.click();
		numberOfEmployees.sendKeys("11 - 15");
		numberOfEmployees.click();

		// Locating the Business email ID text box element and then sending the values
		// into it
		WebElement businessEmail = driver.findElement(By.id("Form_getForm_Email"));
		businessEmail.sendKeys("rathodeitsolutions.test@test.com");
		System.out.println("\nForm Fields filled... ");

		// Using the JS Executor to scroll down the window
		JavascriptExecutor jsExe = (JavascriptExecutor) driver;
		jsExe.executeScript("window.scrollBy(0,420)");
		System.out.println("\nreCAPTCHA is made visible by scrolling down a bit...  ");

		// In the buffer time of 20 seconds, completing the reCAPTCHA manually
		Thread.sleep(20000);

		// Clicking the "Contact Sales" button after completing the reCAPTCHA
		WebElement submitButton1 = driver.findElement(By.id("Form_getForm_action_submitForm"));
		submitButton1.click();
		System.out.println("\nContact Sales Button is clicked...  ");

		// Taking the Screenshot of the error message
		TakesScreenshot ts = ((TakesScreenshot) driver);

		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(
				"C:\\Users\\Nishchay Gupta\\eclipse-workspace\\Navigation-Commands\\Screenshots\\myscreenshot.png");

		FileUtils.copyFile(source, target);
		System.out.println("\nTaking the ScreenShot of the error message...  ");

		// It will raise the popup to "Enter the message"
		// Then entering the message manually
		System.out.println("\nThe message is being typed...");
		System.out.println("\nContact Sales Button is clicked again... ");
		WebElement submitButton2 = driver.findElement(By.id("Form_getForm_action_submitForm"));
		submitButton2.click();

		// A message will be shown - "Enter the valid business email ID"
		System.out.println("\nError message will be displayed...");

		// Closing the current window
		driver.close();

	}

}
