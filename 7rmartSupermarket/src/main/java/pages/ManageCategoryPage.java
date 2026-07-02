package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	@FindBy(xpath = "(//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-category\"])[2]")WebElement manageCategoryMoreInfoLink;
	@FindBy(xpath = "//a[@href=\"https://groceryapp.uniqassosiates.com/admin/Category/add\"]")WebElement manageCategoryNewButton;
	@FindBy(id = "category")WebElement categoryuInputField;
	@FindBy(xpath = "//li[@id='134-selectable']")WebElement discountGroup;
	@FindBy(xpath = "//input[@id='main_img']")WebElement chooseFileButton;
	@FindBy(xpath = "//button[@name='create']")WebElement saveButton;
	@FindBy(xpath = "//a[text()='Cancel']")WebElement cancelButton;
	@FindBy(xpath = "//i[contains(@class,'fa-check')]")WebElement successAlertMessage;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickManageCategoryMoreInfo() {
		manageCategoryMoreInfoLink.click();
		// PageUtility pageUtilityObj = new PageUtility();
		//pageutility.clickmethod(manageCategoryMoreInfoLink, driver);
	}

	public void clickToAddNewCategory() {
//		waitutility.waitForElement(driver, manageCategoryNewButton);
//	    pageutility.javaScriptClick(driver, manageCategoryNewButton);
//	    waitutility.waitForElement(driver, categoryuInputField);
		manageCategoryNewButton.click();
	}

	public void giveCategoryName(String categoryName) {
		waitutility.waitForElement(driver, categoryuInputField);
		categoryuInputField.sendKeys(categoryName);

	}

	public void selectDiscountGroup() {

		discountGroup.click();
	}

	public void chooseFile() {

		FileUploadUtility fileUploadObj = new FileUploadUtility();
		fileUploadObj.fileUploadUsingSendkeys(chooseFileButton, Constant.CATEGORYIMAGEFILE);

	}

	public void save() {
		//waitutility.waitForElement(driver, saveButton);
		//pageutility.javaScriptClick(driver, saveButton); 
		saveButton.click();

	}

	public boolean isCategoryCreationSuccessful() {
		//WaitUtility waitutility = new WaitUtility();
	    waitutility.waitForElement(driver, successAlertMessage);
		return successAlertMessage.isDisplayed();
	}

}