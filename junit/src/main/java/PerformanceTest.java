public class PerformanceTest {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Simulate long task (3 seconds)
        return "Completed";
    }
}
