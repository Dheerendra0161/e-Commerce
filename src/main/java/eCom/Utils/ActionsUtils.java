package eCom.Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

    // Click on an element
    public static void clickElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).build().perform();
    }

    // Double-click on an element
    public static void doubleClickElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
    }

    // Right-click on an element
    public static void rightClickElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();
    }

    // Drag and drop an element
    public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }

    // Simulate a chord action, e.g., Ctrl + A (Select All)
    public static void selectAll(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
    }
    
    // Simulate a control-click action on an element
    public static void controlClickOnElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).perform(); 
    }

    // Send keys to an element
    public static void sendKeysToElement(WebDriver driver, WebElement element, CharSequence... keysToSend) {
        Actions actions = new Actions(driver);
        actions.sendKeys(element, keysToSend).build().perform();
    }
}
