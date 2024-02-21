package eCom.Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import eCom.Utils.ActionsUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingUtils {
	WebDriver driver;
	Actions action;

	@Test
	public void actionClassTest() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://playwright.dev/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement getStartedButton = driver.findElement(By.xpath("//a[@class='getStarted_Sjon']"));
		WebElement APIButton = driver.findElement(By.xpath("//a[normalize-space()='API']"));
		getStartedButton.click();
		System.out.println("*****************");
		ActionsUtils.controlClickOnElement(APIButton);
		
	//	ActionsUtils.controlClickOnElement(driver,APIButton);

//		Actions action=new Actions(driver);
//		action.keyDown(Keys.CONTROL).click(APIButton).keyUp(Keys.CONTROL).perform(); 
		System.out.println("*****************");

	}

}
