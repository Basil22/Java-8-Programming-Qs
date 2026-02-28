package Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Get the min sum and max sum in a list. Restrict to 4 digits.

public class MinMaxSum {

    public static void minMaxSum(List<Integer> input) {
        // if (input.size() > 5)
        // System.out.println("More than 4");

        // int total = input.stream().mapToInt(Integer::valueOf).sum();
        // int maxValue = input.stream().mapToInt(Integer::valueOf).max().getAsInt();
        // int minValue = input.stream().mapToInt(Integer::valueOf).min().getAsInt();

        // System.out.println((total - maxValue) + " " + (total - minValue));

        Collections.sort(input);

        long minSum = 0;
        long maxSum = 0;
        for (int i = 0; i < 4; i++) {
            minSum += input.get(i);
            maxSum += input.get(i + 1);
        }

        System.out.println(minSum + " " + maxSum);
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        minMaxSum(input);
    }
}
