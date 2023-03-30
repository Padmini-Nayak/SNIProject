package testPages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.CustomListener;
import reusableComponents.CommonConstants;
import reusableComponents.ExcelOperations;
import testBase.ObjectsRepo;
import testBase.TestBase;

@Listeners(CustomListener.class)
public class FacultyLogInThroughInstitute_Onboarding_Page_Test extends TestBase {

	String fileName = "//src//test//resources//testData//AllCredsLogins_TestData.xlsx";

	ExcelOperations excel_newInstitute = new ExcelOperations(fileName, "Onboard_New_Institute");
	

	@Test(dataProvider = "onboardNewInstitute", priority = 1)
	public void loginInstituteAfterOnboardRegistration(Object obj1) throws Exception {

		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		// Navigate to home page and click on sign in
		homepage.navigateHomepage_clickOnSignIn();

		// Log in as institute registered by Onaboarding
		String title = loginPage.logIn(testData);
		System.out.println("The Title is:" + title);

		// After logging in click on 'Faculty' form the side navigation bar
		instituteDashBoard.clickFacultyOnDashBoard();

		// Click on 'Create New faculty' button and enter the data to create a new
		// Faculty.
		instituteFaculty.createInstituteFaculty(testData);
		Thread.sleep(3000);
		// Logout
		instituteDashBoard.clickOnLogOut();
		System.out.println("Before after out");
		// Sign in again with the created faculty
		homepage.clickOnSignIn();

		loginPage.loginWithFacultyExcelData(testData);
		Thread.sleep(3000);
	}

	// Dataprovider method --> return object array
	@DataProvider(name = "onboardNewInstitute")
	public Object[][] testDataSupplier_onboardInstitute() throws Exception {
		Object[][] obj = new Object[excel_newInstitute.getRowCount()][1];
		for (int i = 1; i <= excel_newInstitute.getRowCount(); i++) {
			HashMap<String, String> testData = excel_newInstitute.getTestDataInMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;

	}

}
