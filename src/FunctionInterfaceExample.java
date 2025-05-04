import java.util.function.Function;

public class FunctionInterfaceExample {
    public static void main(String[] args) {
        // Function to calculate the area of a circle
        Function<Double, Double> areaOfCircle = radius -> Math.PI * radius * radius;

        // Input: radius of the circle
        double radius = 5.0;

        // Calculating the area using the Function interface
        double area = areaOfCircle.apply(radius);

        // Output: displaying the area
        System.out.println("Area of the circle with radius " + radius + " is: " + area);
    }
}
