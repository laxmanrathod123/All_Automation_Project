package RathodLuckyAcademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RathodLuckyAcademy.pageObjects.CartPage;
import RathodLuckyAcademy.pageObjects.Orderpage;

public class AbstractComponent {

	
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	//driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement myorderHeader;
	
	
	public void waitForwebElementToAppear(WebElement FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
	
	public void waitForElementToAppear(By FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage CartPage= new CartPage(driver);
		return CartPage;
		
	}
	
	public Orderpage goToOrderPage() {
		myorderHeader.click();
		Orderpage orderpage= new Orderpage(driver);
		return orderpage;
		
	}
}
