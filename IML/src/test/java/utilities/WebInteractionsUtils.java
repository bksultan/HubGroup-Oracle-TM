package utilities;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static pages.Home.HOME_PAGE_ELEMENT_XPATHS;

public class WebInteractionsUtils extends PageObject {
    public static WebElement getElement(String elementKey, Map<String, String> elementXpathCollection) {
        WebDriver driver = getStaticDriver();
        String xpath = getXpath(elementKey, elementXpathCollection);
        WebElement element = driver.findElement(By.xpath(xpath));
        highlightElement(element);

        return element;
    }

    public static String getXpath(String elementKey, Map<String, String> elementXpathCollection) {
        return elementXpathCollection.getOrDefault(elementKey, "");
    }

    public static WebElement getElementWithWait(String elementKey, Map<String, String> elementXpathCollection) {
        WebDriver driver = getStaticDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = getXpath(elementKey, elementXpathCollection);

        if (xpath.isEmpty()) {
            throw new IllegalArgumentException("No XPath found for key: " + elementKey);
        }

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        highlightElement(element);
        return element;
    }

    public static void clickWithJS(String element) {
        JavascriptExecutor executor = (JavascriptExecutor) getStaticDriver();
        WebDriver driver = getStaticDriver();
        WebElement elementToClick = driver.findElement(By.xpath(element));
        executor.executeScript("arguments[0].click();", elementToClick);
    }

    public static void clickHubPro(String element) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) getStaticDriver();
        WebDriver driver = getStaticDriver();
        WebElement elementToClick = driver.findElement(By.xpath(element));
        executor.executeScript("document.body.style.zoom='80%'");
        executor.executeScript("arguments[0].click();", elementToClick);
        Thread.sleep(5000);
    }

    public static void highlightElement(WebElement element) {
        WebDriver driver = getStaticDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript(
                "arguments[0].setAttribute('style', arguments[1]);",
                element, "border: 2px solid red; padding: 3px;"
        );
    }

    public static void userRoleChange(String role) throws InterruptedException {
        WebDriver driver = getStaticDriver();
        Thread.sleep(5000);
        getElementWithWait("userSettingsButton", HOME_PAGE_ELEMENT_XPATHS).click();
        Thread.sleep(5000);
        getElement("userRole", HOME_PAGE_ELEMENT_XPATHS).click();

        WebElement elementToClick = driver.findElement(By.xpath("//oj-highlight-text[@text='" +  role.toUpperCase() + "']"));
        elementToClick.click();

        getElementWithWait("saveAndClose", HOME_PAGE_ELEMENT_XPATHS).click();
        Thread.sleep(5000);
    }

    public static WebDriver getStaticDriver() {
        return Serenity.getWebdriverManager().getWebdriver();
    }
}
