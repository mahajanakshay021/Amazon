package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
	@FindBy(xpath="//html/body/div[2]/div/div/div[10]/div[8]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[37]/div[1]/span/span/span/span")private WebElement addToCart;
	@FindBy(xpath="//span[text()='Proceed to checkout (1 item)']")private WebElement cartCountIncrease;
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")private WebElement processToBuy;
	@FindBy(xpath="//a[@id='add-new-address-desktop-sasp-tango-link']")private WebElement clickAddress;
    @FindBy(xpath="(//span[@class='a-button-text a-declarative'])[1]")private WebElement selectcountry;
    @FindBy(xpath="(//a[text()='India'])[6] ")private WebElement India;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressFullName']")private WebElement firstNameAndLastNamw;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']")private WebElement mobileNumber;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']")private WebElement pinCode;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine1']")private WebElement enterFullAddress;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine2']")private WebElement village;
    @FindBy(xpath="//input[@id='address-ui-widgets-landmark']")private WebElement landMark;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressCity']")private WebElement enterCity;
    @FindBy(xpath="(//span[@class='a-button-text a-declarative'])[2]")private WebElement selectState;
    @FindBy(xpath="//a[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_19']")private WebElement stateName;
    @FindBy(xpath="(//input[@class='a-button-input'])[7]")private WebElement continues;
    @FindBy(xpath="//td[@class='a-color-base a-size-medium a-text-right grand-total-price aok-nowrap a-text-bold a-nowrap']")private WebElement price;
    
    
	public AddToCart(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddToCart() {
		addToCart.click();
	}
	
	public boolean isCartCountIncreaseDisplayed() {
		return cartCountIncrease.isDisplayed();
	}
	
	public void ClickOnProceedToBuy () {
		processToBuy.click();
	}
	
	public void clickOnAddressButton() {
		clickAddress.click();
	}
	
	public void clickOnSelectCountry() {
		selectcountry.click();
	}
	
	public void enterSelectIndia() {
		India.click();
	}
	
	public void enterFirstNameAndLastName(String name) {
		firstNameAndLastNamw.sendKeys(name);
	}
	
	public void enterYourMobileNumber(String Mobile) {
		mobileNumber.sendKeys(Mobile);
	}
	
    public void enterYourPinCode(String code) {
		pinCode.sendKeys(code);
	}

    public void enteryourFullAddress(String address) {
	enterFullAddress.sendKeys(address);
    }
    
    public void enterYourVillage(String Village) {
		village.sendKeys(Village);
		
	}
    
    public void enterYourLandMark(String Landmark) {
		landMark.sendKeys(Landmark);
	}
    
    public void enterYourCityName(String cityname) {
		enterCity.sendKeys(cityname);
	}
    
    public void ClickSelectState() {
		selectState.click();
	}
    
    public void clickYourStateName() {
		stateName.click();
	}
    
    public void clickOnContinuesButton() {
		continues.click();
	}
    
    public boolean ispriceDisplayed() {
		return price.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
