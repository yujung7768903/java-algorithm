package common;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ExecutionTime {
    LocalDateTime before;
    LocalDateTime after;

    public ExecutionTime() {
        before = LocalDateTime.now();
        System.out.println("========== Execution Time ==========");
        System.out.println("before time: " + before);
    }

    public void measure() {
        after = LocalDateTime.now();
        System.out.println("after time: " + after);
        System.out.println("total time: " + ChronoUnit.SECONDS.between(before, after) + "s");
        System.out.println("total time: " + ChronoUnit.MILLIS.between(before, after) + "ms");
        System.out.println("total time: " + ChronoUnit.MICROS.between(before, after) + "µs");
        System.out.println("====================================");
    }
}
