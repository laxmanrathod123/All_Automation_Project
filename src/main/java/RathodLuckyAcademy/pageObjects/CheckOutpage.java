package RathodLuckyAcademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RathodLuckyAcademy.AbstractComponents.AbstractComponent;

public class CheckOutpage extends AbstractComponent{
   WebDriver driver;
	public CheckOutpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-last-of-type(1)")
	WebElement selectCountry;
	
	By results= By.cssSelector(".ta-results");
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submit;
	
	
	public void SelectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public ConfirmationPage submitOrder() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", submit);
		
		 return new ConfirmationPage(driver);
	}

}
