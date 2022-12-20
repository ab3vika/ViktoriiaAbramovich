package com.epam.tc.hw3.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogsComponent extends AbstractComponent {

    @FindBy(css = ".panel-body-list > li")
    private List<WebElement> logList;

    public LogsComponent(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getLogList() {
        return logList.stream().map(e -> e.getText().substring(9)).collect(Collectors.toList());
    }
}
