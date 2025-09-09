package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	WebDriver driver;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement moreInfoLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")WebElement editIcon;
	@FindBy(xpath="//textarea[@id='content']")WebElement addressTextBox;
	@FindBy(xpath="//input[@id='email']")WebElement emailTextBox;
	@FindBy(xpath="//input[@id='phone']")WebElement phoneTextBox;
	@FindBy(xpath="//button[@type='submit']")WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlertBox;
	
	public ManageFooterTextPage(WebDriver driver) 
		{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public ManageFooterTextPage ClickManageFooterTextMoreInfo()
		{
		moreInfoLink.click();
		return this;
		}
	
	public ManageFooterTextPage clickEditIcon() 
		{
		editIcon.click();
		return this;
		}
	
	public ManageFooterTextPage enterAddress(String address) 
		{
		addressTextBox.clear();
		addressTextBox.sendKeys(address);
		return this;
		}
	
	public ManageFooterTextPage enterEmail(String email) 
		{
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		return this;
		}
	
	public ManageFooterTextPage enterPhone(String phone) 
		{
		phoneTextBox.clear();
		phoneTextBox.sendKeys(phone);
		return this;
		}
	
	public ManageFooterTextPage clickUpdateButton() 
		{
		updateButton.click();
		return this;
		}
	
	public boolean isSuccessAlertDisplayed() 
		{
		return successAlertBox.isDisplayed();
		}
	
}