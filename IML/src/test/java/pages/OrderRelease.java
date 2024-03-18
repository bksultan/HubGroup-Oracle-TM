package pages;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Utilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static utilities.Utilities.attachToReport;
import static utilities.WebInteractionsUtils.highlightElement;

public class OrderRelease {
    public static final Map<String, String> ORDER_RELEASE_PAGE_ELEMENT_XPATHS = ElementMap();

    private static Map<String, String> ElementMap() {
        Map<String, String> map = new HashMap<>();
        map.put("mainIFrameStr", "//iframe[@id='mainIFrame']");

        map.put("orderReleaseIDInput", "//input[@aria-label='Order Release ID']");
        map.put("searchBtn", "//button[@name='search_button']");
        map.put("orderNumber", "//a[contains(., 'CORP/HUB.')]");

        //Order Release and Shipment page Tabs
        map.put("Other Attributes", "//div[@id='tabOrderReleaseOtherAttributes']");
        map.put("Financials", "//div[@id='tabShipmentFinancials']");
        map.put("Stops", "//div[@id='tabShipmentStopData']");
        map.put("Involved Parties", "//div[@id='tabShipmentInvolvedParties']");

        //Other Attributes
        map.put("PICKLOADED", "//table[@id='table_special_service_grid']//a[.='PICKLOADED']");
        map.put("DROPLOADED", "//table[@id='table_special_service_grid']//a[.='DROPLOADED']");

        return Collections.unmodifiableMap(map);
    }

    public WebElement refnumIsExist(String refnum){
        WebDriver driver = Utilities.getStaticDriver();
        WebElement element = driver.findElement(By.xpath("//span[.='" + refnum + "']"));
        return element;
    }

    public static boolean requiredOrderRefnumIsExist() {
        WebDriver driver = Utilities.getStaticDriver();
        boolean allElementsDisplayed = true;
        String[] refNums = {
                "BENEFICIAL_OWNER",
                "BENEFICIAL_OWNER_ID",
                "OMS_SCAC",
                "ORDER_ID",
                "ORDER_NUMBER",
                "ORDER_STATUS",
                "SEGMENT_TYPE",
                "TENDER_SELECTION_CODE",
                "TENDER_STATUS",
                "TERMINAL"
        };

        for (String refNum : refNums) {
            try {
                WebElement element = driver.findElement(By.xpath("//span[.='" + refNum + "']"));
                highlightElement(element);
                if (!element.isDisplayed()) {
                    allElementsDisplayed = false;
                    attachToReport("Element Found but Not Displayed", "Element found but not displayed: " + refNum);
                }
            } catch (NoSuchElementException e) {
                allElementsDisplayed = false;
                attachToReport("Element Not Found", "Element not found: " + refNum);
            }
        }

        if (allElementsDisplayed) {
            System.out.println("All required elements are displayed.");
        } else {
            System.out.println("Not all required elements are displayed.");
        }

        return allElementsDisplayed;
    }
}

