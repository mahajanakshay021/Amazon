package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//a[@id='nav-link-accountList']")private WebElement accountAndLists;
	@FindBy(xpath="(//span[text()='Sign in'])[1]")private WebElement signIn;
	@FindBy(xpath="//input[@id='ap_email']")private WebElement mobileNumber;
	@FindBy(xpath="//input[@id='continue']")private WebElement continues;
	@FindBy(xpath="//input[@id='ap_password']")private WebElement password;
	@FindBy(xpath="//input[@id='signInSubmit']")private WebElement signInSubmit;
	@FindBy(xpath="//span[text()='Hello, Akshay']")private WebElement text;
	@FindBy(xpath="//span[text()='Hello, Akshay']")private WebElement userName;
	@FindBy(xpath="//span[text()='Sign Out']")private WebElement signOut ;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ViewOnAccountandLista(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(accountAndLists);
		actions.perform();
	}
	
	public void clickOnSinginButton() {
		signIn.click();
	}
	
	public void clickOnSingOutButton() {
		signOut.click();
	}
	
	public void EnterYourMobileNumber(String Email) {
		mobileNumber.sendKeys(Email);
	}
	
	public void clickOnContinueButton() {
		continues.click();
	}
	
	public void EnterYourPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void ClickOnSignInSubmitButtons() {
		signInSubmit.click();
	}
	
	public boolean isUserNameDisplayed() {
		return userName.isDisplayed();
	}
	
	public boolean issignInbutton() {
		return signOut.isDisplayed(); 
	}
}
