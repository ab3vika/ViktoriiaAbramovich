package com.epam.tc.hw3.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends AbstractPage {

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTexts;

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
    }

    public int getBenefitIconsCount() {
        return benefitIcons.size();
    }

    public boolean areBenefitIconsDisplayed() {
        return benefitIcons.stream().allMatch(WebElement::isDisplayed);
    }

    public List<String> getBenefitTexts() {
        return benefitTexts.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean areBenefitTextsDisplayed() {
        return benefitTexts.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean isFrameDisplayed() {
        return frame.isDisplayed();
    }

    public void switchToFrame() {
        webDriver.switchTo().frame(frame);
    }

    public boolean isFrameButtonDisplayed() {
        return frameButton.isDisplayed();
    }

    public String getFrameButtonValue() {
        return frameButton.getAttribute("value");
    }
}
