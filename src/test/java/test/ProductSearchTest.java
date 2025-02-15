package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.AddToCart;
import pom.AmazonHomePage;
import pom.LoginPage;
import pom.ProductDetailPage;
import utility.Reports;

public class ProductSearchTest extends BaseTest{
	
	@BeforeMethod
	public void OpenApplication() {
		 driver = Browser.launchApplication();
	}
	
	@Test
	public void VerifyIfLogInIsSuccessful() throws InterruptedException {
		test = reports.createTest("VerifyIfLogInIsSuccessful");
				
		loginPage = new LoginPage(driver);
		loginPage.ViewOnAccountandLista(driver);
		loginPage.clickOnSinginButton();
		loginPage.EnterYourMobileNumber("9340183455");
		loginPage.clickOnContinueButton();
		loginPage.EnterYourPassword("12345678@");
		loginPage.ClickOnSignInSubmitButtons();
		Assert.assertTrue(loginPage.isUserNameDisplayed());
   }
	
	@Test
	public void VerifyIfSearchResultCorrectly() {
		test = reports.createTest("VerifyIfSearchResultCorrectly");
		amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.EnterProductToSearch("iphone14");
		amazonHomePage.ClickOnSearchButton();
		Assert.assertTrue(amazonHomePage.iscorrectltNameDisplayed());
	}
	
	@Test
	public void VerifyThatOnlyRelevantProduct() {
		test = reports.createTest("VerifyThatOnlyRelevantProduct");
		amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.EnterProductToSearch("iphone14");
		amazonHomePage.ClickOnSearchButton();
		
		amazonHomePage.ClickOnApplyCheckBoxButton();
		amazonHomePage.filterApplyPriceRange(driver,50000,80000);
        Assert.assertTrue(amazonHomePage.isTotalItamNumberCount());
	}
	
	@Test
	public void verifyIfUserIsAbleToViewProductdetails () {
		test = reports.createTest("verifyIfUserIsAbleToViewProductdetails");
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.EnterProductToSearch("iphone14");
		amazonHomePage.ClickOnSearchButton();
		amazonHomePage.ClickOnApplyCheckBoxButton();
		
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.moveToDesiredProduct(driver, 1);
		productDetailPage.clickOnOptionSecond(1);
		
		switchToChildBrowser();
		
		Assert.assertTrue(productDetailPage.getProductPriceOnNewPage()); 
		Assert.assertTrue(productDetailPage.getProductTitleOnNewPage());
		Assert.assertTrue(productDetailPage.isAddToCartDisplayed());
	}
	
	@Test
	public void verifyIfCarCountIncreases() {
		test = reports.createTest("verifyIfCarCountIncreases");
		addToCart = new AddToCart(driver);
		addToCart.clickOnAddToCart();
		Assert.assertTrue(addToCart.isCartCountIncreaseDisplayed());
		
		addToCart.ClickOnProceedToBuy();
		addToCart.clickOnAddressButton();
		addToCart.clickOnSelectCountry();
		addToCart.enterSelectIndia();
		addToCart.enterFirstNameAndLastName("AkshayMahajan");
		addToCart.enterYourMobileNumber("9340183455");
		addToCart.enterYourPinCode("454775");
		addToCart.enterYourVillage("Manpur");
		addToCart.enterYourLandMark("apolloHospital");
		addToCart.enterYourCityName("Indore");
		addToCart.ClickSelectState();
		addToCart.clickYourStateName();
		addToCart.clickOnContinuesButton();
		Assert.assertTrue(addToCart.ispriceDisplayed());
		
	}
	
	@Test
	public void verifyIfLogInPage() {
		test = reports.createTest("verifyIfLogInPage");
		loginPage = new LoginPage(driver);
		loginPage.clickOnSingOutButton();
		Assert.assertTrue(loginPage.issignInbutton());
		
    }
	
	@AfterMethod
	public void CloseApplication() { 
		driver.close();
	}
	
	
	
	
	
	
	
	

}
