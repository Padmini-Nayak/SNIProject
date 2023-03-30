package testBase;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageObjects.CommonLoginPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.InstituteDashBoardPageObjects;
import pageObjects.InstituteOnBoardingRegistrationPageObjects;
import pageObjects.InstituteFacultyPageObjects;
import reusableComponents.CommonMethods;

public class ObjectsRepo {
	
	
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static HomePageObjects homepage;
	public static CommonLoginPageObjects loginPage;
	public static InstituteOnBoardingRegistrationPageObjects instOnboardRegistration;
	public static InstituteDashBoardPageObjects instituteDashBoard;
	public static InstituteFacultyPageObjects instituteFaculty;

	
	public CommonMethods commonMethods = new CommonMethods();
	
	
}
