package tests;

import driver.AppiumServer;
import driver.Capabilities;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;

public class BaseTest {
    protected Capabilities capabilities;
    protected IOSDriver driver;
    private final AppiumServer server = new AppiumServer();
    private static final Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void startServer() throws IOException {
        log.info("-----------------------------START SUITE-----------------------------------");
        server.startServer();
    }

    @BeforeTest
    public IOSDriver setUp() throws IOException {
        log.info("-----------------------------START TEST-----------------------------------");
        capabilities = new Capabilities();
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities.getCapabilities());
        return driver;
    }

    @AfterTest
    public void TearDown() {
        log.info("-----------------------------END TEST-----------------------------------");
        driver.quit();
    }

    @AfterSuite
    public void stopServer() {
        log.info("-----------------------------END SUITE-----------------------------------");
        server.stopServer();
    }
}
