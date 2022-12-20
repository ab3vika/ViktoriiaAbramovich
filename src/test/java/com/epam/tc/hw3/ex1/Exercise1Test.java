package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.BaseTest;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseTest {

    @Test
    public void exercise1() {

        SoftAssertions softly = new SoftAssertions();

        // 1. Open test site by URL
        initializeIndexPage();
        indexPage.openSite(properties.getProperty("url"));

        // 2. Assert Browser title
        softly.assertThat(indexPage.getTitle()).as("Browser title").isEqualTo("Home Page");

        // 3. Perform login
        indexPage.header().performLogin(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert Username is loggined
        softly.assertThat(indexPage.header().getUserName()).as("Username").isEqualTo("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        List<String> actualMenuButtons = indexPage.header().getMenuButtons();
        List<String> expectedMenuButtons = List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softly.assertThat(indexPage.header().areMenuButtonsDisplayed()).as("Header items display").isTrue();
        softly.assertThat(actualMenuButtons).as("Header items").isEqualTo(expectedMenuButtons);

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        softly.assertThat(indexPage.areBenefitIconsDisplayed()).as("Images display").isTrue();
        softly.assertThat(indexPage.getBenefitIconsCount()).as("Images count").isEqualTo(4);

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<String> actualBenefitTexts = indexPage.getBenefitTexts();
        List<String> expectedBenefitTexts = List.of(
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
        );
        softly.assertThat(indexPage.areBenefitTextsDisplayed()).as("Image texts display").isTrue();
        softly.assertThat(actualBenefitTexts).as("Image texts").isEqualTo(expectedBenefitTexts);

        // 8. Assert that there is the iframe with “Frame Button” exist
        softly.assertThat(indexPage.isFrameDisplayed()).as("Iframe display").isTrue();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPage.switchToFrame();
        softly.assertThat(indexPage.isFrameButtonDisplayed()).as("Frame button display").isTrue();
        softly.assertThat(indexPage.getFrameButtonValue()).as("Frame button value").isEqualTo("Frame Button");

        // 10. Switch to original window back
        indexPage.switchToDefault();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<String> actualLeftMenu = indexPage.leftSection().getLeftMenu();
        List<String> expectedLeftMenu = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors",
                "Elements packs");
        softly.assertThat(indexPage.leftSection().isLeftMenuDisplayed()).as("Left menu display").isTrue();
        softly.assertThat(actualLeftMenu).as("Left menu").isEqualTo(expectedLeftMenu);

        softly.assertAll();
    }
}
