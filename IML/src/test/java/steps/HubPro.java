package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.HubPro.HUB_PRO_ELEMENT_XPATHS;
import static utilities.HubPro.bobtailStopExecution;
import static utilities.WebInteractionsUtils.*;
import static utilities.WebInteractionsUtils.getXpath;

public class HubPro {
    @When("I switch to {string} tab in tablet")
    public void switchTabHubPro(String tab) {
        getElementWithWait(tab, HUB_PRO_ELEMENT_XPATHS).click();
    }

    @Then("I accept new shipments")
    public void acceptNewShipments() throws InterruptedException {
        clickHubPro(getXpath("accept", HUB_PRO_ELEMENT_XPATHS));
    }

    @And("I activate shipment")
    public void activateShipment() throws InterruptedException {
        clickHubPro(getXpath("shipment", HUB_PRO_ELEMENT_XPATHS));
        clickHubPro(getXpath("activate", HUB_PRO_ELEMENT_XPATHS));
        clickHubPro(getXpath("confirm", HUB_PRO_ELEMENT_XPATHS));
    }

    @And("I start execute {string} stop detail of the shipment")
    public void executeShipment(String stopDetail) throws InterruptedException {
//        Thread.sleep(10000);
        if (stopDetail == "Bobtail") {
            bobtailStopExecution();
        }
    }
}
