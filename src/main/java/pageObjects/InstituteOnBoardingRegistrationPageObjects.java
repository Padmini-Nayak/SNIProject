package pageObjects;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class InstituteOnBoardingRegistrationPageObjects extends TestBase {

	@FindBy(id = "institutename")
	WebElement instituteName;

	@FindBy(id = "InstMailid")
	WebElement instituteMailId;

	@FindBy(id = "InstcontactNumber")
	WebElement instituteContactNumber;

	@FindBy(id = "InstMallingAddress")
	WebElement instituteMailingAddress;

	@FindBy(id = "statelist")
	WebElement instituteStateElement;

	@FindBy(id = "citylist")
	WebElement instituteCityElement;

	@FindBy(id = "InstPhoto")
	WebElement instituteFileUpload;

	@FindBy(id = "Password")
	WebElement institutePassword;

	@FindBy(id = "ConfirmPassword")
	WebElement instituteConfirmPassword;

	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement instituteRegister;

	// constructor - to use init method for page objects (Page Factory)
	public InstituteOnBoardingRegistrationPageObjects() {
		PageFactory.initElements(driver, this);
	}

	// Institute Registration through on boarding
	public String instituteOnBoardingRegistration(HashMap<String, String> testData) throws Exception {
		System.out.println(driver);
		
		// Start entering the registration page
		instituteName.sendKeys(testData.get("FullName").toString());
		instituteMailId.sendKeys(testData.get("Email").toString());
		instituteContactNumber.sendKeys(testData.get("PhoneNumber").toString());
		instituteMailingAddress.sendKeys(testData.get("MailingAddress").toString());

		// using CommonMethod class object to get the drop down element
		cm.selectDropdownOption(instituteStateElement, testData.get("State").toString());
		cm.selectDropdownOption(instituteCityElement, testData.get("City").toString());
		
		
		cm.selectFileUpLoad(instituteFileUpload, testData.get("FileUpload").toString(),driver);
		
		Thread.sleep(5000);
		institutePassword.sendKeys(testData.get("Password").toString());
		instituteConfirmPassword.sendKeys(testData.get("ConfirmPassword").toString());

		System.out.println("The institute name is " + testData.get("FullName").toString());
		System.out.println("The institute iemail is " + testData.get("Email").toString());

		return driver.getTitle();
	}

}
