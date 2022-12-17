package RathodLuckyAcademy.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RathodLuckyAcademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);// purpose to initialise the webelement 
	}
	
	//WebElement username = driver.findElement(By.id("userEmail"));
    @FindBy(id="userEmail")
	WebElement username;
	
	//driver.findElement(By.id("userPassword"))
	@FindBy(id="userPassword")
	WebElement passwordele;
	
	//driver.findElement(By.xpath("//input[@name='login']"))
	@FindBy(xpath="//input[@name='login']")
	WebElement loginbtn;
	
	@FindBy(xpath ="//div[@role='alertdialog']")
	WebElement errroMessage;
	
	public ProductCatelogue loginApplication(String email,String password) {
		username.sendKeys(email);
		passwordele.sendKeys(password);
		loginbtn.click();
		ProductCatelogue ProductCatelogue= new ProductCatelogue(driver);
		return ProductCatelogue;
	}
	// This method is usefull for testing the feature in different environment like prod and test env.
	public void goTo() { 
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMethod() {
		waitForwebElementToAppear(errroMessage); 
		return errroMessage.getText();
	}
	

}
