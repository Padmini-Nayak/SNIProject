package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LoginPageObjects extends TestBase {
	//only page objects + respective methods
	
	@FindBy(xpath = "//a[@class='sign-in-btn']")
	WebElement sign_in;
	
	@FindBy(id="showDetails")
	WebElement show_details;
	
	@FindBy(xpath ="//a[@class ='link-foreground']")
	WebElement wish;
	
	
	@FindBy(id ="details-button")
	WebElement Advanced;
	
	@FindBy(id = "proceed-link" )
	WebElement Proceed;
	
	//On boarding
	@FindBy(xpath="//button[text()=\"Onboarding\"]")
	WebElement clickOnboarding;
	
	//On boarding - Institute
	@FindBy(xpath="//a[text()=\"Institutions \"]")
	WebElement clickInstitutions;
	
	
	
	//constructor - to use initElement method
	public LoginPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
		//Navigating to Home page
		public void homePage() throws InterruptedException {
			System.out.println(driver);
			Advanced.click();
		    Proceed.click();	
		    Thread.sleep(5000);
		    
		}
	
	//Navigating to to go to Home page and clicking on sign in
	public void clickOnSignIn() throws InterruptedException {
		this.homePage();	
	    sign_in.click();	    
	}
	
	//Navigating to Home Page and clicking on On boarding
		public void clickOnOnboarding() throws InterruptedException {
			System.out.println(driver);
			this.homePage();	
		    //On home page click on On boarding followed by institutions
			clickOnboarding.click();
			clickInstitutions.click();   
		}
}
