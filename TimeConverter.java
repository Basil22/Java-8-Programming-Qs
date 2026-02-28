package Java8;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Convert 12hr time to 24hr time
public class TimeConverter {

    public static String convert(String s) {

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mm:ssa", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime time = LocalTime.parse(s, inputFormatter);
        return time.format(outputFormatter);
    }

    public static void main(String[] args) {
        String input = "12:01:00PM";
        String result = convert(input);

        System.out.println(result);
    }
}
