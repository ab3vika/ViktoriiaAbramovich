package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorIsNegativeTest {

    @DataProvider
    public Object[][] isNegativeDataProvider() {
        return new Object[][] {
                {-1, true},
                {-100, true},
                {-10000, true}
        };
    }

    @Test(dataProvider = "isNegativeDataProvider")
    public void calculatorIsNegative(long a, boolean expected) {
        Calculator calculator = new Calculator();
        boolean actual = calculator.isNegative(a);
        assertThat(actual).isEqualTo(expected);
    }
}
