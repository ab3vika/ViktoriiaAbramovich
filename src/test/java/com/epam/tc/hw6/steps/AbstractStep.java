package com.epam.tc.hw6.steps;

import com.epam.tc.hw6.pages.DifferentElementsPage;
import com.epam.tc.hw6.pages.IndexPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected IndexPage indexPage;
    protected DifferentElementsPage differentElementsPage;

    protected AbstractStep(WebDriver webDriver) {
        indexPage = new IndexPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }
}
