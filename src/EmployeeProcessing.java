import java.util.*;
import java.util.stream.*;
import java.text.DecimalFormat;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (" + department + ") - $" + salary;
    }
}

public class EmployeeProcessing {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 95000),
                new Employee(2, "Bob", "Engineering", 75000),
                new Employee(3, "Charlie", "HR", 65000),
                new Employee(4, "David", "Engineering", 87000),
                new Employee(5, "Eve", "Marketing", 70000),
                new Employee(6, "Frank", "Engineering", 99000)
        );

        // 1. Filter
        List<Employee> filtered = employees.stream()
                .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
                .collect(Collectors.toList());

        // 2. Sort by salary descending
        filtered.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        // 3. Group by department
        Map<String, List<Employee>> grouped = filtered.stream()
                .collect(Collectors.groupingBy(e -> e.department));

        // 4. Calculate average salary per department
        Map<String, Double> averageSalary = grouped.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream().mapToDouble(emp -> emp.salary).average().orElse(0)
                ));

        // Output
        System.out.println("Filtered, Sorted and Grouped Employees:");
        grouped.forEach((dept, empList) -> {
            System.out.println("\nDepartment: " + dept);
            empList.forEach(System.out::println);
        });

        System.out.println("\nAverage Salary per Department:");
        DecimalFormat df = new DecimalFormat("#.##");
        averageSalary.forEach((dept, avg) ->
                System.out.println(dept + ": $" + df.format(avg))
        );
    }
}
