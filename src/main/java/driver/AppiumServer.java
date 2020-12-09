package driver;

import Utils.NeimanUtils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.tools.ant.types.LogLevel;
import org.testng.Assert;

import java.io.IOException;

public class AppiumServer {

       private AppiumDriverLocalService service;

        public void startServer() throws IOException {
            AppiumServiceBuilder builder = new AppiumServiceBuilder()
                    .withIPAddress("127.0.0.1")
                    .usingPort(4723)
                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                    .withArgument(GeneralServerFlag.DEBUG_LOG_SPACING)
                    //If it's needed add GeneralServerFlag.LOG_TIMESTAMP to print time
                    .withArgument(GeneralServerFlag.LOG_LEVEL, NeimanUtils.getPropertyFile("LOG_LEVEL"));
            service = AppiumDriverLocalService.buildService(builder);
            service.start();
        }

        public void stopServer() {
            service.stop();
        }
}

