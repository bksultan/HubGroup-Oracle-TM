package utilities;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.Serenity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class XmlUtils {
    private static final Random random = new Random();
    private static final String CHARACTERS = "0123456789ABCDEF";
    private static final int HEX_LENGTH = 8;

    public static String convertToStringXmlOrder(String fileName) {
        String filePath = "src/test/resources/xml-template/" + fileName + ".xml";
        try {
            String content = Files.readString(Paths.get(filePath));
            String result = generateRandomString();
            return content.replaceAll("Transmission_ID", result);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read XML file: " + fileName, e);
        }
    }

    public static String generateRandomString() {
        String uuidPart = UUID.randomUUID().toString().toUpperCase();
        StringBuilder hexPart = new StringBuilder(HEX_LENGTH);
        for (int i = 0; i < HEX_LENGTH; i++) {
            hexPart.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return uuidPart + "-" + hexPart.toString();
    }

    public static String orderReleaseIDGeneration(String content) {
        int randomNumber = random.nextInt(900000) + 100000;
        String result = "01900" + randomNumber + "0201";
        String modifiedContent = content.replaceAll("Order_Release_ID", result);

        Serenity.setSessionVariable("generatedOrderReleaseID").to(result);
        return modifiedContent;
    }

    public static String equipmentIDGeneration(String content) {
        int randomNumber = random.nextInt(900000) + 100000;
        String result = "HGIU" + randomNumber;
        String modifiedContent = content.replaceAll("Equipment_ID", result);

        return modifiedContent;
    }

    public static String infoUpdateInXml(String content, DataTable dataTable) {
        List<Map<String, String>> parameters = dataTable.asMaps(String.class, String.class);
        String modifiedContent = content;

        for (Map<String, String> parameter : parameters) {
            String param = parameter.get("Parameter");
            String value = parameter.get("Value");
            modifiedContent = modifiedContent.replaceAll(param, value);
        }

        return modifiedContent;
    }

    public static String updateDatesToActual(String content) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        Map<String, String> datePlaceholders = new HashMap<>();
        datePlaceholders.put("Early_Pickup_Date", "datePlus1Days");
        datePlaceholders.put("Late_Pickup_Date", "datePlus2Days");
        datePlaceholders.put("Early_Delivery_Date", "datePlus5Days");
        datePlaceholders.put("Late_Delivery_Date", "datePlus6Days");

        Map<String, String> dateMap = generateDateMap(formatter);
        System.out.println(dateMap);

        for (Map.Entry<String, String> entry : datePlaceholders.entrySet()) {
            String placeholder = entry.getKey();
            String dateKey = entry.getValue();
            content = content.replaceAll(placeholder, dateMap.get(dateKey));
        }

        return content;
    }

    public static void saveXml(String modifiedContent, String filename) {
        try {
            Files.write(Paths.get("src/test/resources/xml-generated/" + filename + ".xml"), modifiedContent.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write modified XML to file", e);
        }
    }

    /** */
    private static Map<String, String> generateDateMap(DateTimeFormatter formatter) {
        Map<String, String> dateMap = new HashMap<>();
        int[] daysToAdd = {1, 2, 5, 6};

        for (int day : daysToAdd) {
            LocalDateTime date = LocalDateTime.now().plusDays(day);
            String formattedDate = date.format(formatter);
            dateMap.put("datePlus" + day + "Days", formattedDate);
        }

        return dateMap;
    }
}
