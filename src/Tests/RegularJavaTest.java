import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RegularJavaTest {

    @ParameterizedTest
    @ValueSource(strings = {"127.0.0.1", "255.255.255.0", "215.35.56.0", "107.44.225.100", "143.150.135.178", "197.65.221.228"})
    void validIp(String ip) {
        assertTrue(RegularJava.isIP(ip));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1300.6.7.8", "abc.def.gha.bcd", "17.254.134.1.154", "255.f.13.22", "845.221.0.4", "111,55.66.7"})
    void invalidIp(String ip)
    {
        assertFalse(RegularJava.isIP(ip));
    }

    @ParameterizedTest
    @ValueSource(strings = {"e02fd0e4-00fd-090A-ca30-0d00a0038ba0"})
    void validGuid(String guid)
    {
        assertTrue(RegularJava.isGUID(guid));
    }

    @ParameterizedTest
    @ValueSource(strings = {"e02fd0e400fd090Aca300d00a0038ba0", "e02fd0e400fpz090Aca307db0a0038ba0"})
    void invalidGuid(String guid) {
        assertFalse(RegularJava.isGUID(guid));
    }

    @ParameterizedTest
    @ValueSource(strings = {"www.google.com",
            "http://www.example.com/",
            "https://en.wikipedia.org/wiki/Main_Page",
            "http://example.com/",
            "https://www.kimono.com/research/",
            "https://www.cadr.com?page=value"
    })
    void validUrl(String url) {
        assertTrue(RegularJava.isURL(url));
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://example", //недостаточно доменных частей
            "https://123.45.67.89", //ip адрес
            "http://", //нет доменного имени
            "http://invalid!url.com/", //символ "!" не допустим
            "https://a.com/", //некорректный домен
            "https://www.cadr.com?page", //некорректный запрос
            "www.-badwork.com"
    })
    void invalidUrl(String url)
    {
        assertFalse(RegularJava.isURL(url));
    }

    @ParameterizedTest
    @ValueSource(strings = {"C00l_Pass", //недостаточно доменных частей
            "SupperPas1", //ip адрес
            "MyVeryCoo1pass", //нет доменного имени
            "SuperH0t_", //символ "!" не допустим
            "Stray228", //некорректный домен
            "Password_OU74" //некорректный запрос
    })
    void validPassword(String pw) {
        assertTrue(RegularJava.isValidPassword(pw));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Cool_pass", //недостаточно доменных частей
            "C00l", //ip адрес
            "Cool_Pass", //нет доменного имени
            "16554665", //символ "!" не допустим
            "_MyPassword", //некорректный домен
            "MyPassword" //некорректный запрос
    })
    void invalidPassword(String pw)
    {
        assertFalse(RegularJava.isValidPassword(pw));
    }

}