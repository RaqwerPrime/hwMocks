import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MessageSenderImplTest {
    @Mock
    private GeoService geoService;

    @Mock
     private LocalizationService localizationService;

    @InjectMocks
     private MessageSenderImpl messageSender;

    @Test
    public void sendReturnRussianTextRusIp() {
        String ip = "172.122.12.14";
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER,ip);

        Location rusLoc = new Location("Kazan", Country.RUSSIA,"Krasikova",10);
        when(geoService.byIp(ip)).thenReturn(rusLoc);
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        String result = messageSender.send(headers);

        Assertions.assertEquals("Добро пожаловать",result);
    }
    @Test
    public void sendReturnAmericanTextUsaIp() {
        String ip = "96.33.123.124";
        Map<String,String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER,ip);

        Location UsaLoc = new Location("Boston",Country.USA,"11 Stret",23);
        when(geoService.byIp(ip)).thenReturn(UsaLoc);
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        String result = messageSender.send(headers);

        Assertions.assertEquals("Welcome",result);

    }


}
