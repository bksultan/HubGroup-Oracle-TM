package utilities;

import org.openqa.selenium.WebElement;

import static utilities.WebInteractionsUtils.highlightElement;


public class Shipment {
    public static double getOnlyNumbers(WebElement element) {
        highlightElement(element);
        String elementText = element.getText();
        String numberOnly = elementText.replaceAll("[^0-9.]", "");
        double number = Double.parseDouble(numberOnly);

        return number;
    }
}
