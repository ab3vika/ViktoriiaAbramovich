package com.epam.tc.hw2.ex2;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw2.BaseTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseTest {

    @Test
    public void exercise2() {

        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        assertThat(webDriver.getTitle()).as("Browser title").isEqualTo("Home Page");

        // 3. Perform login
        webDriver.findElement(By.className("uui-profile-menu")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();

        // 4. Assert Username in the left-top side of screen that user is loggined
        assertThat(webDriver.findElement(By.id("user-name")).getText()).as("Username").isEqualTo("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.className("dropdown-toggle")).click();
        webDriver.findElement(By.linkText("DIFFERENT ELEMENTS")).click();

        // 6. Select checkboxes
        WebElement water = webDriver.findElement(By.xpath("//label[normalize-space() = 'Water']"));
        water.click();
        WebElement wind = webDriver.findElement(By.xpath("//label[normalize-space() = 'Wind']"));
        wind.click();

        // 7. Select radio
        WebElement selen = webDriver.findElement(By.xpath("//label[normalize-space() = 'Selen']"));
        selen.click();

        // 8. Select in dropdown
        webDriver.findElement(By.className("colors")).click();
        WebElement yellow = webDriver.findElement(By.xpath("//option[normalize-space() = 'Yellow']"));
        yellow.click();

        /* 9. Assert that
        for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        for radio button there is a log row and value is corresponded to the status of radio button
        for dropdown there is a log row and value is corresponded to the selected value. */
        List<WebElement> actualLogList = webDriver.findElements(By.cssSelector(".panel-body-list > li"));
        List<String> expectedLogList = List.of("Colors: value changed to Yellow", "metal: value changed to Selen",
                "Wind: condition changed to true", "Water: condition changed to true");
        assertThat(actualLogList.size()).as("Log rows count").isEqualTo(expectedLogList.size());
        for (int i = 0; i < actualLogList.size(); i++) {
            assertThat(actualLogList.get(i).getText().substring(9)).as("Log row").isEqualTo(expectedLogList.get(i));
        }
    }
}
