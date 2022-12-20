package test.components;

import common.CommonActions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static constants.Constant.Urls.AMAZON_HOME_URL;

public class BaseTest {
    public WebDriver driver;
    protected HomePage homePage;
    public HomePage openHomePage(){
        homePage = new HomePage(driver);
        homePage.open(AMAZON_HOME_URL);
        return new HomePage(driver);
    }
    @BeforeMethod
    public void launchApp() {
        driver = CommonActions.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs((OutputType.FILE));
        String fileName = testCaseName + new SimpleDateFormat("_yyyyMMdd_HHmmss").format(new Date());
        File file = new File(System.getProperty("user.dir") + "/ExtentReport/screenshots/" + fileName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "/ExtentReport/screenshots/" + fileName + ".png";
    }
}
