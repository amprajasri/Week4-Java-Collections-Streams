import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + " - Age: " + age + ", Salary: $" + salary;
    }
}

public class SortPersonList {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30, 60000));
        people.add(new Person("Bob", 25, 55000));
        people.add(new Person("Charlie", 35, 70000));
        people.add(new Person("David", 28, 50000));

        // Sort by age in ascending order using lambda
        people.sort((p1, p2) -> Integer.compare(p1.age, p2.age));

        // Print sorted list
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
