package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage{
	@FindBy(xpath = "//div[@role='listitem']")private List<WebElement> products;
	@FindBy(xpath="//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']")private List<WebElement> clickProduct;
	@FindBy(xpath = "/html/body/div[2]/div/div/div[13]/div[3]/div/h1/span")private WebElement productTitleOnNewPage;
	@FindBy(xpath = "/html/body/div[2]/div/div/div[13]/div[17]/div/div/div[5]/div[1]/span[3]")private WebElement productPriseOnNewPage;
	@FindBy(xpath="button[@id='a-autoid-1-announce']")private WebElement addTocart;
	
	public ProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void moveToDesiredProduct(WebDriver driver, int index) {
		Actions actions = new Actions(driver);
		actions.moveToElement(products.get(index)).perform();
	}
	
	public void clickOnOptionSecond(int index) {
		clickProduct.get(index).click();
	}
	
	public boolean getProductPriceOnNewPage() {
		String[] price = productPriseOnNewPage.getText().split(" ");
		return Boolean.parseBoolean(removeCommaFromString( price[0]));
	}
	
	public String getProductTitleOnNewPage() {
		return productTitleOnNewPage.getText();
	}
	
	
	public String isAddToCartDisplayed() {
		return addTocart.getText(); 
	}
}
