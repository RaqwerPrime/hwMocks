import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {
    @Test
    public void byIpRussianTest() {
        String ipRussian = "172.33.123.124";
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp(ipRussian);
        Assertions.assertEquals(Country.RUSSIA,location.getCountry());
    }
    @Test
    public void byIpUsaTest() {
        String ipUsa = "96.22.44.2.1";
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp(ipUsa);
        Assertions.assertEquals(Country.USA,location.getCountry());
    }
    @Test
    public void byIpUnknown() {
        String ipUnknown = "11.44.22.1.4";
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp(ipUnknown);
        Assertions.assertNull(location);
    }
    @Test
    public void byIpMoscowTest() {
        String ipMoscow = "172.0.32.11";
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp(ipMoscow);
        Assertions.assertEquals(Country.RUSSIA, location.getCountry());
        Assertions.assertEquals("Moscow", location.getCity());
    }

}
