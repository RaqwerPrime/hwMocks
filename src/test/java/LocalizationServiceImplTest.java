import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {

    @Test
    public void localeRussiaTest() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals("Добро пожаловать",result);
    }

    @Test
    public void localeUsaTest() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(Country.USA);
        Assertions.assertEquals("Welcome",result);
    }

    @Test
    public void localeGermanyTest() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(Country.GERMANY);
        Assertions.assertEquals("Welcome",result);
    }

    @Test
    public void localeBrazilTest() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(Country.BRAZIL);
        Assertions.assertEquals("Welcome",result);
    }
}
