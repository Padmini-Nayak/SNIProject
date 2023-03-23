package pageObjects;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.CommonConstants;
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

	@FindBy(xpath = "//input[@type = 'submit' and @value='Register']")
	WebElement instituteRegister;

	// constructor - to use init method for page objects (Page Factory)
	public InstituteOnBoardingRegistrationPageObjects() {
		PageFactory.initElements(driver, this);
	}

	// Institute Registration through on boarding
	public String instituteOnBoardingRegistration(HashMap<String, String> testData) throws Exception {
		System.out.println(driver);
		
		// Start entering the registration page
		instituteName.sendKeys(testData.get(CommonConstants.FULL_NAME).toString());
		instituteMailId.sendKeys(testData.get(CommonConstants.EMAIL).toString());
		instituteContactNumber.sendKeys(testData.get(CommonConstants.PHONE_NUMBER).toString());
		instituteMailingAddress.sendKeys(testData.get(CommonConstants.MAILING_ADDRESS).toString());

		// using CommonMethod class object to get the drop down element
		commonMethods.selectDropdownOption(instituteStateElement, testData.get(CommonConstants.STATE).toString());
		commonMethods.selectDropdownOption(instituteCityElement, testData.get(CommonConstants.CITY).toString());
		
		
		commonMethods.selectFileUpLoad(instituteFileUpload, testData.get(CommonConstants.FILE_UPLOAD).toString(),driver);
		
		Thread.sleep(5000);
		institutePassword.sendKeys(testData.get(CommonConstants.PASSWORD_Institute).toString());
		instituteConfirmPassword.sendKeys(testData.get(CommonConstants.CONFIRM_PASSWORD_Institute).toString());

		System.out.println("The institute name is " + testData.get(CommonConstants.FULL_NAME).toString());
		System.out.println("The institute email is " + testData.get(CommonConstants.EMAIL).toString());
		
		instituteRegister.click();

		return driver.getTitle();
	}

}
