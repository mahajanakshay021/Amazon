package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class AmazonHomePage  {
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")private WebElement search;
	@FindBy(xpath="//input[@id='nav-search-submit-button']")private WebElement searchButtone;
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div/span/div/div[2]/div[3]/ul/span/span[1]/li/span/a/div/label/i")private WebElement applycheckBox;
	@FindBy(xpath="//input[@id='p_36/range-slider_slider-item_lower-bound-slider']")private WebElement minPriceSlider;
	@FindBy(xpath="//input[@id='p_36/range-slider_slider-item_upper-bound-slider']")private WebElement maxPriceSlider;
    @FindBy(xpath="//input[@aria-label='Go - Submit price range']")private WebElement goButton;
    @FindBy(xpath="(//input[@value='iphone 14'])[1]")private WebElement correctlyName;
    @FindBy(xpath="//span[text()='1-24 of 62 results for']")private WebElement relevantProduct;
    @FindBy(xpath="//span[text()='1-24 of 157 results for']")private WebElement totalItamNumberCount;
    
	public AmazonHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void EnterProductToSearch(String product) {
		search.sendKeys(product);
	}
	
	public void ClickOnSearchButton() {
		searchButtone.click();
	}
	
	public void ClickOnApplyCheckBoxButton() {
		applycheckBox.click();
	}
	
	public void filterApplyPriceRange(WebDriver driver, int targetMinPrice, int targetMaxPrice) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	   
	    int sliderMax = Integer.parseInt(
	        ((String) js.executeScript("return arguments[0].getAttribute('value')", maxPriceSlider))
	    );

	    
	    int currentMinPrice = Integer.parseInt(
	        ((String) js.executeScript("return arguments[0].getAttribute('aria-valuetext')", minPriceSlider))
	            .replaceAll("[^0-9]", "")
	    );
	    
	    int currentMaxPrice = Integer.parseInt(
	        ((String) js.executeScript("return arguments[0].getAttribute('aria-valuetext')", maxPriceSlider))
	            .replaceAll("[^0-9]", "")
	    );

	   
	    double minRatio = (double)(targetMinPrice - currentMinPrice) / (currentMaxPrice - currentMinPrice);
	    double maxRatio = (double)(targetMaxPrice - currentMinPrice) / (currentMaxPrice - currentMinPrice);

	    int minSliderPos = (int) Math.round(minRatio * sliderMax);
	    int maxSliderPos = (int) Math.round(maxRatio * sliderMax);

	    
	    minSliderPos = Math.max(0, Math.min(minSliderPos, sliderMax));
	    maxSliderPos = Math.max(0, Math.min(maxSliderPos, sliderMax));

	    
	    String setSliderScript = 
	        "arguments[0].value = arguments[1]; " +
	        "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); " +
	        "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));";

	    js.executeScript(setSliderScript, minPriceSlider, minSliderPos);
	    js.executeScript(setSliderScript, maxPriceSlider, maxSliderPos);

	}

	public void clickOnGoButtone() {
		goButton.click();
	}
	
	public boolean iscorrectltNameDisplayed() {
		return correctlyName.isDisplayed(); 
	}
	
	public boolean  isRelevantProductDisplayed() {
		return relevantProduct.isDisplayed();
	}
	
	public boolean isTotalItamNumberCount() {
		return totalItamNumberCount.isDisplayed();
	}
	
	
	
	
	
}
