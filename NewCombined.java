package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NewCombined {

    public static int sumOfSquaresOfEven() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        return list.stream().filter(i -> i % 2 == 0).map(i -> i * i).mapToInt(Integer::valueOf).sum();
    }

    public static List<String> listToUpAndSort() {
        List<String> list = Arrays.asList("banana", "apple", "cherry");
        return list.stream().map(i -> i.toUpperCase()).sorted().collect(Collectors.toList());
    }

    public static String avgMoreThan10() {
        List<Integer> list = Arrays.asList(5, 15, 8, 20, 3, 12);
        double value = list.stream().filter(i -> i > 10).mapToInt(Integer::valueOf).average().getAsDouble();
        return String.format("%.2f", value);
    }

    public static List<String> stringContainChar() {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "avocado");
        char f = 'a';
        return list.stream().filter(i -> i.contains(String.valueOf(f))).collect(Collectors.toList());
    }

    static class Employee {
        private String name;
        private String dept;
        private long salary;

        Employee(String name, String department, long salary) {
            this.name = name;
            this.dept = department;
            this.salary = salary;
        }

        public String getName() {
            return this.name;
        }

        public String getDepartment() {
            return this.dept;
        }

        public Long getSalary() {
            return this.salary;
        }

        @Override
        public String toString() {
            return "(" + this.name + ", " + this.dept + ", " + this.salary + ")";
        }
    }

    public static Map<String, Long> salaryPerDept() {
        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee("Alice", "IT", 90000);
        Employee e2 = new Employee("Bob", "IT", 80000);
        Employee e3 = new Employee("Charlie", "HR", 70000);
        list.add(e1);
        list.add(e2);
        list.add(e3);

        return list.stream().collect(
                Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new,
                        Collectors.summingLong(Employee::getSalary)));
    }

    public static void partitionIntoTwo() {
        List<Integer> list = Arrays.asList(5, 15, 8, 20, 3, 12);
        System.out.println(list.stream().collect(Collectors.partitioningBy(i -> i > 10)));
    }

    public static void totalChars() {
        List<String> list = Arrays.asList("apple", "banana", "kiwi");
        System.out.println(list.stream().map(i -> i.length()).mapToInt(Integer::valueOf).sum());
    }

    public static void salaryGreaterSorted() {
        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee("Alice", "IT", 90000);
        Employee e2 = new Employee("Bob", "IT", 60000);
        Employee e3 = new Employee("Charlie", "HR", 80000);
        list.add(e1);
        list.add(e2);
        list.add(e3);

        System.out.println(list.stream().filter(i -> i.getSalary() > 75000)
                .sorted(Comparator.comparing(Employee::getName)).map(i -> i.getName()).toList());
    }

    public static void flatAndFreq() {
        List<String> input = Arrays.asList("hello world", "hello java", "world java java");

        Map<String, Long> res = input.stream()
                .map(String::toLowerCase)
                .flatMap(i -> Arrays.stream(i.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println(res);
    }

    public static void secondHighestSal() {
        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee("Alice", "IT", 90000);
        Employee e2 = new Employee("Bob", "IT", 60000);
        Employee e3 = new Employee("Charlie", "HR", 80000);
        list.add(e1);
        list.add(e2);
        list.add(e3);

        long res = list.stream().sorted(Comparator.comparing((Employee i) -> i.getSalary())).skip(1)
                .findFirst().map(i -> i.getSalary()).get();

        System.out.println(res);
    }

    public static void allPairsSumEqualTarget() {
        int[] inp = { 1, 2, 3, 4, 5, 6 };
        int target = 7;

        Set<Integer> set = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();

        for (int num : inp) {
            int t = target - num;
            if (set.contains(t)) {
                pairs.add(new int[] { num, t });
            }
            set.add(num);
        }

        // Correct soln but check output format
        pairs.stream().forEach(i -> System.out.println(Arrays.toString(i)));

        // expected output format:
        // [(1,6), (2,5), (3,4)]

    }

    public static void sortDeptAndSal() {
        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee("Alice", "IT", 90000);
        Employee e2 = new Employee("Bob", "HR", 60000);
        Employee e3 = new Employee("Charlie", "IT", 80000);
        Employee e4 = new Employee("Dave", "HR", 70000);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        list.stream()
                .sorted(Comparator.comparing((Employee e) -> e.getDepartment())
                        .thenComparing(Comparator.comparing((Employee e) -> e.getSalary()).reversed()))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        // System.out.println(sumOfSquaresOfEven());
        // System.out.println(listToUpAndSort());
        // System.out.println(avgMoreThan10());
        // System.out.println(stringContainChar());
        // System.out.println(salaryPerDept());
        // partitionIntoTwo();
        // totalChars();
        // salaryGreaterSorted();
        // flatAndFreq();
        // secondHighestSal();
        // allPairsSumEqualTarget();
        sortDeptAndSal();
    }
}
