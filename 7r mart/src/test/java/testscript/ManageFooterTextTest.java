package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageFooterTextTest extends Base {

	ManageFooterTextPage managefootertextpage;
	LogoutPage logoutpage;

	@Test(priority = 1)
	public void editFooterTextInManageFooterText() throws IOException {
		String loginUserName = ExcelUtility.getStringData(1, 0, "Loginpage");
		String loginPassword = ExcelUtility.getStringData(1, 1, "Loginpage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword);
		logoutpage=loginPage.signin();

		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);

		LogoutPage logoutpage = new LogoutPage(driver);
		managefootertextpage = logoutpage.ClickManageFooterTextMoreInfo();

		FakerUtility fakerUtility = new FakerUtility();
		String address = fakerUtility.generateAddress();
		String email = fakerUtility.generateEmail();
		String phone = fakerUtility.generatePhoneNumber();

		managefootertextpage.clickEditIcon().enterAddress(address).enterEmail(email).enterPhone(phone)
				.clickUpdateButton();

		Assert.assertTrue(managefootertextpage.isSuccessAlertDisplayed(), Constant.FOOTERUPDATEALERTNOTDISPLAYEDMESSAGE);
	}

}