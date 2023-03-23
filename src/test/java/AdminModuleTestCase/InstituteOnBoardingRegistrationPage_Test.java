package AdminModuleTestCase;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class InstituteOnBoardingRegistrationPage_Test extends TestBase {
	
	String fileName = "//src//test//resources//testData//InstituteOnBoardingRegistration_TestData.xlsx";
	ExcelOperations excel = new ExcelOperations(fileName,"institute-onboard-registration");

	@Test (dataProvider = "instituteOnboardRegistration")
	public void instituteonBoardRegistration(Object obj1) throws Exception {
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		homepage.clickOnOnboardingInstitue();
		String title = instOnboardRegistration.instituteOnBoardingRegistration(testData);
		System.out.println("The Title is:" + title);
		
	}
	
	
	//Dataprovider method --> return object array
	@DataProvider (name = "instituteOnboardRegistration")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i-1][0] = testData;
		}
		return obj;
		
	}
	

}
