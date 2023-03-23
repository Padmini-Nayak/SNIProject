package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class instituteDashBoardPageObjects extends TestBase {

	@FindBy(xpath = "//p[contains(text(),'Faculty')]")
	WebElement faculty;

	public instituteDashBoardPageObjects() {
		PageFactory.initElements(driver, this);
	}

	// Click on Faculty from the side navigation bar in Institute dash board
	public void clickFacultyOnDashBoard() {
		faculty.click();
	}

}
