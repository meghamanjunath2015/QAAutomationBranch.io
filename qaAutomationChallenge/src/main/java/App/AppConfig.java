package App;
import org.apache.log4j.Logger;
import java.util.Properties;

public class AppConfig {

    private static final Properties CONFIG = new Properties();

    public static final String CONFIG_FILE = "log4j.properties";
    public static final String HOST_MAIN = "https://www.google.com/";

    public static final Logger logger = Logger.getLogger(AppConfig.class);

    static {
        readProperties();
    }

    public static void readProperties() {
        try {
            CONFIG.load(AppConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE));
        } catch (Exception e) {
            logger.warn("Can't load config from file. Using system variables.");
        }
    }
}
