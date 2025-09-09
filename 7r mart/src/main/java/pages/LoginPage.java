package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(css="input.form-control[placeholder='Username']")WebElement username;
	@FindBy(css="input.form-control[placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")WebElement loginButton;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alertBox;
	
	
		//constructor to initialize the WebDriver and PageFactory elements
	public LoginPage(WebDriver driver) 
		{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	public LoginPage enterUsername(String loginUserName) 
		{
		username.sendKeys(loginUserName);
		return this;						
		}
	
	public LoginPage enterPassword(String loginPassword) 
		{
		password.sendKeys(loginPassword);
		return this;
		}
	
	public LogoutPage signin()
		{
		loginButton.click();
		return new LogoutPage(driver);
		}
	
	public boolean isHomePageDisplayed( ) 
		{
		return dashboard.isDisplayed();
		}
	
	public boolean isAlertDisplayed()
		{
		return alertBox.isDisplayed();
		}

}
