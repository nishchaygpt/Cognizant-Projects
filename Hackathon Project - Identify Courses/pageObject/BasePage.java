package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Author: Nishchay 

public class BasePage {
    protected WebDriver driver; //Initialize the driver
	
	// Constructor
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
