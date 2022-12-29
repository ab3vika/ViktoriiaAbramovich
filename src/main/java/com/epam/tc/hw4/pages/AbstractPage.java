package com.epam.tc.hw4.pages;

import com.epam.tc.hw4.components.HeaderComponent;
import com.epam.tc.hw4.components.LeftSectionComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected WebDriver webDriver;
    private HeaderComponent headerComponent;
    private LeftSectionComponent leftSectionComponent;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
        headerComponent = new HeaderComponent(this.webDriver);
        leftSectionComponent = new LeftSectionComponent(this.webDriver);
    }

    public void openSite(String url) {
        webDriver.navigate().to(url);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void switchToDefault() {
        webDriver.switchTo().defaultContent();
    }

    public HeaderComponent getHeader() {
        return headerComponent;
    }

    public LeftSectionComponent getLeftSection() {
        return leftSectionComponent;
    }
}
