package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")WebElement adminUsersMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement addNewAdminUser;
	@FindBy(id = "username")WebElement enterUserName;
	@FindBy(id = "password")WebElement enterPassword;
	@FindBy(id = "user_type")WebElement userTypeList;
	@FindBy(xpath = "//button[@name='Create']")WebElement newUserSaveButton;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[4]")WebElement newUserResetButton;
	@FindBy(xpath = "//i[contains(@class,'fa-check')]")WebElement alertMessage;
	@FindBy(xpath = "//i[contains(@class,'fa-ban')]")WebElement userAlreadyExist;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewUsersMoreInfo() {
		adminUsersMoreInfo.click();
		//pageutility.simpleAlertHandling(driver);
		
	}

	public void createNewUsers() {
		addNewAdminUser.click();
	}

	public void enterUserName(String userName) {
		enterUserName.clear();
		enterUserName.sendKeys(userName);
	}

	public void enterPassword(String password) {
		enterPassword.clear();
		enterPassword.sendKeys(password);

	}

	public void selectUserType() {
		userTypeList.click();
	}

	public void selectUserTypeByIndex(int index) {
		PageUtility pageUtil = new PageUtility();
		pageUtil.dropDownIndex(userTypeList, index);
	}

	public void saveNewUser() {
		newUserSaveButton.click();
		pageutility.simpleAlertHandling(driver);
	}

	public void resetNewUser() {
		newUserResetButton.click();
	}

	public boolean isUserCreatedSuccessfylly() {
		WaitUtility waitutility = new WaitUtility();
	    waitutility.waitForElement(driver, alertMessage);
	    return alertMessage.isDisplayed();
	}

	public boolean userAlreadyExists() {
		return userAlreadyExist.isDisplayed();
	}

}