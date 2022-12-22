package com.epam.tc.hw3.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSectionComponent extends AbstractComponent {

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftMenu;

    public LeftSectionComponent(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getLeftMenu() {
        return leftMenu.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isLeftMenuDisplayed() {
        return leftMenu.stream().allMatch(WebElement::isDisplayed);
    }
}
