package com.epam.tc.hw4;

import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static final String PATH = "src/test/resources/config.properties";
    protected ActionStep actionStep;
    protected AssertStep assertStep;
    protected Properties properties;
    private WebDriver webDriver;

    @BeforeMethod
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
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
