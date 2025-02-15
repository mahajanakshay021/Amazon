package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pom.AddToCart;
import pom.AmazonHomePage;
import pom.AmazonResultPage;
import pom.LoginPage;
import pom.ProductDetailPage;

public class BaseTest {
	
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;

	public void switchToChildBrowser(){
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> i = handles.iterator();
		
		driver.switchTo().window(i.next());
		driver.switchTo().window(i.next());
	}
	
	public static AmazonHomePage amazonHomePage;
	public static AmazonResultPage amazonResultPage;
	public static ProductDetailPage productDetailPage;
	public static LoginPage loginPage;
	public static AddToCart addToCart;
	
}
