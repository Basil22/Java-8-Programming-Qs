package Java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValueAppearsTwice {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> newSet = new HashSet<>();
        return Arrays.stream(nums).anyMatch(a -> !newSet.add(a));
    }

    public static void main(String[] args) {
        boolean result = containsDuplicate(new int[] { 1, 2, 3, 4 });
        System.out.println(result);
    }
}
