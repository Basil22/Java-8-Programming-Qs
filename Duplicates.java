package Java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Duplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32);
        Set<Integer> dupeSet = new HashSet<>();

        list.stream().filter(a -> !dupeSet.add(a)).forEach(System.out::println);

    }
}
