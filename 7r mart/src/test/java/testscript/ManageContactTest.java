package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility; // keep your faker utility import

public class ManageContactTest extends Base {

    ManageContactPage managecontactpage;
    LogoutPage logoutpage;

    @Test(priority = 1)
    public void updateContactInfoInManageCategory() throws IOException {
        // Read login from Excel (sheet Loginpage)
        String loginUserName = ExcelUtility.getStringData(1, 0, "Loginpage");
        String loginPassword = ExcelUtility.getStringData(1, 1, "Loginpage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(loginUserName)
                 .enterPassword(loginPassword)
                 .signin();

        // Navigate to Manage Contact
        logoutpage = new LogoutPage(driver);

        // ensure this returns page object (match your method name)
        managecontactpage = logoutpage.clickManageContactMoreInfo();

        // fake data
        FakerUtility fakerUtility = new FakerUtility();
        String phoneNumber = fakerUtility.generatePhoneNumber();
        String email = fakerUtility.generateEmail();
        String address = fakerUtility.generateAddress();

        // Read time and charge limit from sheets
        // NOTE: use exact sheet names from your Excel tabs
        String time = ExcelUtility.getTimeData(0, 0, "Deliverytime");           // sheet name EXACT
        String chargeLimit = ExcelUtility.getIntegerData(1, 1, "Constantvalues"); // sheet name EXACT

        // ensure managecontactpage object exists
        managecontactpage = new ManageContactPage(driver);

        managecontactpage.clickContactEditIcon()
                         .updatePhoneNumber(phoneNumber)
                         .updateEmail(email)
                         .updateAddress(address)
                         .updateDeliveryTime(time)
                         .updateDeliveryChargeLimit(String.valueOf(chargeLimit))
                         .clickUpdateContactInfoButton();

        Assert.assertTrue(managecontactpage.isSuccessAlertDisplayed(),Constant.CONTACTUPDATEALERTNOTDISPLAYEDMESSAGE);
    }
}