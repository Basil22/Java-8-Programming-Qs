package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    public String name;
    public int age;
    public int salary;
    public String department;

    public Employee(String name, int age, int salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "(" + this.name + ", " + this.age + ", " + this.salary + ", " + this.department + ")";
    }

}

public class SortEmployeeObjects {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 30, 50000, "IT");
        Employee e2 = new Employee("Bob", 25, 60000, "HR");
        Employee e3 = new Employee("Charlie", 30, 50000, "IT");
        Employee e4 = new Employee("Dave", 25, 70000, "HR");

        List<Employee> input1 = Arrays.asList(e1, e2, e3, e4);

        // Example 1: Sort by salary ascending, if same, sort by name alphabetically
        List<Employee> output1 = input1.stream()
                .sorted(Comparator.comparing((Employee e) -> e.salary)
                        .thenComparing((Employee a) -> a.name))
                .collect(Collectors.toList());

        System.out.println(output1);

        /*
         * Example 2: Group each emp by department then within each dept, sort by salary
         * descending
         */

        // Approach 1: Close but wrong because of hashMap
        /*
         * Map<String, List<Employee>> output2 = input1.stream()
         * .sorted(Comparator.comparing((Employee e) -> e.salary).reversed()
         * .thenComparing((Employee e) -> e.name))
         * .collect(Collectors.groupingBy((Employee e) -> (String) e.department));
         * 
         */

        // Approach 2: Sort inside collect
        Map<String, List<Employee>> output2a = input1.stream()
                .collect(Collectors.groupingBy((Employee e) -> e.department,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream().sorted(Comparator.comparing((Employee e) -> e.name).reversed())
                                        .collect(Collectors.toList()))));

        System.out.println(output2a);

        // Example 3: Find the highest paid in each age group
        Map<Integer, Employee> output3 = input1.stream()
                .collect(Collectors.groupingBy((Employee e) -> (Integer) e.age,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream().max(Comparator.comparing((Employee e) -> e.salary)).get())));

        System.out.println(output3);

        /*
         * Example 4: sort by department name length, then by salary descending, then by
         * name alphabetically
         */
        List<String> output4 = input1.stream().sorted(Comparator.comparing((Employee e) -> e.department.length())
                .thenComparing(Comparator.comparing((Employee e) -> e.salary).reversed())
                .thenComparing((Employee e) -> e.name))
                .map(e -> e.name)
                .collect(Collectors.toList());

        System.out.println(output4);
    }
}
