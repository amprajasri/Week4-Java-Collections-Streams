public class ExceptionPropagationDemo {
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }

    public static void method1() {
        int result = 10 / 0;  // This will throw ArithmeticException
    }

    public static void method2() {
        method1();  // This calls method1, which throws the exception
    }
}
