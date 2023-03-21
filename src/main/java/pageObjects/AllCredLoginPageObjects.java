package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class AllCredLoginPageObjects extends TestBase {
	
	@FindBy(name = "LoginAs")
	WebElement LoginAs;
	
	@FindBy(name = "UserName")
	WebElement username;
	
	@FindBy(name = "Password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement Login;
	
	//constructor - to use initElement method
		public AllCredLoginPageObjects() {
			PageFactory.initElements(driver, this);
		}
		
	//For logging in to the SNI application with different roles
   public String allCredLogin(HashMap<String, String> testData) throws Exception {
			System.out.println(driver);
			//LoginAs.click();
			cm.selectDropdownOption(LoginAs, testData.get("Role").toString());
			username.sendKeys(testData.get("username").toString());
			password.sendKeys(testData.get("password").toString());
			System.out.println("The user name is "+testData.get("username").toString());
			System.out.println("The password is "+testData.get("password").toString());
			Login.click();
			return driver.getTitle();
		}
	
}
