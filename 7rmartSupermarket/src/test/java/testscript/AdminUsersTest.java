package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test(description = "Adding new user , type Admin")

	public void addNewUserTypeAdmin() throws IOException {
		String adminUserName = ExcelUtility.readStringData(2, 0, "adminusers");
		String adminPassword = ExcelUtility.readStringData(2, 1, "adminusers");
		String userName = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		// using faker utility here to create random usernames.
		// FakerUtility fakerObj=new FakerUtility();
		// String adminUserName = fakerObj.creatARandomFirstName();

		LoginPage loginPage = new LoginPage(driver);
		AdminUsersPage adminPage = new AdminUsersPage(driver);

		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.loginButton();

		adminPage.clickOnNewUsersMoreInfo();
		adminPage.createNewUsers();

		adminPage.enterUserName(adminUserName);
		adminPage.enterPassword(adminPassword);

		adminPage.selectUserTypeByIndex(2);

		adminPage.saveNewUser();

		boolean userCreated = adminPage.isUserCreatedSuccessfylly();
		Assert.assertTrue(userCreated, Constant.ADMINUSERPAGEERROR);
	}

	@Test(description = "Adding new user , type Staff")

	public void addNewUserTypeStaff() throws IOException {

		String userName = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		String adminUserName = ExcelUtility.readStringData(1, 0, "adminusers");
		String adminPassword = ExcelUtility.readStringData(1, 1, "adminusers");

		// using faker utility here to create random usernames.
		// FakerUtility fakerObj=new FakerUtility();
		// String adminUserName = fakerObj.creatARandomFirstName();

		LoginPage loginPage = new LoginPage(driver);
		AdminUsersPage adminPage = new AdminUsersPage(driver);

		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.loginButton();

		adminPage.clickOnNewUsersMoreInfo();
		adminPage.createNewUsers();

		adminPage.enterUserName(adminUserName);
		adminPage.enterPassword(adminPassword);

		adminPage.selectUserTypeByIndex(1);

		adminPage.saveNewUser();

		boolean userCreated = adminPage.isUserCreatedSuccessfylly();
		Assert.assertTrue(userCreated, Constant.ADMINUSERPAGEERROR);
	}

	@Test(description = "Adding new user , type Partner")

	public void addNewUserTypePartner() throws IOException {
		String adminUserName = ExcelUtility.readStringData(3, 0, "adminusers");
		String adminPassword = ExcelUtility.readStringData(3, 1, "adminusers");

		String userName = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		// using faker utility here to create random usernames.
		// FakerUtility fakerObj=new FakerUtility();
		// String adminUserName = fakerObj.creatARandomFirstName();

		LoginPage loginPage = new LoginPage(driver);
		AdminUsersPage adminPage = new AdminUsersPage(driver);

		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.loginButton();

		adminPage.clickOnNewUsersMoreInfo();
		adminPage.createNewUsers();

		adminPage.enterUserName(adminUserName);
		adminPage.enterPassword(adminPassword);

		adminPage.selectUserTypeByIndex(3);

		adminPage.saveNewUser();

		boolean userCreated = adminPage.isUserCreatedSuccessfylly();
		Assert.assertTrue(userCreated, Constant.ADMINUSERPAGEERROR);
	}

	@Test(description = "Adding new user , type Delivery Boy")

	public void addNewUserTypeDeliveryBoy() throws IOException {
		String adminUserName = ExcelUtility.readStringData(4, 0, "adminusers");
		String adminPassword = ExcelUtility.readStringData(4, 1, "adminusers");

		String userName = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		AdminUsersPage adminPage = new AdminUsersPage(driver);

		// using faker utility here to create random usernames.
		// FakerUtility fakerObj=new FakerUtility();
		// String adminUserName = fakerObj.creatARandomFirstName();

		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.loginButton();

		adminPage.clickOnNewUsersMoreInfo();
		adminPage.createNewUsers();

		adminPage.enterUserName(adminUserName);
		adminPage.enterPassword(adminPassword);

		adminPage.selectUserTypeByIndex(4);

		adminPage.saveNewUser();

		boolean userCreated = adminPage.isUserCreatedSuccessfylly();
		Assert.assertTrue(userCreated, Constant.ADMINUSERPAGEERROR);
	}

	@Test(description = "Adding existing User")
	public void addAlreadyExistingUser() throws IOException {
		String adminUserName = ExcelUtility.readStringData(5, 0, "adminusers");
		String adminPassword = ExcelUtility.readStringData(5, 1, "adminusers");

		String userName = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		AdminUsersPage adminPage = new AdminUsersPage(driver);

		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.loginButton();

		adminPage.clickOnNewUsersMoreInfo();
		adminPage.createNewUsers();

		adminPage.enterUserName(adminUserName);
		adminPage.enterPassword(adminPassword);

		adminPage.selectUserTypeByIndex(1);

		adminPage.saveNewUser();

		adminPage.createNewUsers();

		adminPage.enterUserName(adminUserName);
		adminPage.enterPassword(adminPassword);

		adminPage.selectUserTypeByIndex(1);

		adminPage.saveNewUser();
		boolean exitingUser = adminPage.userAlreadyExists();
		Assert.assertTrue(exitingUser, Constant.ADMINUSERPAGEERROR);
	}

}