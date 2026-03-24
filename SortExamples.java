package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortExamples {
        public static void main(String[] args) {

                // Example 1: Sort by Length of each string
                List<String> input = Arrays.asList("banana", "apple", "kiwi", "mango");

                List<String> output = input.stream()
                                .sorted(Comparator.comparing(String::length))
                                .collect(Collectors.toList());

                // System.out.println(output);

                // Example 2: Search by length (Case Insensitive)
                List<String> input2 = Arrays.asList("Banana", "apple", "Cherry", "mango");

                List<String> output2 = input2.stream()
                                .sorted(Comparator.comparing(String::toLowerCase))
                                .collect(Collectors.toList());

                // System.out.println(output2);

                // Example 3: Sort by last character of String
                List<String> input3 = Arrays.asList("banana", "apple", "kiwi", "mango");

                List<String> output3 = input3.stream()
                                .sorted(Comparator.comparing(a -> a.charAt(a.length() - 1)))
                                .collect(Collectors.toList());

                // System.out.println(output3);

                // Example 4: Sort by number of vowels

                List<String> input4 = Arrays.asList("apple", "fig", "banana", "kiwi", "orange");

                // Approach 1: works but not good.

                /*
                 * List<String> output4 = input4.stream()
                 * .sorted(Comparator.comparing((a) -> {
                 * int vowelCount = 0;
                 * 
                 * for (int i = 0; i < a.length(); i++) {
                 * if (a.toLowerCase().charAt(i) == 'a' || a.toLowerCase().charAt(i) == 'e'
                 * || a.toLowerCase().charAt(i) == 'i'
                 * || a.charAt(i) == 'o' || a
                 * .toLowerCase().charAt(i) == 'u') {
                 * vowelCount++;
                 * }
                 * }
                 * return vowelCount;
                 * }))
                 * .collect(Collectors.toList());
                 */

                // Approach 2: Create a helper function to keep stream readable.
                List<String> output4 = input4.stream()
                                .sorted(Comparator.comparing((String a) -> countVowels(a))
                                                .thenComparingInt((String a) -> a.length()))
                                .collect(Collectors.toList());

                System.out.println(output4);
        }

        // Helper function to count vowels
        public static int countVowels(String s) {
                return (int) s.toLowerCase()
                                .chars()
                                .filter(c -> "aeiou".indexOf(c) >= 0)
                                .count();
        }
}
