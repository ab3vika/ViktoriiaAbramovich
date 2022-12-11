package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSinTest {

    @DataProvider
    public Object[][] sinDataProvider() {
        return new Object[][] {
                {0, 0},
                {Math.PI / 2, 1},
                {Math.PI, 0}
        };
    }

    @Test(dataProvider = "sinDataProvider")
    public void calculatorSin(double a, double expected) {
        Calculator calculator = new Calculator();
        double actual = Math.round(calculator.sin(a));
        assertThat(actual).isEqualTo(expected);
    }
}
