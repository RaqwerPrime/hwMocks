package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class GeoServiceImplTest {
    private GeoServiceImpl geoService;

    @BeforeEach
    public void init() {
        geoService = new GeoServiceImpl();
    }

    public static Stream<Arguments> CountryIp() {
        return Stream.of(
                Arguments.of("172.33.123.124", Country.RUSSIA),
                Arguments.of("96.22.44.2.1", Country.USA),
                Arguments.of("172.0.32.11", Country.RUSSIA)
        );
    }

    @ParameterizedTest
    @MethodSource("CountryIp")
    public void returnsAreStrangeByIp(String ip, Country expected) {
        Location location = geoService.byIp(ip);
        Assertions.assertEquals(expected, location.getCountry());
    }


    @Test
    public void byIpUnknown() {
        String ipUnknown = "11.44.22.1.4";
        Location location = geoService.byIp(ipUnknown);
        Assertions.assertNull(location);
    }

}