package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
WebDriver driver;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class=' nav-link']")WebElement MoreInfoContact;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")WebElement contactEditIcon;
	@FindBy(xpath="//input[@id='phone']")WebElement phoneUpdateTextBox;
	@FindBy(xpath="//input[@id='email']")WebElement emailUpdateTextBox;
	@FindBy(xpath="//textarea[@name='address']")WebElement addressUpdateTextBox;
	@FindBy(xpath="//textarea[@name='del_time']")WebElement deliveryTimeUpdateTextBox;
	@FindBy(xpath="//input[@id='del_limit']")WebElement deliveryChargeLimitUpdateTextBox;
	@FindBy(xpath="//button[@name='Update']")WebElement updateContactInfoButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlertBox;
	
	public ManageContactPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*public void clickManageContactMoreInfo() 
	{
		MoreInfoContact.click();
	}*/
	
	public ManageContactPage clickContactEditIcon() 
	{
		contactEditIcon.click();
		return this;
	}
	
	public ManageContactPage updatePhoneNumber(String phoneNumber) 
	{
		phoneUpdateTextBox.clear();
		phoneUpdateTextBox.sendKeys(phoneNumber);
		return this;
	}
	
	public ManageContactPage updateEmail(String email) 
	{
		emailUpdateTextBox.clear();
		emailUpdateTextBox.sendKeys(email);
		return this;
	}
	
	public ManageContactPage updateAddress(String address) 
	{
		addressUpdateTextBox.clear();
		addressUpdateTextBox.sendKeys(address);
		return this;
	}
	
	public ManageContactPage updateDeliveryTime(String time) 
	{
		deliveryTimeUpdateTextBox.clear();
		deliveryTimeUpdateTextBox.sendKeys(time);
		return this;
	}
	
	public ManageContactPage updateDeliveryChargeLimit(String chargeLimit) 
	{
		deliveryChargeLimitUpdateTextBox.clear();
		deliveryChargeLimitUpdateTextBox.sendKeys(String.valueOf(chargeLimit));
		return this;
	}
	
	public ManageContactPage clickUpdateContactInfoButton() 
	{
		PageUtility pageutlility = new PageUtility();
		pageutlility.javaScriptScrollToBottom(driver);
		pageutlility.javaScriptClick(driver, updateContactInfoButton);
		return this;	
	}
	
	public boolean isSuccessAlertDisplayed() 
	{
		return successAlertBox.isDisplayed();
	}
	
	
	
}