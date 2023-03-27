package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.AllCredLoginPageObjects;
import pageObjects.InstituteDashBoardPageObjects;
import pageObjects.InstituteFacultyPageObjects;
import pageObjects.InstituteOnBoardingRegistrationPageObjects;
import pageObjects.LoginPageObjects;
import reusableComponents.CommonConstants;
import reusableComponents.CommonMethods;

public class ObjectsRepo {
	
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static LoginPageObjects homepage;
	public static AllCredLoginPageObjects allCredLogPage;
	public static InstituteOnBoardingRegistrationPageObjects instOnboardRegistration;
	public static InstituteDashBoardPageObjects instituteDashBoard;
	public static InstituteFacultyPageObjects instituteFaculty;
	
	public CommonMethods commonMethods = new CommonMethods();
	
	
}
