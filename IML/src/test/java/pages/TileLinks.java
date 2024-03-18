package pages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TileLinks {
    public static final Map<String, String> TILE_LINKS = ElementMap();

    private static Map<String, String> ElementMap() {
        Map<String, String> map = new HashMap<>();
        map.put("homeBtn", "//oj-button[@id='homeButton']");
        map.put("navigatorButton", "//oj-button[@id='navigatorButton']");

        // Links
        map.put("Order Release", "https://otmgtm-test-hubgroupotm.otmgtm.us-ashburn-1.ocs.oraclecloud.com/GC3/glog.webserver.finder.FinderServlet?ct=Nzk3MzYzNjE2NzAyODU4NDE2NQ%3D%3D&bcKey=new&query_name=glog.server.query.order.OrderReleaseQuery&finder_set_gid=ORDER_RELEASE_WO_STOP");
        map.put("Integration Manager", "https://otmgtm-test-hubgroupotm.otmgtm.us-ashburn-1.ocs.oraclecloud.com/GC3/glog.webserver.home.HomeServlet?ct=Nzk3MzYzNjE2NzAyODU4NDE2NQ%3D%3D&ojr=coreotm%3Bsrc%3D%252FGC3%252Fglog.integration.servlet.IntegrationMenuServlet%253Fct%253DNzk3MzYzNjE2NzAyODU4NDE2NQ%25253D%25253D%2526bcKey%253Dnew");

        return Collections.unmodifiableMap(map);
    }

    public static String getLink(String linkKey) throws InterruptedException {
        Thread.sleep(5000);
        return TILE_LINKS.getOrDefault(linkKey, "");
    }
}
