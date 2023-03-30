package AdminModuleTestCase;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class InstituteFacultyPage_Test extends TestBase{
	
	String fileName = "//src//test//resources//testData//InstituteCreateFaculty_TestData.xlsx";

	ExcelOperations excel = new ExcelOperations(fileName, "Institute-Create-Faculty");
	
	@Test(dataProvider = "createInstituteFaculty")
	public void createInstituteFaculty(Object obj1) throws Exception {
		HashMap<String, String> testdata = (HashMap<String, String>) obj1;
		String title = instituteFaculty.createInstituteFaculty(testdata);
		
	}
	
	// Dataprovider method --> return object array
		@DataProvider(name = "createInstituteFaculty")
		public Object[][] testDataSupplier() throws Exception {
			Object[][] obj = new Object[excel.getRowCount()][1];
			for (int i = 1; i <= excel.getRowCount(); i++) {
				HashMap<String, String> testData = excel.getTestDataInMap(i);
				obj[i - 1][0] = testData;
			}
			return obj;

		}

}
