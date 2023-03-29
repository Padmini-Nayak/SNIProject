package AdminModuleTestCase;

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
public class CommonLoginPage_Test extends TestBase {

	String fileName = "//src//test//resources//testData//AllCredsLogins_TestData.xlsx";

	String fileName_instituteFaculty = "//src//test//resources//testData//InstituteCreateFaculty_TestData.xlsx";

	ExcelOperations excel = new ExcelOperations(fileName, "AllRoleLogins");
	ExcelOperations excel_newInstitute = new ExcelOperations(fileName, "Onboard_New_Institute");

	ExcelOperations excel_instituteFaculty = new ExcelOperations(fileName, "Institute-Create-Faculty");

	@Test(dataProvider = "allLogin")
	public void login(Object obj1) throws Exception {
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		homepage.navigateHomepage_clickOnSignIn();
		String title = loginPage.logIn(testData);
		System.out.println("The Title is:" + title);
		WebElement logout = driver.findElement(By.partialLinkText("Log-Out"));
		logout.click();
	}

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
		String title2 = instituteFaculty.createInstituteFaculty(testData);
		Thread.sleep(3000);
		// Logout
		instituteDashBoard.clickOnLogOut();
		System.out.println("Before after out");
		// Sign in again with the created faculty
		homepage.clickOnSignIn();

		String title_Faculty = loginPage.loginWithFacultyExcelData(testData);
		Thread.sleep(3000);
	}

	/*
	 * @Test(dataProvider = "onboardNewInstiuteFaculty" , priority = 2) public void
	 * createInstituteFaculty(Object obj1) throws Exception {
	 * 
	 * //InstituteFacultyPage_Test instituteFacultyPage = new
	 * InstituteFacultyPage_Test();
	 * 
	 * HashMap<String, String> testData = (HashMap<String, String>) obj1;
	 * 
	 * instituteFaculty.createInstituteFaculty(testData);
	 * 
	 * //WebElement logout = driver.findElement(By.partialLinkText("Log-Out"));
	 * //logout.click(); }
	 */

	// Dataprovider method --> return object array
	@DataProvider(name = "allLogin")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;

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

	// Dataprovider method --> return object array
	@DataProvider(name = "onboardNewInstiuteFaculty")
	public Object[][] testDataSupplier_instituteFaculty() throws Exception {
		Object[][] obj = new Object[excel_instituteFaculty.getRowCount()][1];
		for (int i = 1; i <= excel_instituteFaculty.getRowCount(); i++) {
			HashMap<String, String> testData = excel_instituteFaculty.getTestDataInMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;

	}

}
