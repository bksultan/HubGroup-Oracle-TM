package pages;

import net.serenitybdd.core.Serenity;
import org.junit.Assert;
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

public class Shipment {
    public static final Map<String, String> SHIPMENT_PAGE_ELEMENT_XPATHS = ElementMap();

    private static Map<String, String> ElementMap() {
        Map<String, String> map = new HashMap<>();
        map.put("shipmentID", "//a[contains(., 'CORP/HUB.')]");
        map.put("status", "//button[.='Status']");

        //Actions
        map.put("shipmentActions", "//button[.='Actions']");
        map.put("fleetManagement", "//div[@id='actionTreeCont']//span[.='Fleet Management']");
        map.put("assign", "//tr[@id='actionTree.1_4.cc']//span[.='Assign']");
        map.put("driver", "//tr[@id='actionTree.1_4_1.cc']//a[.='Driver']");
        map.put("assignEquipmentTypeForShipment", "//span[.='Assign Equipment Type for Shipment']/preceding-sibling::a");
        map.put("dropEmptyBeforeFreightCheckbox", "//td[.='Drop Empty Before Freight']/preceding-sibling::td/input");
        map.put("driverIDInput", "//input[@aria-label='Driver ID']");
        map.put("okButton", "//button[@id='ok_button']");

        //Stops
        map.put("D-stopMiles", "//td[.='D']/following-sibling::td[contains(., 'MI')]");

        //Financials
        map.put("baseCost", "//a[.='Base']/parent::td/following-sibling::td//a[contains(., 'USD')]");

        //Involved parties
        map.put("EXECUTING_TERMINAL", "//span[.='EXECUTING_TERMINAL']/parent::td/preceding-sibling::td//a");
        map.put("TERMINAL", "//span[.='TERMINAL']/parent::td/preceding-sibling::td//a");

        return Collections.unmodifiableMap(map);
    }

    public static WebElement switchToPage(String page){
        WebDriver driver = Utilities.getStaticDriver();
        WebElement element = driver.findElement(By.xpath("//ul[@id='popmenuTree']//span[.='" + page + "']"));
        return element;
    }

    public static void verifyStatusOfShipment(String key, String value){
        WebDriver driver = Utilities.getStaticDriver();
        String elementValue = driver.findElement(By.xpath("//td[.='" + key + "']/following-sibling::td")).getText();

        Assert.assertEquals(value.toUpperCase(), elementValue.toUpperCase());
    }

    public static boolean requiredShipmentRefnumIsExist() {
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
                WebElement element = driver.findElement(By.xpath("//td[@scope='row']//span[.='" + refNum + "']"));
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
