package com.epam.tc.hw4.ex2;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseTest {

    @Test
    @Feature("Test functionality of JDI site")
    @Story("Exercise 2 from hw4 test")
    public void exercise2() {

        initializeIndexPage();
        assertBrowserTitle();
        assertUsername();
        assertDifferentElementsLogs();
    }

    @Step("Open test site by URL & Assert Browser title")
    private void assertBrowserTitle() {
        // 1. Open test site by URL
        indexPage.openSite(properties.getProperty("url"));

        // 2. Assert Browser title
        assertThat(indexPage.getTitle()).as("Browser title is incorrect").isEqualTo("Home Page");
    }

    @Step("Perform login & Assert Username is loggined")
    private void assertUsername() {
        // 3. Perform login
        indexPage.getHeader().performLogin(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert Username is loggined
        assertThat(indexPage.getHeader().getUserName()).as("Username is incorrect").isEqualTo("ROMAN IOVLEV");
    }

    @Step("Assert Different Elements logs")
    private void assertDifferentElementsLogs() {
        // 5. Open through the header menu Service -> Different Elements Page
        indexPage.getHeader().goToDifferentElements();
        initializeDifferentElementsPage();

        // 6. Select checkboxes
        differentElementsPage.selectLabel("Water");
        differentElementsPage.selectLabel("Wind");

        // 7. Select radio
        differentElementsPage.selectLabel("Selen");

        // 8. Select in dropdown
        differentElementsPage.selectOption("Yellow");

        /* 9. Assert that
        for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        for radio button there is a log row and value is corresponded to the status of radio button
        for dropdown there is a log row and value is corresponded to the selected value. */
        List<String> actualLogList = differentElementsPage.getLogs().getLogList();
        List<String> expectedLogList = List.of("Colors: value changed to Yellow", "metal: value changed to Selen",
                "Wind: condition changed to true", "Water: condition changed to true");
        assertThat(actualLogList).as("Log list is incorrect").isEqualTo(expectedLogList);
    }
}
