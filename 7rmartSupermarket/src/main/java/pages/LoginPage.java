package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	@FindBy(xpath="//input[@placeholder=\"Username\"]")WebElement usernamefield;
	@FindBy(xpath="//input[@placeholder=\"Password\"]")WebElement passwordfield;
	@FindBy(xpath="//label[@for=\"remember\"]")WebElement checkboxfield;
	@FindBy(xpath="//button[@type=\"submit\"]")WebElement loginButton;
	@FindBy(xpath = "//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")WebElement loginAlertMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username) {
		usernamefield.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordfield.sendKeys(password);
	}
	public void clickCheckbox() {
		checkboxfield.click();
	}
	public void loginButton() {
		loginButton.click();
	}
	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}

	public boolean loginAlertMessage() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElement(driver, loginAlertMessage);
		return loginAlertMessage.isDisplayed();
	}
}
