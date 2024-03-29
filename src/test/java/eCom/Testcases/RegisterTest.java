package eCom.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import eCom.Base.Base;
import eCom.Pages.AccountSuccessPage;
import eCom.Pages.HomePage;
import eCom.Pages.RegisterPage;
import eCom.Utils.TestData_Generation;
import eCom.Utils.Utilities;

public class RegisterTest extends Base {

	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;

	public RegisterTest() {
		super();
	}

	public WebDriver driver;
	
	//@Parameters("browser")
	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		registerPage = homePage.navigateToRegisterPage();

	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {

			//driver.quit();
		}

	}

	@Test(priority = 1,groups = {"sanity"})
	public void verifyRegisteringAnAccountWithMandatoryFields() {

		accountSuccessPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), TestData_Generation.Email_ID_TestData("Dheerendra"),
				dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),
				dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");

	}

	@Test(priority = 2 ,groups = { "regression" ,"sanity"})
	public void verifyRegisteringAccountByProvidingAllFields() {

		accountSuccessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), TestData_Generation.Email_ID_TestData("Dheerendra"),
				dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),
				dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");

	}
	

	@Test(priority = 3,groups = { "sanity"})
	public void verifyRegisteringAccountWithExistingEmailAddress() {

		registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("validEmail"), dataProp.getProperty("telephoneNumber"),
				prop.getProperty("validPassword"));
		Assert.assertTrue(
				registerPage.retrieveDuplicateEmailAddressWarning()
						.contains(dataProp.getProperty("duplicateEmailWarning")),
				"Warning message regaring duplicate email address is not displayed");

	}

	@Test(priority = 4,groups = { "regression"})
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {

		registerPage.clickOnContinueButton();
		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"),
				dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"),
				dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"),
				dataProp.getProperty("passwordWarning")));

	}
	@Test
	public void scrollAndClick() {
		registerPage.SpecialOfferButton();
		
	}

}
