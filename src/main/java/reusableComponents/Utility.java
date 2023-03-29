package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBase.TestBase;

public class Utility extends TestBase{
	
	public static void takeScreenShot() {
    
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			//Using the time date timestamp to create unique file name for the each screenshot
			FileUtils.copyFile(srcFile, new File("C:\\Users\\shirv\\git\\SNI-Automation-Project\\screenshots\\"+timestamp()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
