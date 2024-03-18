package pages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Integration {
    public static final Map<String, String> INTEGRATION_ELEMENT_XPATHS = ElementMap();

    private static Map<String, String> ElementMap() {
        Map<String, String> map = new HashMap<>();
        map.put("xml-csv", "//a[.='Upload an XML/CSV Transmission']");
        map.put("integrationFileUpload", "//input[@id='file']");
        map.put("uploadButton", "//button[@type='button']");

        return Collections.unmodifiableMap(map);
    }
}
