package eCom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCom.Utils.ExplicitWait;

public class HomePage {

	WebDriver driver;
	ExplicitWait eWait;

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

	@FindBy(xpath = "//span[text()='Currency']")
	private WebElement currencyButton;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this); // can also use object of :new LoginPage(driver) or LoginPage.this:
												// instead of :this:
		eWait = new ExplicitWait(driver);
	}

	public SearchPage clickOnSearchButton() {
		eWait.waitForElementToBeClickable(searchButton);
		searchButton.click();
		return new SearchPage(driver);

	}

	public SearchPage searchForAProduct(String productText) {
		eWait.waitForElementToBeClickable(searchBoxField);
		searchBoxField.sendKeys(productText);
		eWait.waitForElementToBeClickable(searchButton);
		searchButton.click();
		return new SearchPage(driver);

	}

	public void enterProductIntoSearchBoxField(String productText) {
		searchBoxField.sendKeys(productText);
	}

	public RegisterPage navigateToRegisterPage() {
		eWait.waitForElementToBeClickable(myAccountDropMenu);
		myAccountDropMenu.click();
		eWait.waitForElementToBeClickable(registerOption);
		registerOption.click();
		return new RegisterPage(driver);
	}

	public LoginPage naviageToLoginPage() {
		eWait.waitForElementToBeClickable(myAccountDropMenu);
		myAccountDropMenu.click();
		eWait.waitForElementToBeClickable(loginOption);
		loginOption.click();
		return new LoginPage(driver);

	}

	// *****************

	public WebElement CurrencyType(String currencyName) {
		eWait.waitForElementToBeClickable(currencyButton);
		currencyButton.click();
		String locators = "//button[contains(text(),'" + currencyName + "')]";
		return driver.findElement(By.xpath(locators));

	}

}
