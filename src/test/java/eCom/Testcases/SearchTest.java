package eCom.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import eCom.Base.Base;
import eCom.Pages.HomePage;
import eCom.Pages.SearchPage;


public class SearchTest extends Base {

	SearchPage searchPage;
	HomePage homePage;

	public SearchTest() {
		super();
	}

	public WebDriver driver;

	// @Parameters("browser")
	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {

			driver.quit();
		}
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {

		searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(),
				"Valid product HP is not displayed in the search results");

	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {

		searchPage = homePage.searchForAProduct(dataProp.getProperty("invalidProduct"));
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(),
				"There is no product that matches the search criteria.",
				"No product message in search results is not displayed");

	}

	// Note: , if a test method (TestMethodA) has dependencies on
	// other test methods (TestMethodB), and TestMethodB fails, then TestMethodA
	// will be skipped.
	@Test(priority = 3, dependsOnMethods = { "verifySearchWithValidProduct" },alwaysRun = true)
	public void verifySearchWithoutAnyProduct() {

		searchPage = homePage.clickOnSearchButton();
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(),
				dataProp.getProperty("NoProductTextInSearchResults"),
				"No product message in search results is not displayed");

	}
}
