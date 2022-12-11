package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSumTest {

    @DataProvider
    public Object[][] sumDataProvider() {
        return new Object[][] {
                {1, 2, 3},
                {10, 0, 10},
                {-5, 5, 0}
        };
    }

    @Test(dataProvider = "sumDataProvider")
    public void calculatorSum(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
