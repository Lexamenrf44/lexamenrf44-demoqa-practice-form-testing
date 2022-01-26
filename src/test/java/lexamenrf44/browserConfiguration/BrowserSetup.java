package lexamenrf44.browserConfiguration;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Browsers.CHROME;

public class BrowserSetup {

    @BeforeAll
    static void browserOpeningConfiguration() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = CHROME;
        Configuration.fastSetValue = false;
        Configuration.holdBrowserOpen = false;
    }

}
