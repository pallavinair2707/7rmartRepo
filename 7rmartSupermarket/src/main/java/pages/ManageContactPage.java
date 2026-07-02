package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageContactPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-contact\" and @class=\"small-box-footer\" ]")WebElement moreInfoButton;
    @FindBy(xpath = "//a[@href=\"https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1\" and @class=\"btn btn-sm btn btn-primary btncss\"]")WebElement actionButton;
    @FindBy(xpath = "//input[@id=\"phone\"]")WebElement phoneField;
    @FindBy(xpath = "//input[@name=\"email\"]")WebElement emailField;
    @FindBy(xpath = "//textarea[@name='address']")WebElement addressField;
    @FindBy(name = "del_time")WebElement deliveryTimeField;
    @FindBy(xpath = "//input[@id='del_limit']")WebElement deliveryLimitField;
    @FindBy(xpath = "//button[@name=\"Update\"]")WebElement updateButton;
    @FindBy(xpath = "//a[text()='Reset']")WebElement resetButton;
	@FindBy(xpath = "//i[contains(@class,'fa-check')]")WebElement successAlertMessage;
    
    public ManageContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    public void clickOnMoreInfo() {
    	//driver.navigate().to("https://groceryapp.uniqassosiates.com/admin");
    	moreInfoButton.click();
    	actionButton.click();
    }
    public void updatePhoneField(String phonefield) {
    	phoneField.clear();
    	phoneField.sendKeys(phonefield);
	}
    public void updateEmailField(String emailfield) {
    	emailField.clear();
    	emailField.sendKeys(emailfield);
	}
    public void updateAddressField(String addressfield) {
    	WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElement(driver, addressField);
    	addressField.clear();
		addressField.sendKeys(addressfield);
	}
    public void updateDeliveryTimeField(String deliverytimefield) {
    	deliveryTimeField.clear();
    	deliveryTimeField.sendKeys(deliverytimefield);
	}
    public void updateDeliveryLimitField(String deliverylimitfield) {
    	deliveryLimitField.clear();
    	deliveryLimitField.sendKeys(deliverylimitfield);
	}
    public void clickUpdateButton() {
    	// wait until the button is clickable
    			WaitUtility waitutility = new WaitUtility();
    			waitutility.waitForElement(driver, updateButton);

    			// scroll into view
    			PageUtility pageutility = new PageUtility();
    			pageutility.scrollIntoView(driver, updateButton);
    			
    			//click the update button using javscript executor
    			pageutility.clickUsingJavaScript(driver, updateButton);
	}
    public void clickOnResetButton() {
		resetButton.click();
	}

	public boolean isUpdateSuccessful() {
		return successAlertMessage.isDisplayed();
	}
}
