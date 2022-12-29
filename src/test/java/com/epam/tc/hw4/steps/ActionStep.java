package com.epam.tc.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Open site: {url}")
    public void openSite(String url) {
        indexPage.openSite(url);
    }

    @Step("Perform login: {username}|{password}")
    public void performLogin(String username, String password) {
        indexPage.getHeader().performLogin(username, password);
    }

    @Step("Switch to frame")
    public void switchToFrame() {
        indexPage.switchToFrame();
    }

    @Step("Switch to default")
    public void switchToDefault() {
        indexPage.switchToDefault();
    }

    @Step("Go to Different Elements")
    public void goToDifferentElements() {
        indexPage.getHeader().goToDifferentElements();
    }

    @Step("Select label: {label}")
    public void selectLabel(String label) {
        differentElementsPage.selectLabel(label);
    }

    @Step("Select option: {option}")
    public void selectOption(String option) {
        differentElementsPage.selectOption(option);
    }
}
