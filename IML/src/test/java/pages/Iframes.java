package pages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Iframes {
    public static final Map<String, String> IFRAME_XPATHS = ElementMap();

    private static Map<String, String> ElementMap() {
        Map<String, String> map = new HashMap<>();
        map.put("mainIFrameStr", "//iframe[@id='mainIFrame']");
        map.put("actionFrame", "//iframe[@id='actionFrame']");
        map.put("mainBody", "//frame[@name='mainBody']");

        return Collections.unmodifiableMap(map);
    }
}
