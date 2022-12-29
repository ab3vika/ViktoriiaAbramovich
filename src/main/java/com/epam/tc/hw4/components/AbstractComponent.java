package com.epam.tc.hw4.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {

    protected WebDriver webDriver;

    protected AbstractComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
}
