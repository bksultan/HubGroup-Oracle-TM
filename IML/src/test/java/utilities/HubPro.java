package utilities;

import static pages.HubPro.HUB_PRO_ELEMENT_XPATHS;
import static utilities.WebInteractionsUtils.*;

public class HubPro {
    public static void bobtailStopExecution() throws InterruptedException {
        clickHubPro(getXpath("bobtail-StartShipment", HUB_PRO_ELEMENT_XPATHS));
        clickHubPro(getXpath("bobtail-StartShipment-Submit", HUB_PRO_ELEMENT_XPATHS));
        clickHubPro(getXpath("bobtail-ConfirmDeparture", HUB_PRO_ELEMENT_XPATHS));
        clickHubPro(getXpath("bobtail-ConfirmDeparture-Submit", HUB_PRO_ELEMENT_XPATHS));
    }
}
