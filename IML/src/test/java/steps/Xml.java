package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;

import java.util.List;

import static utilities.Utilities.writeProperty;
import static utilities.XmlUtils.*;
import static utilities.XmlUtils.saveXml;

public class Xml {
    private String fileName;
    private String convertedXml;
    String orderType = "";

    @Given("Read xml for the following {string}")
    public void readXml(String fileName) {
        this.fileName = fileName;
        this.convertedXml = convertToStringXmlOrder(fileName);
        Serenity.setSessionVariable("convertedXml").to(this.convertedXml);
        Serenity.setSessionVariable("orderType").to(fileName);
    }

    @When("I updated Order_Release_ID in this xml")
    public void updateOrderReleaseID() {
        this.convertedXml = orderReleaseIDGeneration(this.convertedXml);
        Serenity.setSessionVariable("convertedXml").to(this.convertedXml);
    }

    @And("I updated Equipment_ID in this xml")
    public void updateEquipmentID() {
        this.convertedXml = equipmentIDGeneration(this.convertedXml);
        Serenity.setSessionVariable("convertedXml").to(this.convertedXml);
    }

    @And("I updated following information")
    public void updateInfoInXml(DataTable dataTable) {
        this.convertedXml = infoUpdateInXml(this.convertedXml, dataTable);
        Serenity.setSessionVariable("convertedXml").to(this.convertedXml);
    }

    @And("I updated Pickup and Delivery dates to actual")
    public void updateInfoInXml() {
        this.convertedXml = updateDatesToActual(this.convertedXml);
        Serenity.setSessionVariable("convertedXml").to(this.convertedXml);
    }

    @Then("I save modified xml")
    public void saveModifiedXml() {
        saveXml(Serenity.sessionVariableCalled("convertedXml"), this.fileName);
    }

    @And("I update {string} .properties file")
    public void updateProperties(String fileName) {
        writeProperty(Serenity.sessionVariableCalled("orderType"), Serenity.sessionVariableCalled("generatedOrderReleaseID"), fileName);
    }
}
