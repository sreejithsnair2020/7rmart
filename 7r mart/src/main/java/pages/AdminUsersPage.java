package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;

public class AdminUsersPage
{

//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement addAdminLink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement addNewAdminButton;
	@FindBy(xpath="//input[@name='username']")WebElement addNewAdminTextBox;
	@FindBy(xpath="//input[@name='password']")WebElement passwordTextBoxAdmin;
	@FindBy(xpath="//select[@name='user_type']")WebElement selectDropDown;
	@FindBy(xpath="//button[@name='Create']")WebElement saveAdminButton;
	
	@FindBy(xpath="(//a[contains(@href, 'admin/user/edit')])[1]")WebElement editIcon;
	@FindBy(xpath="//input[@id='username']")WebElement editUsernameTextBox;
	@FindBy(xpath="//input[@id='password']")WebElement editPasswordTextBox;
	@FindBy(xpath="//select[@id='user_type']")WebElement editSelectDropDown;
	@FindBy(xpath="//button[@name='Update']")WebElement updateAdminButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlertBox;
	
	WebDriver driver;
	public AdminUsersPage(WebDriver driver) 
		{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
/*	public void adminUserMoreInfo()
	{
		addAdminLink.click();
	}*/
	
	public AdminUsersPage clickAddNewAdminButton() 
	{
		addNewAdminButton.click();
		return this;
	}
	
	public AdminUsersPage enterNewAdminUsername(String username) 
	{
		addNewAdminTextBox.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage enterNewAdminPassword(String password) 
	{
		passwordTextBoxAdmin.sendKeys(password);
		return this;
	}
	
	public AdminUsersPage selectUserType() 
	{
		selectDropDown.click();
		PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleText(selectDropDown, "Admin");
		return this;
	}
	
	public AdminUsersPage clickSaveAdminButton() 
	{
		saveAdminButton.click();
		return this;
	}
	
	public boolean isSuccessAlertDisplayed() 
	{
		return successAlertBox.isDisplayed();
	}
	
	public AdminUsersPage clickEditIcon() 
	{
		editIcon.click();
		return this;
	}
	
	public AdminUsersPage editUsername(String updatedUsername) 
	{
		editUsernameTextBox.clear();
		editUsernameTextBox.sendKeys(updatedUsername);
		return this;
	}
	
	public AdminUsersPage editPassword(String updatedPassword) 
	{
		editPasswordTextBox.clear();
		editPasswordTextBox.sendKeys(updatedPassword);
		return this;
	}
	
	public AdminUsersPage editUserToStaff() 
	{
		editSelectDropDown.click();
		PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleText(editSelectDropDown, "Staff");
		return this;
	}
	
	public AdminUsersPage clickUpdateAdminButton() 
	{
		updateAdminButton.click();
		return this;
	}
}




