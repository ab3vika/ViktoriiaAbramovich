package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.BaseTest;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseTest {

    private static final int EXPECTED_IMAGES_COUNT = 4;

    @Test
    public void exercise1() {

        SoftAssertions softly = new SoftAssertions();

        // 1. Open test site by URL
        initializeIndexPage();
        indexPage.openSite(properties.getProperty("url"));

        // 2. Assert Browser title
        softly.assertThat(indexPage.getTitle()).as("Browser title is incorrect").isEqualTo("Home Page");

        // 3. Perform login
        indexPage.getHeader().performLogin(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert Username is loggined
        softly.assertThat(indexPage.getHeader().getUserName()).as("Username is incorrect").isEqualTo("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        List<String> actualMenuButtons = indexPage.getHeader().getMenuButtons();
        List<String> expectedMenuButtons = List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softly.assertThat(actualMenuButtons.size()).as("Header items count is incorrect")
                .isEqualTo(expectedMenuButtons.size());
        softly.assertThat(indexPage.getHeader().areMenuButtonsDisplayed()).as("Header items aren't displayed").isTrue();
        softly.assertThat(actualMenuButtons).as("Header items are incorrect").isEqualTo(expectedMenuButtons);

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        softly.assertThat(indexPage.areBenefitIconsDisplayed()).as("Images aren't displayed").isTrue();
        softly.assertThat(indexPage.getBenefitIconsCount()).as("Images count is incorrect")
                .isEqualTo(EXPECTED_IMAGES_COUNT);

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<String> actualBenefitTexts = indexPage.getBenefitTexts();
        List<String> expectedBenefitTexts = List.of(
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
        );
        softly.assertThat(indexPage.areBenefitTextsDisplayed()).as("Image texts aren't displayed").isTrue();
        softly.assertThat(actualBenefitTexts).as("Image texts are incorrect").isEqualTo(expectedBenefitTexts);

        // 8. Assert that there is the iframe with “Frame Button” exist
        softly.assertThat(indexPage.isFrameDisplayed()).as("Iframe isn't displayed").isTrue();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPage.switchToFrame();
        softly.assertThat(indexPage.isFrameButtonDisplayed()).as("Frame button isn't displayed").isTrue();
        softly.assertThat(indexPage.getFrameButtonValue()).as("Frame button value is incorrect")
                .isEqualTo("Frame Button");

        // 10. Switch to original window back
        indexPage.switchToDefault();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<String> actualLeftMenu = indexPage.getLeftSection().getLeftMenu();
        List<String> expectedLeftMenu = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors",
                "Elements packs");
        softly.assertThat(actualLeftMenu.size()).as("LeftMenu size is incorrect").isEqualTo(expectedLeftMenu.size());
        softly.assertThat(indexPage.getLeftSection().isLeftMenuDisplayed()).as("Left menu isn't displayed").isTrue();
        softly.assertThat(actualLeftMenu).as("Left menu is incorrect").isEqualTo(expectedLeftMenu);

        softly.assertAll();
    }
}
