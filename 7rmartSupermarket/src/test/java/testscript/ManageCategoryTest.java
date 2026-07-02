package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base{
	
	@Test(description = "Verifying adding a new catefory in Manage Category Page")
	public void addCategorySuccessfully() throws IOException {

		String userName = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		FakerUtility fakerObj = new FakerUtility();
		String catName = fakerObj.createRandomFirstName();

		LoginPage loginPage = new LoginPage(driver);
		ManageCategoryPage manageCategory = new ManageCategoryPage(driver);

		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.loginButton();

		manageCategory.clickManageCategoryMoreInfo();
		manageCategory.clickToAddNewCategory();

		manageCategory.giveCategoryName(catName);
		manageCategory.selectDiscountGroup();
		manageCategory.chooseFile();
		manageCategory.save();

		Assert.assertTrue(manageCategory.isCategoryCreationSuccessful(), Constant.MANAGECATEGORYERROR);

	}
}
