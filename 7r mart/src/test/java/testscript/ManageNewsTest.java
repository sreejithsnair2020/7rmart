package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	ManageNewsPage managenewspage;
	LogoutPage logoutpage;

	@Test(priority = 1, groups = { "regression" })
	public void postANewsInManageNewsTest() throws IOException {

		String loginUserName = ExcelUtility.getStringData(1, 0, "Loginpage");
		String loginPassword = ExcelUtility.getStringData(1, 1, "Loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword).signin();

		managenewspage = new ManageNewsPage(driver);
		LogoutPage logoutpage = new LogoutPage(driver);
		managenewspage = logoutpage.clickManageNewsMoreInfo();

		String newsDescriptionText = ExcelUtility.getStringData(0, 0, "ManageNews");

		managenewspage.clickAddNewButton().enterNewsDescription(newsDescriptionText).clickSaveButton();

		Assert.assertTrue(managenewspage.isAlertDisplayed(), Constant.NEWSADDALERTNOTDISPLAYEDMESSAGE);
	}

	@Test(priority = 2, description = "Edit the news")
	public void updateANewsInManageNewsTest() throws IOException {
		String loginUserName = ExcelUtility.getStringData(1, 0, "Loginpage");
		String loginPassword = ExcelUtility.getStringData(1, 1, "Loginpage");
		String updatedDescription = ExcelUtility.getStringData(0, 0, "Managenews");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword).signin();

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		LogoutPage logoutpage = new LogoutPage(driver);
		managenewspage = logoutpage.clickManageNewsMoreInfo();

		managenewspage.clickEditNewsButton().editNewsDescription(updatedDescription).clickUpdateNewsButton();

		Assert.assertTrue(managenewspage.isAlertDisplayed(), Constant.NEWSUPDATEALERTNOTDISPLAYEDMESSAGE);
	}
}

