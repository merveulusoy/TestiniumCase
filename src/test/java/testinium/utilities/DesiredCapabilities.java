package testinium.utilities;

import org.openqa.selenium.chrome.ChromeOptions;

public class DesiredCapabilities {
        static ChromeOptions options = new ChromeOptions();

        public static ChromeOptions setChromeOptions() {
            options.addArguments("disable-extensions");
            options.addArguments("disable-popup-blocking");
            options.addArguments("--disable-notifications");
            return options;
        }

    }