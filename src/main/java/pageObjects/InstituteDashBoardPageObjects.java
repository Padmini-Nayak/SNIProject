package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class InstituteDashBoardPageObjects extends TestBase {

	@FindBy(xpath = "//p[contains(text(),'Faculty')]")
	WebElement faculty;

	// Log Out
	@FindBy(xpath = "//p[contains(text(),'Log-Out')]")
	WebElement logout;

	public InstituteDashBoardPageObjects() {
		PageFactory.initElements(driver, this);
	}

	// Click on Faculty from the side navigation bar in Institute dash board
	public void clickFacultyOnDashBoard() {
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.visibilityOf(faculty));
		 */

		faculty.click();
	}

	// click on log out
	public void clickOnLogOut() throws InterruptedException {

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
		 */
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", logout);
		// logout.click();
	}

}
