package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseTest {

    @Test
    @Feature("Test functionality of JDI site")
    @Story("Exercise 2 from hw4 test")
    public void exercise2() {

        actionStep.openSite(properties.getProperty("url"));
        assertStep.assertBrowserTitle("Home Page");

        actionStep.performLogin(properties.getProperty("username"), properties.getProperty("password"));
        assertStep.assertUsername("ROMAN IOVLEV");

        assertStep.assertHeaderItems(List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

        actionStep.goToDifferentElements();
        actionStep.selectLabel("Water");
        actionStep.selectLabel("Wind");
        actionStep.selectLabel("Selen");
        actionStep.selectOption("Yellow");
        assertStep.assertLogs(List.of("Colors: value changed to Yellow", "metal: value changed to Selen",
                "Wind: condition changed to true", "Water: condition changed to true"));
    }
}
