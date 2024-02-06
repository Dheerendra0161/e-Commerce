package eCom.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	// Objects
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement searchBoxField;

	@FindBy(xpath = "//div[@id='search']/descendant::button")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);     // can also use object of :new LoginPage(driver) or LoginPage.this: instead of :this:

	}

	// Actions

	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);

	}

	public SearchPage searchForAProduct(String productText) {
		searchBoxField.sendKeys(productText);
		searchButton.click();
		return new SearchPage(driver);

	}

	public void enterProductIntoSearchBoxField(String productText) {

		searchBoxField.sendKeys(productText);

	}



	public RegisterPage navigateToRegisterPage() {
		myAccountDropMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
	}

	public LoginPage naviageToLoginPage() {
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);

	}

}
