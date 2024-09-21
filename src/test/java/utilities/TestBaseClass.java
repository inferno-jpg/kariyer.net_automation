package utilities;

import org.testng.annotations.*;
import java.io.FileInputStream;
import java.util.Properties;

public class TestBaseClass {

    public static int i;
    public static Properties config;
    public static Properties baseURL;
    public static Properties appProps;

    public Properties configReader(String FilePath) {

        try {
            config = new Properties();
            config.load(new FileInputStream(FilePath));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return config;
    }
    @BeforeSuite
    public void baseURL() {
        baseURL = configReader("resources/application-baseUrl.properties");
        appProps = configReader("resources/application-apiSearch.properties");
    }
}
