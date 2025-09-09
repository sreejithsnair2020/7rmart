package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
WebDriver driver;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement profileIcon;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logoutButton;
	@FindBy(xpath="//button[text()='Sign In']")WebElement loginButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement addAdminLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer'] ")WebElement moreInfoCategory;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class=' nav-link']")WebElement MoreInfoContact;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement moreInfoLink;
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement newsDescription;

	
	public LogoutPage(WebDriver driver) 
		{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		}
	
	public AdminUsersPage adminUserMoreInfo()
		{
		addAdminLink.click();
		return new AdminUsersPage(driver);
		}
	
	public ManageCategoryPage clickManageCategoryMoreInfo() 
	{
		moreInfoCategory.click();
		return new ManageCategoryPage(driver);
	}
	
	public ManageContactPage clickManageContactMoreInfo() 
	{
		MoreInfoContact.click();
		return new ManageContactPage(driver);
	}
	
	public ManageFooterTextPage ClickManageFooterTextMoreInfo()
	{
	moreInfoLink.click();
	return new ManageFooterTextPage(driver);
	}
	
	public ManageNewsPage clickManageNewsMoreInfo() 
	{
		newsDescription.click();
		return new ManageNewsPage(driver);
	}
	
	public void clickProfileIcon() 
		{
		profileIcon.click();
		}
	
	public void clickLogoutButton() 
		{
		logoutButton.click();
		}
	
	public boolean isLoginPageDisplayed() 
		{
		return loginButton.isDisplayed();
		}
	
}