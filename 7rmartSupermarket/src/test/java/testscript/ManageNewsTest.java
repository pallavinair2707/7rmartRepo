package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	@Test(description = "Verify adding new NEWS in Manage News Page")
	public void addNews() throws IOException {
		String news = ExcelUtility.readStringData(1, 0, "managenewspage");
		String userName = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.loginButton();
		manageNews.clickOnMoreInfo();
		manageNews.clickSaveNews();
		manageNews.enterNewNews(news);
		manageNews.clickSaveNews();

		boolean alert = manageNews.isSuccessAlertDisplayed();
		Assert.assertTrue(alert, Constant.MANAGENEWSERROR);
	}

}
