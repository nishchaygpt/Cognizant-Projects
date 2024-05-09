package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Author: Vishnu, Anshu

public class NewsPage extends BasePage {

	// Constructor
	public NewsPage(WebDriver driver) {
		super(driver);
	}

	// Web Elements

	// click on each news in a loop
	@FindBy(xpath = "//div[@class='z_a_91bed31b l_a_91bed31b']//a[@data-automation-id='newsItemTitle']")
	List<WebElement> eachNews;

	// News-Header
	@FindBy(xpath = "//div[@id='title_text']")
	WebElement txt_heading;

	@FindBy(xpath = "//*[@id='spPageCanvasContent']/div/div/div/div")
	WebElement txt_headingDetails;

	// Associate details hover
	@FindBy(xpath = "//*[@data-automation-id='authorByLine']/div")
	WebElement associateDetails;

	Actions action = new Actions(driver);

	// Storing HyperLinks present in the news content
	@FindBy(tagName = "a")
	List<WebElement> hyperlink;

	// Share-Button
	@FindBy(xpath = "//button[@data-automation-id='shareButton']")
	WebElement sharebtn;

	// Extracting the Share-Options present in the Share button
	@FindBy(xpath = "//span[text()='Share page']/ancestor::ul")
	WebElement shareOptions;

	// Scrolling to the lower part of the Body using scrollIntoView(true) to capture total likes and views
	@FindBy(xpath = "//div[@class='fw_aa_9f38462c fw_ap_9f38462c mx_ap_9f38462c']")
	WebElement scrollbody;

	// Total-Likes
	@FindBy(xpath = "//*[@id='vpc_Page.CommentsWrapper.internal.2610b4b4-550c-4548-b431-aa3ab709c184']/div/div/aside/div[1]/button/span/span/span")
	WebElement totalLikes;

	// Total-Views
	@FindBy(xpath = "//*[@id='vpc_Page.CommentsWrapper.internal.2610b4b4-550c-4548-b431-aa3ab709c184']/div/div/aside/div[4]/button/span/span/span")
	WebElement totalViews;

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	// Action Methods

	//number of news captured
	public int newsSize() {
		return eachNews.size();
	}

	public void clickEachNews(int newsno) {
		eachNews.get(newsno).click();
	}

	//printing the headline and the news content
	public void showNewsDetails() throws InterruptedException {
		System.out.println("Headling:  " + txt_heading.getText());
		System.out.println("Details:   " + txt_headingDetails.getText());
		System.out.println();
	}

	//hovering on the news author's profile
	public void associateDetails() {
		action.moveToElement(associateDetails).perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_6sw9u lcpUo kc69i']")));
	}

	//printing the number of valid and invalid hyperlinks present in the news content
	public void hyperlinkValidation() {
		int validLinks = 0;
		int invalidLinks = 0;
		for (WebElement link : hyperlink) {
			String url = link.getAttribute("href");

			if (url == null || url.isEmpty()) {
				invalidLinks++;
				System.out.println(url);

			} else {
				validLinks++;
				System.out.println(url);
			}
		}

		System.out.println("Number of valid hyperlinks : " + validLinks);
		System.out.println("Number of invalid hyperlinks : " + invalidLinks);

		System.out.println();
	}

	//clicking and printing the share button options list
	public void shareBtnOptions() throws InterruptedException {
		sharebtn.click();
		Thread.sleep(1000);

		System.out.println(shareOptions.getText());
		System.out.println();
	}

	// scroll down and fetch likes and views
	public void likesAndViews() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//*[@id='CommentsWrapper']"));
		jse.executeScript("arguments[0].scrollIntoView();", ele);
		Thread.sleep(3000);

		System.out.println("Number of Likes: " + totalLikes.getText().split(" ")[0]);
		System.out.println("Number of Views : " + totalViews.getText().split(" ")[0]);
		System.out.println();
		Thread.sleep(3000);

		driver.navigate().back();

	}

}
