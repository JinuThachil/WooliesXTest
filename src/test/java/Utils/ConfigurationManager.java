package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    private static Properties prop;

    public static void loadProperties() throws IOException {
        String environment = System.getProperty("env") != null ? System.getProperty("env") : "T1";
        String propertyFile = "src/test/resources/properties/" + environment + ".properties";
        FileInputStream fis = new FileInputStream(propertyFile);
        prop = new Properties();
        prop.load(fis);
    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }


}
