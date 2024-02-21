package eCom.Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

    public static WebDriver driver;
    public static Actions actions;

    public ActionsUtils(WebDriver webDriver) {
        // Private constructor to prevent instantiation
    	 driver = webDriver;
         actions = new Actions(driver);
    }

//    public static void initialize(WebDriver webDriver) {
//        driver = webDriver;
//        actions = new Actions(driver);
//    }

    // Click on an element
    public static void clickElement(WebElement element) {
        actions.click(element).build().perform();
    }

    // Move to an element
    public static void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    // Double-click on an element
    public static void doubleClickElement(WebElement element) {
        actions.doubleClick(element).build().perform();
    }

    // Right-click on an element
    public static void rightClickElement(WebElement element) {
        actions.contextClick(element).build().perform();
    }

    // Drag and drop an element
    public static void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).build().perform();
    }

    // Simulate a chord action, e.g., Ctrl + A (Select All)
    public static void selectAll() {
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
    }

    // Simulate a control-click action on an element
    public static void controlClickOnElement(WebElement element) {
        actions.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).perform();
    }

    // Send keys to an element
    public static void sendKeysToElement(WebElement element, CharSequence... keysToSend) {
        actions.sendKeys(element, keysToSend).build().perform();
    }
}
