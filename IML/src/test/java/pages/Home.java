package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static utilities.WebInteractionsUtils.getStaticDriver;

public class Home extends PageObject {
    public static final Map<String, String> HOME_PAGE_ELEMENT_XPATHS = ElementMap();

    private static Map<String, String> ElementMap() {
        Map<String, String> map = new HashMap<>();
        map.put("homeBtn", "//oj-button[@id='homeButton']");
        map.put("navigatorButton", "//oj-button[@id='navigatorButton']");

        //User settings pop-up
        map.put("userSettingsButton", "//oj-button[@id='userSettingsButton']");
        map.put("userRole", "//div[@id='userSettingsPopup_layer']//input[@id='userRoleSS|input']/parent::div/following-sibling::span");
        map.put("saveAndClose", "//div[@id='userSettingsPopup_layer']//span[.='Save and Close']");

        //Order Management
        map.put("orderRelease", "//span[@class='oj-treeview-item-text' and .='Financial Overview']/parent::div/parent::li/following-sibling::li/div/span[@class='oj-treeview-item-text' and .='Order Release']");
        map.put("orderReleaseContent", "//span[@class='oj-treeview-item-text' and .='Order Release With Stops']/parent::div/parent::li/preceding-sibling::li//span[.='Order Release']");

        // Business Process Automation
        map.put("Integration", "//span[@class='oj-treeview-item-text' and .='Integration']");
        map.put("IntegrationManager", "//span[@class='oj-treeview-item-text' and .='Integration Manager']");

        return Collections.unmodifiableMap(map);
    }
}
