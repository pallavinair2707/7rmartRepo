package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	@Test(description = "Verify update button functionality in Manage Footer Page")
	public void verifyAddressUpdate() throws IOException {
		String address = ExcelUtility.readStringData(1, 0, "managefootertextpage");
		String email = ExcelUtility.readStringData(1, 1, "managefootertextpage");
		String phone = ExcelUtility.readIntegerData(1, 2, "managefootertextpage");

		String userName = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		ManageFooterTextPage manageFooterText = new ManageFooterTextPage(driver);

		// login
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.loginButton();

		// editing address
		manageFooterText.clickOnMoreInfo();;
		manageFooterText.updateAddressField(address);
		manageFooterText.updateEmailField(email);
		manageFooterText.updatePhoneField(phone);

		// submit
		manageFooterText.clickUpdateButton();

		boolean updated = manageFooterText.addressUpdatedSuccessfully();
		Assert.assertTrue(updated, Constant.MANAGEFOOTERTEXTERROR);

	}
}
