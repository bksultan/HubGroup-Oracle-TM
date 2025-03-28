package pages;

import org.openqa.selenium.WebDriver;
import utilities.Utilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Home {
    public static final Map<String, String> HOME_PAGE_ELEMENT_XPATHS = ElementMap();

    private static Map<String, String> ElementMap() {
        Map<String, String> map = new HashMap<>();

        map.put("ORDER ENTRY", "//div[@role='tablist']//div[.='ORDER ENTRY']");

        map.put("createDropDownMenu", "//div[@class='menu-drop-down']//label[.='Create']");
        map.put("createNewOrderButton", "//div[@role='menu']//label[.='Create New Order']");

        return Collections.unmodifiableMap(map);
    }

}
