package java8;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutLocalTime {

    @Test
    public void localTime() {
        LocalTime t1 = LocalTime.of(7, 30);
        assertEquals(t1, LocalTime.parse(__));
    }

    @Test
    public void localTimeMinus() {
        LocalTime t1 = LocalTime.parse("10:30");
        LocalTime t2 = t1.minus(2, ChronoUnit.HOURS);
        assertEquals(t2, LocalTime.parse(__));
    }

}
