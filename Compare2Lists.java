package Java8;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Compare2Lists {

    public static List<Integer> marks(List<Integer> a, List<Integer> b) {
        // Core Java Approach:

        // List<Integer> result = new ArrayList<>();
        // int marksA = 0;
        // int marksB = 0;

        // for (int i = 0; i < a.size(); i++) {
        // if (a.get(i) > b.get(i)) {
        // marksA++;
        // } else if (a.get(i) < b.get(i)) {
        // marksB++;
        // } else {
        // continue;
        // }
        // }

        // result.add(marksA);
        // result.add(marksB);

        // return result;

        // Java 8 Approach:

        int aSc = IntStream.range(0, 3)
                .map(i -> a.get(i) > b.get(i) ? 1 : 0)
                .sum();

        int bSc = IntStream.range(0, 3)
                .map(i -> a.get(i) < b.get(i) ? 1 : 0)
                .sum();

        return Arrays.asList(aSc, bSc);
    }

    public static void main(String[] args) {
        List<Integer> result = marks(Arrays.asList(1, 2, 3), Arrays.asList(3, 2, 1));
        System.out.println(result);
    }
}
