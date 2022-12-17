package RathodLuckyAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RathodLuckyAcademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver , this);
		
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productTitle;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	public boolean VerifyProductDisplay(String productName) {
		boolean match=productTitle.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutpage goToCheckOut() {
		checkoutEle.click();
		return new CheckOutpage(driver);
	}

}
