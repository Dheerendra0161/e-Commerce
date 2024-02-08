//Comment added to do some demo changes to this file
package eCom.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eCom.Base.Base;
import eCom.Pages.AccountPage;
import eCom.Pages.HomePage;
import eCom.Pages.LoginPage;
import eCom.Utils.TestData_Generation;
import eCom.Utils.Utilities;

public class LoginTest extends Base {

	LoginPage loginPage;
	HomePage homePage;

	public LoginTest() {
		super();
	}

	public WebDriver driver;

	// @Parameters("browser")
	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
		loginPage = homePage.naviageToLoginPage();

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

	@Test(priority = 1, dataProvider = "validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {

		AccountPage accountPage = loginPage.login(email, password);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(),
				"Edit Your Account Information option is not displayed");

	}

	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] supplyTestData() {

		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {

		loginPage.login(TestData_Generation.Email_ID_TestData("Dheerendra"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(
				loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Expected Warning message is not displayed");

	}

	@Test(priority = 3, groups = { "regression", "sanity" })
	public void verifyLoginWithInvalidEmailAndValidPassword() {

		loginPage.login(TestData_Generation.Email_ID_TestData("Dheerendra"), prop.getProperty("validPassword"));
		Assert.assertTrue(
				loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Expected Warning message is not displayed");

	}

	@Test(priority = 4, groups = { "regression" })
	public void verifyLoginWithValidEmailAndInvalidPassword() {

		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(
				loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Expected Warning message is not displayed");

	}

	@Test(priority = 5, groups = { "sanity" })
	public void verifyLoginWithoutProvidingCredentials() {

		loginPage.clickOnLoginButton();
		Assert.assertTrue(
				loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Expected Warning message is not displayed");

	}

	// ********************************************

	// Ensure that you are accessing the parameters correctly within the method
	// according to their intended meanings. If the order of parameters doesn't
	// match the order of columns in your Excel sheet, you might encounter issues
	// where the wrong data is being used for comparison or action within the test
	// method.

	@Test(dataProvider = "currencyTypeDataSupply")
	public void selecyCurrencyType(String cValue, String ExpectedValue) {
		homePage.CurrencyType(cValue).click();
		String currencyValue = homePage.CurrencyType(cValue).getText();
		Assert.assertEquals(currencyValue, ExpectedValue, "Incorrect value found");
	}

	@DataProvider(name = "currencyTypeDataSupply")
	public Object[][] supplyTestData1() {
		Object[][] data = Utilities.getTestDataFromExcel("CurrencyType");
		return data;
	}

}
