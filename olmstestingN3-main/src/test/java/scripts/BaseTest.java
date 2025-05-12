package scripts;

import drivers.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    static Logger logger = LogManager.getLogger(BaseTest.class); // Use class reference

    private static final String DEFAULT_BROWSER = "chrome";

    @BeforeMethod
    @Parameters({"browser"})
    public void setupTest(@Optional(DEFAULT_BROWSER) String browser) {
        logger.info("Setting up WebDriver...");
        DriverFactory.setDriver(browser);
        driver = DriverFactory.getDriver();
        driver.get("https://olms.codedao.io.vn/login");
        logger.info("Navigated to test site: https://olms.codedao.io.vn/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing browser and quitting WebDriver...");
            driver.quit();
        }
    }
}
