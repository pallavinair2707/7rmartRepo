package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	@FindBy(xpath ="//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-news\"  and @class=\"active nav-link\" ]")WebElement moreInfoButton;
    @FindBy(linkText = "New")WebElement newButton;
    @FindBy(xpath = "//textarea[@placeholder=\"Enter the news\"]")WebElement enterNewNews;
    @FindBy(xpath = "//button[@type=\"submit\"]")WebElement saveNewNews;
    @FindBy(xpath = "//a[@type='button']")WebElement cancelNews;
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement successAlertMessage;
    
    public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    public void clickOnMoreInfo() {
    	driver.navigate().to("https://groceryapp.uniqassosiates.com/admin");
    	moreInfoButton.click();
    	newButton.click();
    }
    public void enterNewNews(String newNews) {
		enterNewNews.sendKeys(newNews);
	}
	public void clickSaveNews() {
		saveNewNews.click();
	}
	public void cancelNews() {
		cancelNews.click();
	}

	public boolean isSuccessAlertDisplayed() {
		return successAlertMessage.isDisplayed();
	}
}
