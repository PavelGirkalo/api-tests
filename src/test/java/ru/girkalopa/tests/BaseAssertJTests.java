package ru.girkalopa.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Base tests from Girkalo Pavel")
@Feature("Base AssertJ tests")
public class BaseAssertJTests {

    @DisplayName("Positive test")
    @Test
    void positiveTest() {
        assertThat(1 == Integer.parseInt("1"))
                .as("1 is not equal to 0")
                .isTrue();
    }

    @DisplayName("Negative test")
    @Test
    void negativeTest() {
        assertThat(1 == Integer.parseInt("0"))
                .as("1 is not equal to 0")
                .isTrue();
    }
}
