package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ManageFooterTextPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-footertext\" and @class=\"small-box-footer\" ]")WebElement moreInfoButton;
    @FindBy(xpath = "//a[@href=\"https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1\" and @class=\"btn btn-sm btn btn-primary btncss\"]")WebElement actionButton;
    @FindBy(xpath = "//textarea[@placeholder=\"Enter the Address\"]")WebElement addressField;
    @FindBy(xpath = "//input[@name=\"email\"]")WebElement emailField;
    @FindBy(xpath = "//input[@id=\"phone\"]")WebElement phoneField;
    @FindBy(xpath = "//button[@name=\"Update\"]")WebElement updateButton;
    @FindBy(xpath = "//a[text()='Reset']")WebElement resetButton;
	@FindBy(xpath = "//i[contains(@class,'fa-check')]")WebElement updatedSuccessfullyAlertMessage;
    
    public ManageFooterTextPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    public void clickOnMoreInfo() {
    	//driver.navigate().to("https://groceryapp.uniqassosiates.com/admin");
    	moreInfoButton.click();
    	actionButton.click();
    }
    public void updateAddressField(String addressfield) {
    	addressField.clear();
		addressField.sendKeys(addressfield);
	}
    public void updateEmailField(String emailfield) {
    	emailField.clear();
    	emailField.sendKeys(emailfield);
	}
    public void updatePhoneField(String phonefield) {
    	phoneField.clear();
    	phoneField.sendKeys(phonefield);
	}
    public void clickUpdateButton() {
    	updateButton.click();
	}
    public void clickResetButton() {
		resetButton.click();
	}
	public boolean addressUpdatedSuccessfully() {
		return updatedSuccessfullyAlertMessage.isDisplayed();

	}
}
