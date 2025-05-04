import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class PerformanceTestTest {

    PerformanceTest task = new PerformanceTest();

    @Test
    @Timeout(value = 4, unit = TimeUnit.SECONDS)  // Increase to 4 seconds
    void testLongRunningTaskTimeout() throws InterruptedException {
        String result = task.longRunningTask();
        assertEquals("Completed", result);
    }

}
