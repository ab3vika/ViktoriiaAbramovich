package com.epam.tc.hw3.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractComponent {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = ".nav > li")
    private List<WebElement> menuButtons;

    @FindBy(className = "dropdown-toggle")
    private WebElement dropdownToggle;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

    public HeaderComponent(WebDriver webDriver) {
        super(webDriver);
    }

    public void performLogin(String name, String password) {
        this.userIcon.click();
        this.name.sendKeys(name);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }

    public List<String> getMenuButtons() {
        return menuButtons.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean areMenuButtonsDisplayed() {
        return menuButtons.stream().allMatch(WebElement::isDisplayed);
    }

    public void goToDifferentElements() {
        dropdownToggle.click();
        differentElements.click();
    }
}
