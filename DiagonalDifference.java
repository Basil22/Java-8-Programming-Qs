package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DiagonalDifference {

    public static int diff(List<List<Integer>> ar) {

        if (ar.size() != ar.get(0).size())
            return 0;

        int n = ar.size();

        int prDiag = IntStream.range(0, n).map(i -> ar.get(i).get(i)).sum();
        int seDiag = IntStream.range(0, n).map(i -> ar.get(i).get(n - 1 - i)).sum();

        return Math.abs(prDiag - seDiag);
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(Arrays.asList(11, 2, 4), Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12));

        int result = diff(arr);
        System.out.println(result);
    }
}
