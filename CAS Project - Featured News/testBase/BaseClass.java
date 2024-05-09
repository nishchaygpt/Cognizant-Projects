package testBase;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//Base class, checking for the cross-browser compatibility
//Author: Nishchay

public class BaseClass {
	public static WebDriver driver;
	public int choice;
	Scanner sc;

	@BeforeSuite
	public void setup() throws IOException {
		sc = new Scanner(System.in);

		// choosing browser
		System.out.println("Press 1 : Chrome ");
		System.out.println("Press 2 : Edge ");
		System.out.println("Press 3 : Exit ");
		choice = sc.nextInt();

		// Switch Case to Choose the browser as per choice 
		switch (choice) {
		case 1:
			driver = new ChromeDriver(); // Launch Chrome
			break;
		case 2:
			driver = new EdgeDriver(); // Launch Edge
			break;
		case 3:
			System.out.println("Program Closed");
			System.exit(0);
			break;
		default:
			System.out.println("Please Select the correct choice");
			System.exit(0);
		}

		driver.manage().window().maximize();
		driver.get("https://be.cognizant.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	// Quit the browser
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
