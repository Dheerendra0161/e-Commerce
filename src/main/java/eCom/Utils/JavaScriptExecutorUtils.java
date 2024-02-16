package eCom.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtils {
	private static WebDriver driver;
	private static JavascriptExecutor js;

	public JavaScriptExecutorUtils(WebDriver driver) {
		JavaScriptExecutorUtils.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public static void clickElement(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	// Scrolling of Elements ****************************************************

	public static void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrollToBottom() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public static void scrollToTop() {
		js.executeScript("window.scrollTo(0, 0);");
	}

	// Scroll down by specified pixels
	public static void scrollByXYAxis(int xPixels, int yPixels) {
	    js.executeScript("window.scrollBy(" + xPixels + ", " + yPixels + ");");
	}


	// Scroll horizontally by specified pixels
	public static void scrollHorizontally(int pixels) {
		js.executeScript("window.scrollBy(" + pixels + ", 0);");
	}

	// Scroll to a specific element
	public static void scrollToElementById(String elementId) {
		WebElement element = driver.findElement(By.id(elementId));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Elements:************************************************************************
	// Click on a hidden element
	public static void clickHiddenElement(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	// Changing Elements Attributes*****************************************
	// Enable an element
	public static void enableElement(WebElement element) {
		js.executeScript("arguments[0].disabled = false;", element);
	}

	// Disable an element
	public static void disableElement(WebElement element) {
		js.executeScript("arguments[0].disabled = true;", element);
	}

	// Alerts:*******************************************************************************
	// Accept JavaScript alert
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	// Dismiss JavaScript alert
	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	// Get text from JavaScript alert
	public static String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	// Enter text in JavaScript prompt alerts
	public static void enterTextInPrompt(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	public static void executeJavaScript(String script) {
		js.executeScript(script);
	}

	// Get the text of the page using JavaScriptExecutor
	public static String getPageText() {
		return (String) js.executeScript("return document.documentElement.innerText;");
	}

	// Modifying HTML/CSS**********************************************************
	// Highlight an element using JavaScriptExecutor
	public static void highlightElement(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	// Change background color of an element
	public static void changeBackgroundColor(WebElement element, String color) {
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
	}
}
