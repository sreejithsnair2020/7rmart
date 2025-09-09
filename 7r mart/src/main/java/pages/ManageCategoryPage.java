package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	WebDriver driver;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer'] ")WebElement moreInfoCategory;
	@FindBy(xpath="(//a[contains(@href,'/admin/category/edit')])[1]")WebElement editIcon;
	@FindBy(xpath="//input[@id='main_img']")WebElement chooseFileButton;
	@FindBy(xpath="//button[@name='update']")WebElement updateButton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement addNewCategoryButton;
	@FindBy(xpath="//input[@id='category']")WebElement categoryNameTextBox;
	@FindBy(xpath="//input[@id='main_img']")WebElement chooseFileButtonInAddNewCategory;
	@FindBy(xpath="//button[@name='create']")WebElement saveButtonInAddNewCategory;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlertBox;
	
	public ManageCategoryPage(WebDriver driver) 
		{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}	
	
	/*/public void clickManageCategoryMoreInfo() 
			{
		moreInfoCategory.click();
			}*/
	
	public ManageCategoryPage clickEditIcon()
		{
		editIcon.click();
		return this;
		}
	public ManageCategoryPage clickChooseFileButton() 
		{
		//chooseFileButton.sendKeys(filePath);
		FileUploadUtility fileUploadutility = new FileUploadUtility();
		fileUploadutility.fileUploadUsingSendkeys(chooseFileButton, Constant.TESTIMAGEFILEPATH);
		return this;
		}
	
	public ManageCategoryPage clickUpdateButton() 
		{
		
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, updateButton);
		
		PageUtility pageutlility = new PageUtility();
		pageutlility.javaScriptScrollToBottom(driver);
		pageutlility.javaScriptClick(driver, updateButton);
		//JavascriptExecutor js = (JavascriptExecutor) driver; //typecast the driver to JavascriptExecutor
		//js.executeScript("window.scrollBy(0,150)",""); 
		//js.executeScript("arguments[0].click();", updateButton);
		//JavaExecutionUtility javaexecutionutility = new JavaExecutionUtility();
		//javaexecutionutility.javaScriptClick(driver, updateButton);
		return this;
		}
	
	public ManageCategoryPage clickAddNewCategoryButton() 
		{
		addNewCategoryButton.click();
		return this;
		}
	
	public ManageCategoryPage enterCategoryName(String categoryName) 
		{
		categoryNameTextBox.sendKeys(categoryName);
		return this;
		}
	
	public ManageCategoryPage clickChooseFileButtonInAddNewCategory() 
		{
		FileUploadUtility fileUploadutility = new FileUploadUtility();
		fileUploadutility.fileUploadUsingSendkeys(chooseFileButtonInAddNewCategory, Constant.TESTIMAGEFILEPATH2);
		return this;
		}
	
	public ManageCategoryPage clickSaveButtonInAddNewCategory() 
		{
	//	JavascriptExecutor js = (JavascriptExecutor) driver; //typecast the driver to JavascriptExecutor
		//js.executeScript("window.scrollBy(0,150)",""); 
	//	js.executeScript("arguments[0].click();", saveButtonInAddNewCategory);
		
		
		PageUtility pageutlility = new PageUtility();
		pageutlility.javaScriptScrollToBottom(driver);
		pageutlility.javaScriptScrollToBottom(driver);
		pageutlility.javaScriptClick(driver, saveButtonInAddNewCategory);
		return this;
		}
	
	public boolean isSuccessAlertDisplayed() 
		{
		return successAlertBox.isDisplayed();
		}
	
	
	
	
}