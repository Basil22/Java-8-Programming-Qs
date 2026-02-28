package Java8;

import java.util.Arrays;
import java.util.List;

public class SumOfElements {

    public static long bigSum(List<Long> ar) {

        long result = ar.stream().mapToLong(Long::valueOf).sum();
        return result;
    }

    public static void main(String[] args) {
        List<Long> input = Arrays.asList(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);
        long result = bigSum(input);
        System.out.println(result);
    }
}
