package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "Verify logout functionality", groups = { "Regression" })
	public void verifyLogout() throws IOException {
		String userName = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickCheckbox();;
		loginPage.loginButton();

		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.clickOnSideMenu();
		logoutPage.loginOutButton();
		boolean loginScreen = logoutPage.isLoginScreenDisplayed();
		Assert.assertTrue(loginScreen, Constant.LOGOUTERROR);

	}


}
