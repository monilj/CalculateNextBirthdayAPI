package calculatebirthday;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClassForAWSApi {
    Properties properties = new Properties();

    @BeforeTest
    public String getBaseUri() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\Data Backup 2022\\IntellijProjects\\CalcalateBirthday\\src\\test\\resources\\env.properties");
        properties.load(fileInputStream);
        String baseUri =properties.getProperty("amazonApiHost");
        return baseUri;
    }

}
