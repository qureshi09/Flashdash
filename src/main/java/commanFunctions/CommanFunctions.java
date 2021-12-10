package commanFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.swing.text.html.Option;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class CommanFunctions {

public  static Properties properties;
    public static WebDriver driver;

    public Properties loadPropertyFile() throws IOException {
        FileInputStream fileInputStream =new FileInputStream("config.properties");
        properties=new Properties();
        properties.load(fileInputStream);

        return properties;
    }


    @BeforeSuite
    public void launchBrowser() throws IOException {
        loadPropertyFile();

        String browser=properties.getProperty("browser");
        String url=properties.getProperty("Url-panel");
        String driverLocation=properties.getProperty("DriverLocation");


        if(browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver",driverLocation);
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",driverLocation);
            driver=new FirefoxDriver(); }

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        //	driver.quit();
    }

}
