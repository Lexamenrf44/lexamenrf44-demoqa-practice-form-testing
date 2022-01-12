package lexamenrf44.testbase;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class TestBase {

    @BeforeEach
    void browserOpeningConfiguration() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = CHROME;
        Configuration.fastSetValue = false;
        Configuration.holdBrowserOpen = false;

        clearBrowserCookies();
    }

}
