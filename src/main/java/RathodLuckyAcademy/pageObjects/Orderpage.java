package RathodLuckyAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RathodLuckyAcademy.AbstractComponents.AbstractComponent;

public class Orderpage extends AbstractComponent {
	WebDriver driver;
	public Orderpage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver , this);
		
	}
	
	
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> OrderProductName;
	
	public boolean VerifyOrderDisplay(String productName) {
		boolean match=OrderProductName.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	
}
