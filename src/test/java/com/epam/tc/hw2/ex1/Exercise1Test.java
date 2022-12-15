package com.epam.tc.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise1Test {

    WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // 12. Close Browser
    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void exercise1() {
        SoftAssertions softly = new SoftAssertions();

        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        softly.assertThat(webDriver.getTitle()).isEqualTo("Home Page");

        // 3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined
        softly.assertThat(webDriver.findElement(By.id("user-name")).getText()).isEqualTo("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        List<WebElement> actualMenuButtons = webDriver.findElements(By.cssSelector(".nav > li"));
        List<String> expectedMenuButtons = List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softly.assertThat(actualMenuButtons.size()).isEqualTo(expectedMenuButtons.size());
        for (int i = 0; i < actualMenuButtons.size(); i++) {
            softly.assertThat(actualMenuButtons.get(i).getText()).isEqualTo(expectedMenuButtons.get(i));
        }

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> benefitIcons = webDriver.findElements(By.className("benefit-icon"));
        softly.assertThat(benefitIcons.size()).isEqualTo(4);
        benefitIcons.forEach(e -> softly.assertThat(e.isDisplayed()).isTrue());

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<WebElement> actualBenefitTexts = webDriver.findElements(By.className("benefit-txt"));
        List<String> expectedBenefitTexts = List.of(
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
        );
        softly.assertThat(actualBenefitTexts.size()).isEqualTo(expectedBenefitTexts.size());
        for (int i = 0; i < actualBenefitTexts.size(); i++) {
            softly.assertThat(actualBenefitTexts.get(i).getText()).isEqualTo(expectedBenefitTexts.get(i));
        }

        // 8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = webDriver.findElement(By.id("frame"));
        softly.assertThat(iframe.isDisplayed()).isTrue();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(iframe);
        softly.assertThat(webDriver.findElement(By.id("frame-button")).isDisplayed()).isTrue();
        softly.assertThat(webDriver.findElement(By.id("frame-button")).getAttribute("value")).isEqualTo("Frame Button");

        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> actualLeftMenu = webDriver.findElements(By.cssSelector(".sidebar-menu > li"));
        List<String> expectedLeftMenu = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors",
                "Elements packs");
        softly.assertThat(actualLeftMenu.size()).isEqualTo(expectedLeftMenu.size());
        for (int i = 0; i < actualLeftMenu.size(); i++) {
            softly.assertThat(actualLeftMenu.get(i).getText()).isEqualTo(expectedLeftMenu.get(i));
        }

        softly.assertAll();
    }
}
