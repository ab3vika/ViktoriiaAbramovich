package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.components.LogsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends AbstractPage {

    private static final String LABEL_LOCATOR = "//label[normalize-space() = '%s']";
    private static final String OPTION_LOCATOR = "//option[normalize-space() = '%s']";
    private LogsComponent logsComponent;

    @FindBy(className = "colors")
    private WebElement colors;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        logsComponent = new LogsComponent(this.webDriver);
    }

    public void selectLabel(String value) {
        webDriver.findElement(By.xpath(String.format(LABEL_LOCATOR, value))).click();
    }

    public void selectOption(String value) {
        colors.click();
        webDriver.findElement(By.xpath(String.format(OPTION_LOCATOR, value))).click();
    }

    public LogsComponent logs() {
        return logsComponent;
    }
}
