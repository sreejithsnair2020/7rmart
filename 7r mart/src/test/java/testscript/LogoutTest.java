package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {

    @Test(priority = 1)
    public void testLogout() throws IOException {
      
        String loginUserName = ExcelUtility.getStringData(1, 0, "LoginPage");
        String loginPassword = ExcelUtility.getStringData(1, 1, "LoginPage");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(loginUserName);
        loginPage.enterPassword(loginPassword);
        loginPage.signin();

       
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.clickProfileIcon();
        logoutPage.clickLogoutButton();


        boolean isDisplayed = logoutPage.isLoginPageDisplayed();
        Assert.assertTrue(isDisplayed, Constant.LOGOUTALERTNOTDISPLAYEDMESSAGE);
    }
}