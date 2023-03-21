package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.AllCredLoginPageObjects;
import pageObjects.InstituteOnBoardingRegistrationPageObjects;
import pageObjects.LoginPageObjects;
//import pageObjects.SelectPriceOptionsPageObjects;
import reusableComponents.CommonMethods;

public class ObjectsRepo {
	
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static LoginPageObjects homepage;
	public static AllCredLoginPageObjects allCredLogPage;
	public static InstituteOnBoardingRegistrationPageObjects instOnboardRegistration;
	public CommonMethods cm = new CommonMethods();
}
