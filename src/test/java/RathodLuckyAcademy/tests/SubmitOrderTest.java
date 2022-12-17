package RathodLuckyAcademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RathodLuckyAcademy.TestComponents.BaseTest;
import RathodLuckyAcademy.pageObjects.CartPage;
import RathodLuckyAcademy.pageObjects.CheckOutpage;
import RathodLuckyAcademy.pageObjects.ConfirmationPage;
import RathodLuckyAcademy.pageObjects.LandingPage;
import RathodLuckyAcademy.pageObjects.Orderpage;
import RathodLuckyAcademy.pageObjects.ProductCatelogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	
	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData")
	public void submitOrder(HashMap<String ,String>input) throws IOException, InterruptedException {

		System.out.println("Program start");

		
		ProductCatelogue ProductCatelogue = landingpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = ProductCatelogue.getProductList();
		ProductCatelogue.addProductToCart(input.get("product"));
		CartPage CartPage = ProductCatelogue.goToCartPage();
		boolean match = CartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOutpage CheckOutpage = CartPage.goToCheckOut();
		CheckOutpage.SelectCountry("india");
		ConfirmationPage ConfirmationPage = CheckOutpage.submitOrder();
		Thread.sleep(3000);
		String confirmmessage = ConfirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(confirmmessage);
		
		Thread.sleep(1000);
		System.out.println("Program end");

	}

	/*
	 * @Test(dependsOnMethods = { "submitOrder" }) public void OrderHistoryTest() {
	 * 
	 * ProductCatelogue ProductCatelogue =
	 * landingpage.loginApplication("laxmanrathod2142@gmail.com", "Laxman@123");
	 * Orderpage Orderpage=ProductCatelogue.goToOrderPage();
	 * Assert.assertTrue(Orderpage.VerifyOrderDisplay(productName)); }
	 */ 
	

	@DataProvider
	public Object[][] getData() throws IOException {
		
		  HashMap<String ,String>map= new HashMap<String,String>(); map.put("email",
		  "laxmanrathod2142@gmail.com"); map.put("password","Laxman@123");
		  map.put("product", "ZARA COAT 3");
		  
		  HashMap<String,String>map1=new HashMap<String,String>(); map1.put("email",
		  "laxmanrathod2142@gmail.com"); map1.put("password","Laxman@123");
		  map1.put("product", "ADIDAS ORIGINAL");
		 
		
		//List<HashMap<String,String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\test\\java\\RathodLuckyAcademy\\data\\PurchaseOrder.json");
		
		//return new Object[][] {{data.get(0)},{data.get(1)}};
		return new Object[][] {{map},{map1}};
	}
	
}
