package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

public class LocalizationServiceImplTest {
    private LocalizationServiceImpl localizationService;

    @BeforeEach
    public void init() {
        localizationService = new LocalizationServiceImpl();
    }

    public static Stream<Arguments> CountryReturnMessage() {
        return Stream.of(
                Arguments.of(Country.RUSSIA,"Добро пожаловать"),
                Arguments.of( Country.USA,"Welcome"),
                Arguments.of( Country.BRAZIL,"Welcome"),
                Arguments.of(Country.GERMANY,"Welcome")
        );
    }

    @ParameterizedTest
    @MethodSource("CountryReturnMessage")
    public void returningTheCorrectMessageByCountry(Country country, String expected) {
        String result = localizationService.locale(country);
        Assertions.assertEquals(expected, result);


    }
}