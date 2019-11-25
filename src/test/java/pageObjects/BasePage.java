package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static tests.Config.baseUrl;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        if (url.contains("http")) {
            driver.get(url);
        } else {
            driver.get(baseUrl + url);
        }
    }

    public void hover(By locator, By destination) throws InterruptedException {
        Actions builder = new Actions(driver);
        WebElement target = find(locator);
        System.out.println(target);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
        builder.moveToElement(target).perform();
        Point location = target.getLocation();
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mousemove\",true, true, window, 0, arguments[1], arguments[2], arguments[1], arguments[2], false, false, false, false, 0, arguments[0]);" +
                "arguments[0].dispatchEvent(evObj);";


        ((JavascriptExecutor)driver).executeScript(javaScript, target, location.x, location.y);
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void type(String inputText, By locator) {
        find(locator).sendKeys(inputText);
    }

    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            return false;
        }
    }

    public Boolean isDisplayed(By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }
}
