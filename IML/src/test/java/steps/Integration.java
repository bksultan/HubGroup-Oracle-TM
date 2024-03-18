package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static net.serenitybdd.core.Serenity.getDriver;
import static pages.Integration.INTEGRATION_ELEMENT_XPATHS;
import static utilities.Iframe.clickInMainIframe;
import static utilities.Iframe.inputInMainIframe;
import static utilities.WebInteractionsUtils.getXpath;

public class Integration {
    @And("I am on the Upload an XML-CSV Transmission page")
    public void uploadXmlCSVPage() {
        clickInMainIframe(getXpath("xml-csv", INTEGRATION_ELEMENT_XPATHS));
    }

    @Given("I upload {string} xml")
    public void uploadXml(String order) {
        String basePath = System.getProperty("user.dir");
        inputInMainIframe(getXpath("integrationFileUpload", INTEGRATION_ELEMENT_XPATHS), basePath + "/src/test/resources/xml-generated/" + order + ".xml");
        clickInMainIframe(getXpath("uploadButton", INTEGRATION_ELEMENT_XPATHS));
        getDriver().navigate().back();
    }
}
