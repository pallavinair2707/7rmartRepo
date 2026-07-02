package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;


public class LoginTest extends Base {
	@Test(description = "Verify Login with valid credentials", groups = { "Regression" })
	public void verifyLoginWithValidCredentials() throws IOException {
		String userName = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickCheckbox();
		loginPage.loginButton();

		boolean homepage = loginPage.isDashboardDisplayed();
		Assert.assertTrue(homepage, Constant.VALIDLOGINERROR);// the message here will be displayed only if test case fails
	}

	@Test(description = "Verify Login with invalid credentials")
	public void verifyLoginWithInvalidCredentials() throws IOException {
		String userName = ExcelUtility.readStringData(2, 0, "loginpage");
		String password = ExcelUtility.readStringData(2, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.loginButton();

		boolean loginAlert = loginPage.loginAlertMessage();
		Assert.assertTrue(loginAlert, Constant.INVALIDLOGINERROR);
	}

	@Test(description = "Verify Login with invalid user name and valid password")
	public void verifyLoginWithInvalidUserName() throws IOException {
		String userName = ExcelUtility.readStringData(3, 0, "loginpage");
		String password = ExcelUtility.readStringData(3, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.loginButton();

		boolean loginAlert = loginPage.loginAlertMessage();
		Assert.assertTrue(loginAlert, Constant.INVALIDUSERNAME);
	}

	@Test(description = "Verify Login with valid username and invalid password")
	public void verifyLoginWithInvalidPassword() throws IOException {
		String userName = ExcelUtility.readStringData(4, 0, "loginpage");
		String password = ExcelUtility.readStringData(4, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.loginButton();

		boolean loginAlert = loginPage.loginAlertMessage();
		Assert.assertTrue(loginAlert, Constant.INVALIDPASSWORD);
	}
}