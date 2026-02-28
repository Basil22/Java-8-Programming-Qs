package Java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOfEachCharInString {
    public static void main(String[] args) {
        String inp = "malayalam";

        Map<Character, Long> result = inp.chars().mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));

        System.out.println(result);
    }
}
