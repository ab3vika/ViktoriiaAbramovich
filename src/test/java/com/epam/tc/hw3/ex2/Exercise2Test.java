package com.epam.tc.hw3.ex2;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.BaseTest;
import java.util.List;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseTest {

    @Test
    public void exercise2() {

        // 1. Open test site by URL
        initializeIndexPage();
        indexPage.openSite(properties.getProperty("url"));

        // 2. Assert Browser title
        assertThat(indexPage.getTitle()).as("Browser title").isEqualTo("Home Page");

        // 3. Perform login
        indexPage.header().performLogin(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert Username in the left-top side of screen that user is loggined
        assertThat(indexPage.header().getUserName()).as("Username").isEqualTo("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        indexPage.header().goToDifferentElements();
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
        List<String> actualLogList = differentElementsPage.logs().getLogList();
        List<String> expectedLogList = List.of("Colors: value changed to Yellow", "metal: value changed to Selen",
                "Wind: condition changed to true", "Water: condition changed to true");
        assertThat(actualLogList).as("Log list").isEqualTo(expectedLogList);
    }
}
