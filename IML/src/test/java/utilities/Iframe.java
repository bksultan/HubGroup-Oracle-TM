package utilities;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pages.Iframes.IFRAME_XPATHS;
import static utilities.WebInteractionsUtils.getXpath;
import static utilities.WebInteractionsUtils.highlightElement;

public class Iframe {
    public static WebElement getElementInMainIframe(String elementInsideIframeLocator) {
        WebDriver driver = getStaticDriver();

        WebElement iframeElement = driver.findElement(By.xpath(getXpath("mainIFrameStr", IFRAME_XPATHS)));
        driver.switchTo().frame(iframeElement);

        WebElement element = driver.findElement(By.xpath(elementInsideIframeLocator));
        highlightElement(element);
        driver.switchTo().defaultContent();
        return element;
    }

    public static void clickInMainIframe(String elementInsideIframeLocator) {
        WebDriver driver = getStaticDriver();

        WebElement iframeElement = driver.findElement(By.xpath(getXpath("mainIFrameStr", IFRAME_XPATHS)));
        driver.switchTo().frame(iframeElement);

        WebElement elementToClick = driver.findElement(By.xpath(elementInsideIframeLocator));
        highlightElement(elementToClick);
        elementToClick.click();
        driver.switchTo().defaultContent();
    }

    public static void inputInMainIframe(String elementInsideIframeLocator, String value) {
        WebDriver driver = getStaticDriver();

        WebElement iframeElement = driver.findElement(By.xpath(getXpath("mainIFrameStr", IFRAME_XPATHS)));
        driver.switchTo().frame(iframeElement);

        WebElement elementToInput = driver.findElement(By.xpath(elementInsideIframeLocator));
        highlightElement(elementToInput);
        elementToInput.sendKeys(value);
        driver.switchTo().defaultContent();
    }

    public static void switchToIframe(String iframe) {
        WebDriver driver = getStaticDriver();
        WebElement iframeElement = driver.findElement(By.xpath(getXpath(iframe, IFRAME_XPATHS)));
        driver.switchTo().frame(iframeElement);
    }

    public static void switchToDefaultIframe() {
        WebDriver driver = getStaticDriver();
        driver.switchTo().defaultContent();
    }

    public static WebDriver getStaticDriver() {
        return Serenity.getWebdriverManager().getWebdriver();
    }
}
