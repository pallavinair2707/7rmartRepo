package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import utilities.PageUtility;

public class LogoutPage {
	public WebDriver driver;

	@FindBy(linkText = "Admin")WebElement sidemenuicon;
    @FindBy(linkText = "Logout")WebElement logoutButton;
    @FindBy(xpath = "//p[@class='login-box-msg']")WebElement loginScreen;
    
    public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    public void clickOnSideMenu() {
    	sidemenuicon.click();
    }
    public void loginOutButton() {
    	logoutButton.click();
    }
    public boolean isLoginScreenDisplayed() {
		return loginScreen.isDisplayed();
	}
}
