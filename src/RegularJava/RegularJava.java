import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularJava {
    public static boolean isIP(String ip)
    {
        //Регулярное выражение для определения IP-адреса
        String pattern = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";


        //Проверка октетов на принадлежность диапазону от 0 до 255
        if (Pattern.matches(pattern, ip))
        {
            String[] numbers = ip.split("\\.");

            for (String num : numbers)
            {
                if (Integer.parseInt(num) > 255 || Integer.parseInt(num) < 0)
                    return false;
            }
            return true;
        }
        else return false;
    }

    public static boolean isGUID(String str)
    {
        //String pattern = "^[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}$";
        String pattern = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

        if (Pattern.matches(pattern, str)) return true;
        return false;
    }

    public static boolean isURL(String url)
    {
        Pattern patternIp = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
        Matcher m = patternIp.matcher(url);
        if (m.find()) return false;
        else {
            String pattern = "^(https?://)?([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9](\\.[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]+)+)(:[0-9]+)?(/[^?#]*)?(\\?[^#]*=.*)?(#.*)?$";

            if (Pattern.matches(pattern, url)) return true;
            return false;
        }
    }

    public static boolean isValidPassword(String pw)
    {
        String pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9_]{8,}$"; //?= - заглядывание вперёд

        if (Pattern.matches(pattern, pw))
            return true;
        return false;
    }
}
