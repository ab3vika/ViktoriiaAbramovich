package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.offset;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorCosTest {

    @DataProvider
    public Object[][] cosDataProvider() {
        return new Object[][] {
                {0, 1},
                {Math.PI / 2, 0},
                {Math.PI, -1}
        };
    }

    //These tests fail because calculator.cos(a) uses Math.sin(a)
    @Test(dataProvider = "cosDataProvider")
    public void calculatorCos(double a, double expected) {
        Calculator calculator = new Calculator();
        double actual = calculator.cos(a);
        assertThat(actual).isCloseTo(expected, offset(1E-10));
    }
}
