package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.CommonConstants;
import testBase.TestBase;

public class InstituteFacultyPageObjects extends TestBase {

	@FindBy(id = "UploadNewFaculty")
	WebElement createNewFaculty;
	
	@FindBy(id="UserName")
	WebElement create_userName;
	
	@FindBy(id="Subject")
	WebElement create_subject;
	
	@FindBy(id="Email")
	WebElement create_email;
	
	@FindBy(id="PhoneNumber")
	WebElement create_phoneNumber;
	
	@FindBy(id="address")
	WebElement create_address;
	
	@FindBy(id="biograpghy")
	WebElement create_bioGraphy;
	
	@FindBy(id="Occupation")
	WebElement create_occupation;
	
	@FindBy(id="Password")
	WebElement create_password;
	
	@FindBy(id="ConfirmPassword")
	WebElement create_confirmPassword;
	
	//Create faculty button on the pop-up
	@FindBy(xpath="//body/div[2]/section[1]/div[4]/div[1]/div[1]/div[1]/div[2]/form[1]/div[10]/div[1]/button[1]")
	WebElement createNewFacultyInThePopUp;

	public InstituteFacultyPageObjects() {
		PageFactory.initElements(driver, this);
	}

	// Click on create new Faculty button in Institute-->Faculty
	public void clickCreateNewFaculty() {
		createNewFaculty.click();
	}
	
	//Create new faculty in the Institute log in 
		public String instituteOnBoardingRegistration(HashMap<String, String> testData) throws Exception {
			System.out.println(driver);
			
			// Start entering the registration page
			create_userName.sendKeys(testData.get(CommonConstants.INSTITUTE_FACULTY_USER_NAME).toString());
			
			// using CommonMethod class object to get the drop down element
			commonMethods.selectDropdownOption(create_subject, testData.get(CommonConstants.INSTITUTE_FACULTY_SUBJECT).toString());
			
			create_email.sendKeys(testData.get(CommonConstants.INSTITUTE_FACULTY_EMAIL).toString());
						
			create_phoneNumber.sendKeys(testData.get(CommonConstants.INSTITUTE_FACULTY_PHONE_NUMBER).toString());
			create_address.sendKeys(testData.get(CommonConstants.INSTITUTE_FACULTY_ADDRESS).toString());

			create_bioGraphy.sendKeys(testData.get(CommonConstants.INSTITUTE_FACULTY_BIOGRAPHY).toString());
			create_occupation.sendKeys(testData.get(CommonConstants.INSTITUTE_FACULTY_OCCUPATION).toString());

			System.out.println("The institute name is " + testData.get(CommonConstants.INSTITUTE_FACULTY_USER_NAME).toString());
			System.out.println("The institute email is " + testData.get(CommonConstants.INSTITUTE_FACULTY_EMAIL).toString());
			
			createNewFacultyInThePopUp.click();

			return driver.getTitle();
		} 

}
