package testPages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class LoginPage_Tests extends TestBase{

	String fileName = "//src//test//resources//testData//AllCredsLogins_TestData.xlsx";
	ExcelOperations excel = new ExcelOperations(fileName, "AllRoleLogins");
	
	@Test(dataProvider = "allLogin")
	public void login(Object obj1) throws Exception {
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		homepage.navigateHomepage_clickOnSignIn();
		String title = loginPage.logIn(testData);
		System.out.println("The Title is:" + title);
		WebElement logout = driver.findElement(By.partialLinkText("Log-Out"));
		logout.click();
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
}
