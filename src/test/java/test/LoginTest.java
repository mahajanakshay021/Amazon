package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.AmazonHomePage;
import pom.AmazonResultPage;
import pom.LoginPage;
import pom.ProductDetailPage;
import utility.Reports;

public class LoginTest extends BaseTest {
	
	@BeforeMethod
	public void OpenApplication() {
		 driver = Browser.launchApplication();
	}
	
	
	
	
	@Test
	public void VerifyIfLogInIsSuccessful() {
	    loginPage = new LoginPage(driver);
		loginPage.ViewOnAccountandLista(driver);
		loginPage.clickOnSinginButton();
		loginPage.EnterYourMobileNumber("9340183455");
		loginPage.clickOnContinueButton();
		loginPage.EnterYourPassword("12345678@");
		loginPage.ClickOnSignInSubmitButtons();
		
		
		
	    amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.EnterProductToSearch("iphone14");
		amazonHomePage.ClickOnSearchButton();
		amazonHomePage.ClickOnApplyCheckBoxButton();
		
	    amazonResultPage = new AmazonResultPage(driver);
		amazonResultPage.moveToDesiredProduct(driver, 0);
		amazonResultPage.selectDesiredProduct(0);
		amazonResultPage.clickOnAddToCartButton();
	}
	
}
