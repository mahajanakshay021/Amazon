package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonResultPage {
	@FindBy(xpath="//div[@role='listitem']")private List<WebElement> products;
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[2]/div/div/div[1]/a/h2/span")private List<WebElement> productTitle;
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]")private List<WebElement> offerPrice ;
	@FindBy(xpath="//button[@id='a-autoid-1-announce']")private WebElement addToCart;
	
	public AmazonResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    public void moveToDesiredProduct(WebDriver driver,int index) {
    	Actions actions = new Actions(driver);
    	actions.moveToElement(products.get(index));
    	actions.perform();	
    }

	public void selectDesiredProduct(int index) {
		products.get(index).click();
	}

	public String getProductTitle(int index) {
		return productTitle.get(index).getText();
	}

	public String getProductPrice(int index) {
		return offerPrice.get(index).getText();
	}
	
	public void clickOnAddToCartButton() {
		clickOnAddToCartButton();
	}
}
