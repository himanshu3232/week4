package basic;

import org.example.junit.basic.TaskUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

public class TaskUtilsTest {
    @Test
    @Timeout(2) // Test should fail if it runs longer than 2 seconds
    void testLongRunningTask() {
        assertEquals("Task Completed", TaskUtils.longRunningTask(), "Task should complete successfully");
    }
}