package com.epam.tc.hw6.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class AssertStep extends AbstractStep {

    public AssertStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Assert Browser title: {browserTitle}")
    public void assertBrowserTitle(String browserTitle) {
        assertThat(indexPage.getTitle()).as("Browser title is incorrect").isEqualTo(browserTitle);
    }

    @Step("Assert Username: {username}")
    public void assertUsername(String username) {
        assertThat(indexPage.getHeader().getUserName()).as("Username is incorrect").isEqualTo(username);
    }

    @Step("Assert Header items")
    public void assertHeaderItems(List<String> expectedMenuButtons) {
        List<String> actualMenuButtons = indexPage.getHeader().getMenuButtons();
        assertThat(actualMenuButtons.size()).as("Header items count is incorrect")
                .isEqualTo(expectedMenuButtons.size());
        assertThat(indexPage.getHeader().areMenuButtonsDisplayed()).as("Header items aren't displayed").isTrue();
        assertThat(actualMenuButtons).as("Header items are incorrect").isEqualTo(expectedMenuButtons);
    }

    @Step("Assert Images")
    public void assertImages(int expectedImagesCount) {
        assertThat(indexPage.areBenefitIconsDisplayed()).as("Images aren't displayed").isTrue();
        assertThat(indexPage.getBenefitIconsCount()).as("Images count is incorrect")
                .isEqualTo(expectedImagesCount);
    }

    @Step("Assert Image texts")
    public void assertImagesTexts(List<String> expectedBenefitTexts) {
        List<String> actualBenefitTexts = indexPage.getBenefitTexts();
        assertThat(indexPage.areBenefitTextsDisplayed()).as("Image texts aren't displayed").isTrue();
        assertThat(actualBenefitTexts).as("Image texts are incorrect").isEqualTo(expectedBenefitTexts);
    }

    @Step("Assert Iframe")
    public void assertIframe() {
        assertThat(indexPage.isFrameDisplayed()).as("Iframe isn't displayed").isTrue();
    }

    @Step("Assert Frame button")
    public void assertFrameButton(String frameButtonValue) {
        assertThat(indexPage.isFrameButtonDisplayed()).as("Frame button isn't displayed").isTrue();
        assertThat(indexPage.getFrameButtonValue()).as("Frame button value is incorrect")
                .isEqualTo(frameButtonValue);
    }

    @Step("Assert Left menu")
    public void assertLeftMenu(List<String> expectedLeftMenu) {
        List<String> actualLeftMenu = indexPage.getLeftSection().getLeftMenu();
        assertThat(actualLeftMenu.size()).as("Left menu count is incorrect").isEqualTo(expectedLeftMenu.size());
        assertThat(indexPage.getLeftSection().isLeftMenuDisplayed()).as("Left menu isn't displayed").isTrue();
        assertThat(actualLeftMenu).as("Left menu is incorrect").isEqualTo(expectedLeftMenu);
    }

    @Step("Assert Logs")
    public void assertLogs(List<String> expectedLogList) {
        List<String> actualLogList = differentElementsPage.getLogs().getLogList();
        assertThat(actualLogList).as("Log list is incorrect").isEqualTo(expectedLogList);
    }
}
