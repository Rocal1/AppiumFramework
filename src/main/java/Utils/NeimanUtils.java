package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class NeimanUtils {

    private static Properties prop;

    /**
     *
     * @param keyProperty
     * @return key value from capabilities.properties
     * @throws IOException
     */
    public static String getPropertyFile(String keyProperty) throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/resources/capabilities.properties");
        prop.load(fis);
        return prop.getProperty(keyProperty);
    }
}
