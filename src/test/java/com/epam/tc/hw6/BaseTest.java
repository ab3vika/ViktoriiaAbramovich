package com.epam.tc.hw6;

import com.epam.tc.hw6.steps.ActionStep;
import com.epam.tc.hw6.steps.AssertStep;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    private static final String PATH = "src/test/resources/config.properties";
    protected ActionStep actionStep;
    protected AssertStep assertStep;
    protected Properties properties;
    private WebDriver webDriver;

    @BeforeMethod
    @Parameters({"isLocal", "browser", "hub"})
    public void setUp(ITestContext context, @Optional("true") boolean isLocal, String browser, @Optional String hub) {
        webDriver = WebDriverFactory.getWebDriver(isLocal, browser, hub);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        context.setAttribute("driver", webDriver);
        actionStep = new ActionStep(webDriver);
        assertStep = new AssertStep(webDriver);

        try (FileInputStream fileInputStream = new FileInputStream(PATH)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
