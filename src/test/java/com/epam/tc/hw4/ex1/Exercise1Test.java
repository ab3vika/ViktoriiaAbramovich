package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseTest {

    private static final int EXPECTED_IMAGES_COUNT = 4;
    private static final String EXPECTED_FRAME_BUTTON_VALUE = "Frame Button";

    @Test
    @Feature("Test functionality of JDI site")
    @Story("Exercise 1 from hw4 test")
    public void exercise1() {

        actionStep.openSite(properties.getProperty("url"));
        assertStep.assertBrowserTitle("Home Page");

        actionStep.performLogin(properties.getProperty("username"), properties.getProperty("password"));
        assertStep.assertUsername("ROMAN IOVLEV");

        assertStep.assertHeaderItems(List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

        assertStep.assertImages(EXPECTED_IMAGES_COUNT);

        List<String> expectedBenefitTexts = List.of(
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
        );
        assertStep.assertImagesTexts(expectedBenefitTexts);

        assertStep.assertIframe();

        actionStep.switchToFrame();
        assertStep.assertFrameButton(EXPECTED_FRAME_BUTTON_VALUE);
        actionStep.switchToDefault();

        assertStep.assertLeftMenu(List.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));
    }
}
