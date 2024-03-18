package pages;

import net.serenitybdd.core.pages.PageObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HubPro extends PageObject {
    public static final Map<String, String> HUB_PRO_ELEMENT_XPATHS = ElementMap();

    private static Map<String, String> ElementMap() {
        Map<String, String> map = new HashMap<>();

        map.put("preplans", "//p[contains(., 'PREPLANS')]");
        map.put("accept", "//ion-card-content[contains(., 'ACCEPT NEW SHIPMENTS')]");
        map.put("shipment", "//h2[contains(., 'Shipment:')]");
        map.put("activate", "//ion-card-content[contains(., 'Activate This Shipment')]/parent::span/parent::button");
        map.put("confirm", "//span[contains(., 'Confirm and redirect to truck inspection')]/parent::button");

        map.put("bobtail-StartShipment", "//span[contains(., 'BOBTAIL')]/ancestor::div[@class='stop-details']/following-sibling::div//span[contains(., 'Start Shipment')]/parent::button");
        map.put("bobtail-StartShipment-Submit", "//span[contains(., 'BOBTAIL')]/ancestor::div[@class='stop-details']/following-sibling::div//span[contains(., 'Start Shipment')]/parent::button/parent::ion-card-header/following-sibling::ion-card-content//button");
        map.put("bobtail-ConfirmDeparture", "//span[contains(., 'BOBTAIL')]/ancestor::div[@class='stop-details']/following-sibling::div//span[contains(., 'Confirm Departure')]/parent::button");
        map.put("bobtail-ConfirmDeparture-Submit", "//span[contains(., 'BOBTAIL')]/ancestor::div[@class='stop-details']/following-sibling::div//span[contains(., 'Confirm Departure')]/parent::button/parent::ion-card-header/following-sibling::ion-card-content//button");

        return Collections.unmodifiableMap(map);
    }
}
