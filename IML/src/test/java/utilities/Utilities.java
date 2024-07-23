package utilities;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities extends PageObject {
    private static String originalHandle;

    public static void writeProperty(String key, String value, String file) {
        Properties prop = new Properties();
        String filePath = "src/test/resources/data/" + file + ".properties";

        try (FileInputStream in = new FileInputStream(filePath)) {
            prop.load(in);
        } catch (IOException e) {
            System.out.println("Could not load existing properties. A new file will be created.");
        }

        try (FileOutputStream out = new FileOutputStream(filePath)) {
            prop.setProperty(key, value);
            System.out.println("key: " + key);
            System.out.println("value: " + value);

            prop.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties readPropertyFile(String pathToPropertyFile) throws IOException {
        Properties properties = new Properties();
        File propFile = new File(pathToPropertyFile);
        FileInputStream fileInputStream = new FileInputStream(propFile);
        properties.load(fileInputStream);

        return properties;
    }

    public static String getProperty(String key) {
        try {
            Properties properties = readPropertyFile("src/test/resources/data/config.properties");
            String value = properties.getProperty(key);
            return value;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static String getProperty(String module, String file, String key) {
        try {
            Properties properties = readPropertyFile(module + "/src/test/resources/" + file + ".properties");
            String value = properties.getProperty(key);
            return value;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static String getSecret(String key) {
        try {
            Properties properties = readPropertyFile("src/test/resources/data/secrets.properties");
            String value = properties.getProperty(key);
            return value;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static String getCredentials(String key) {
        try {
            Properties properties = readPropertyFile("src/test/resources/data/credentials_for_testing.properties");
            String value = properties.getProperty(key);
            return value;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void switchToNewTab() {
        originalHandle = getStaticDriver().getWindowHandle();
        for (String handle : getStaticDriver().getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                getStaticDriver().switchTo().window(handle);
                break;
            }
        }
    }

    public static void switchBackToOriginalTab() {
        getStaticDriver().switchTo().window(originalHandle);
    }

    public static void attachToReport(String title, String message) {
        Serenity.recordReportData().withTitle(title).andContents(message);
    }

    public static WebDriver getStaticDriver() {
        return Serenity.getWebdriverManager().getWebdriver();
    }
}