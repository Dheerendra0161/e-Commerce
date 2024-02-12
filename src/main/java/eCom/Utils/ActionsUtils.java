package eCom.Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {
	private WebDriver driver;
	private Actions actions;

	public ActionsUtils(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
	}

	// Click on an element
	public void clickElement(WebElement element) {
		actions.click(element).build().perform();
	}

	// Double-click on an element
	public void doubleClickElement(WebElement element) {
		actions.doubleClick(element).build().perform();
	}

	// Right-click on an element
	public void rightClickElement(WebElement element) {
		actions.contextClick(element).build().perform();
	}

	// Drag and drop an element
	public void dragAndDrop(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).build().perform();
	}

	// Simulate a chord action, e.g., Ctrl + A (Select All)
	public void selectAll() {
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
	}

	// Send keys to an element
	public void sendKeysToElement(WebElement element, CharSequence... keysToSend) {
		actions.sendKeys(element, keysToSend).build().perform();
	}
}
