package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {

	LogoutPage logout;
	ManageCategoryPage managecategorypage;

	@Test(priority = 1)
	public void updateImageOfAnExistingCategoryInManageCategoryTest() throws IOException {
		String loginUserName = ExcelUtility.getStringData(1, 0, "Loginpage");
		String loginPassword = ExcelUtility.getStringData(1, 1, "Loginpage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword);
		logout = loginPage.signin();

		managecategorypage = logout.clickManageCategoryMoreInfo();
		managecategorypage.clickEditIcon().clickChooseFileButton().clickUpdateButton();

		Assert.assertTrue(managecategorypage.isSuccessAlertDisplayed(), Constant.CATEGORYUPDATEALERTNOTDISPLAYEDMESSAGE);
	}

	@Test(priority = 2)
	public void addNewCategoryInManageCategoryTest() throws IOException {
		String loginUserName = ExcelUtility.getStringData(1, 0, "Loginpage");
		String loginPassword = ExcelUtility.getStringData(1, 1, "Loginpage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword);
		logout = loginPage.signin();

		String categoryName = ExcelUtility.getStringData(0, 0, "Managecategories");
		managecategorypage = logout.clickManageCategoryMoreInfo();
		managecategorypage.clickAddNewCategoryButton()
							.enterCategoryName(categoryName)
							.clickChooseFileButtonInAddNewCategory()
							.clickSaveButtonInAddNewCategory();

	}

}