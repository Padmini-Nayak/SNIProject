package AdminModuleTestCase;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableComponents.CommonConstants;
import reusableComponents.ExcelOperations;
import testBase.ObjectsRepo;
import testBase.TestBase;

public class AllCredLoginPage_Test extends TestBase {

	String fileName = "//src//test//resources//testData//AllCredsLogins_TestData.xlsx";

	ExcelOperations excel = new ExcelOperations(fileName, "AllRoleLogins");

	@Test(dataProvider = "allLogin")
	public void login(Object obj1) throws Exception {
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		homepage.clickOnSignIn();
		String title = allCredLogPage.allCredLogin(testData);
		System.out.println("The Title is:" + title);
		WebElement logout = driver.findElement(By.partialLinkText("Log-Out"));
		logout.click();
	}

	@Test(dataProvider = "allLogin2")
	public void loginInstituteAfterOnboardRegistration(Object obj1) throws Exception {
		
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		if (testData.get(CommonConstants.TC_NAME).equalsIgnoreCase(CommonConstants.TC_INSTITUTE_LOGIN_AFTER_ONBOARDING)) {
			homepage.clickOnSignIn();
			String title = allCredLogPage.allCredLogin(testData);
			System.out.println("The Title is:" + title);
			//WebElement logout = driver.findElement(By.partialLinkText("Log-Out"));
			//logout.click();
		}else {
			System.out.println("No such column exists");
		}
	}

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
		@DataProvider(name = "allLogin2",parallel=false)
		public Object[][] testDataSupplier2() throws Exception {
			Object[][] obj = new Object[excel.getRowCount()][1];
			for (int i = 1; i <= excel.getRowCount(); i++) {
				HashMap<String, String> testData = excel.getTestDataInMap(i);
				obj[i - 1][0] = testData;
			}
			return obj;

		}
	


}
