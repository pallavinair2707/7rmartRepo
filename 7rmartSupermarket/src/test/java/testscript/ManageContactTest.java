package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
				@Test(description = "Verifying editing a contact in Manage Contact Page")
				public void editContactSuccessfully() throws IOException {

					String phone = ExcelUtility.readIntegerData(1, 0, "managecontact");
					String address = ExcelUtility.readStringData(1, 1, "managecontact");
					String email = ExcelUtility.readStringData(1, 2, "managecontact");
					String deliveryTime = ExcelUtility.readIntegerData(1, 3, "managecontact");
					String deliveryLimit = ExcelUtility.readIntegerData(1, 4, "managecontact");

					String userName = ExcelUtility.readStringData(1, 0, "loginpage");
					String password = ExcelUtility.readStringData(1, 1, "loginpage");

					LoginPage loginPage = new LoginPage(driver);
					ManageContactPage manageContact = new ManageContactPage(driver);

					loginPage.enterUsername(userName);
					loginPage.enterPassword(password);
					loginPage.loginButton();

					manageContact.clickOnMoreInfo();

					manageContact.updatePhoneField(phone);
					manageContact.updateAddressField(address);
					manageContact.updateEmailField(email);
					manageContact.updateDeliveryTimeField(deliveryTime);
					manageContact.updateDeliveryLimitField(deliveryLimit);
					manageContact.clickUpdateButton();

					Assert.assertTrue(manageContact.isUpdateSuccessful(), Constant.MANAGECONTACTERROR);

				}
}
