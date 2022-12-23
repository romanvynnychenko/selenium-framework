package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {
    public static WebDriver initDriver() throws IOException {
        WebDriver driver = null;

        String browserName =
                System.getProperty("browser") != null ? System.getProperty("browser") : getProperty("browser");

        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("Incorrect platform or driver name " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }
    public static String getProperty(String propertyName) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("globalData.properties"));
        return System.getProperty(propertyName);
    }
}
