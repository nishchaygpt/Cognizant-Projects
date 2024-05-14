package utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import pageObject.BasePage;

public class ScreenShots extends BasePage {
	public ScreenShots(WebDriver driver) {
		super(driver);
	}

	//Whole Page Screenshot
	public String ScreenShot(String path) throws IOException {
		String p = System.getProperty("user.dir")+"\\screenshots\\";
		p+=path+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(p);
		FileUtils.copyFile(src, trg);
		return p;
	}

}
