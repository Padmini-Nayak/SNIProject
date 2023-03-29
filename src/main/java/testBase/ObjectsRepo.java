package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.CommonLoginPageObjects;
import pageObjects.InstituteDashBoardPageObjects;
import pageObjects.InstituteFacultyPageObjects;
import pageObjects.InstituteOnBoardingRegistrationPageObjects;
import pageObjects.HomePageObjects;
import reusableComponents.CommonConstants;
import reusableComponents.CommonMethods;

public class ObjectsRepo {
	
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static HomePageObjects homepage;
	public static CommonLoginPageObjects loginPage;
	public static InstituteOnBoardingRegistrationPageObjects instOnboardRegistration;
	public static InstituteDashBoardPageObjects instituteDashBoard;
	public static InstituteFacultyPageObjects instituteFaculty;
	
	public CommonMethods commonMethods = new CommonMethods();
	
	
}
