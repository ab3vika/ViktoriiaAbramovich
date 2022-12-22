package com.epam.tc.hw3;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.IndexPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static final String PATH = "src/test/resources/properties/config.properties";
    protected Properties properties;
    protected IndexPage indexPage;
    protected DifferentElementsPage differentElementsPage;
    private WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try (FileInputStream fileInputStream = new FileInputStream(PATH)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 12/10. Close Browser
    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

    public void initializeIndexPage() {
        indexPage = new IndexPage(webDriver);
    }

    public void initializeDifferentElementsPage() {
        differentElementsPage = new DifferentElementsPage(webDriver);
    }
}
