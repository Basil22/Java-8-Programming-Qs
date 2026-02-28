package Java8;

import java.util.Arrays;
import java.util.List;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        int n = arr.size();

        long positive = arr.stream().filter(i -> i != 0 && i > 0).count();
        long negative = arr.stream().filter(i -> i != 0 && i < 0).count();
        long zero = arr.stream().filter(i -> i == 0).count();

        System.out.println(String.format("%.6f", ((float) positive / n)));
        System.out.println(String.format("%.6f", ((float) negative / n)));
        System.out.println(String.format("%.6f", ((float) zero / n)));

    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(-4, 3, -9, 0, 4, 1);
        plusMinus(arr);
    }
}
