package Java8;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {
    public static void main(String[] args) {
        String input = "Java articles are Awesome";

        char result = input.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(value -> value.getValue() == 1L)
                .map(key -> key.getKey())
                .findFirst().get();

        System.out.println(result);

    }
}
