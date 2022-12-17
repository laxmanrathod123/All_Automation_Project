package RathodLuckyAcademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import RathodLuckyAcademy.TestComponents.BaseTest;
import RathodLuckyAcademy.pageObjects.CartPage;
import RathodLuckyAcademy.pageObjects.ProductCatelogue;

public class ErrorValidationTest extends BaseTest {
	
	@Test
	public void productErrorValidation() throws InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatelogue ProductCatelogue = landingpage.loginApplication("laxmanrathod2142@gmail.com", "Laxman@123");
		List<WebElement> products = ProductCatelogue.getProductList();
		ProductCatelogue.addProductToCart(productName);
		CartPage CartPage = ProductCatelogue.goToCartPage();
		boolean match = CartPage.VerifyProductDisplay("ZARA COAT 3");
		Assert.assertFalse(match);
	}

	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException {
		 
		String productName = "ZARA COAT 3";
		landingpage.loginApplication("laxmanrathod2142@gmail.com", "Laxman@3");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMethod());;
		
		
	}
	
}
