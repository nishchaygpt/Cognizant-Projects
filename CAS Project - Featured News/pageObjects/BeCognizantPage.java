package PageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Using the Page Factory Approach to optimize the code and append findElement automatically to locate the web element
//Author: Nishchay

public class BeCognizantPage extends BasePage {

	// Constructor
	public BeCognizantPage(WebDriver driver) {
		super(driver);
	}

	// Web Elements-----------------------------------------------------------------------
	// profile

	@FindBy(id = "O365_MainLink_MePhoto")
	WebElement profile;

	// news header
	@FindBy(xpath = "//div[@class='z_a_91bed31b l_a_91bed31b']//a[@data-automation-id='newsItemTitle']")
	List<WebElement> list_news;

	// Action Methods

	// click On User-Info-button
	public void ClickOnProfile() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("O365_MainLink_MePhoto")));

		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='O365_MainLink_Settings']/div"))));
		Thread.sleep(2000);
		profile.click(); // after clicking, we are capturing the ScreenShot
	}

	// Extracting the list of visible news and printing news headline & tool-tip
	public void newsHeaderVisibility() throws InterruptedException {
		Thread.sleep(3000);
		for (WebElement e : list_news) {
			System.out.println("News Headline: " + e.getText());
			System.out.println("Tooltip: " + e.getAttribute("title"));
		}
		System.out.println();

	}

}
