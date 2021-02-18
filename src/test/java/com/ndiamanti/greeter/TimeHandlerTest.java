package com.ndiamanti.greeter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.ndiamanti.greeter.TimeHandler.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class TimeHandlerTest {

    private final TimeHandlerImpl timeHandler = new TimeHandlerImpl();

    @Test
    void getPartOfDayByLocalTime_shouldReturnMorning() {
        String partOfDay = timeHandler.getPartOfDayByLocalTime(MORNING_MIN.plusMinutes(1));
        assertEquals("morning", partOfDay);
    }

    @Test
    void getPartOfDayByLocalTime_shouldReturnEvening() {
        String partOfDay = timeHandler.getPartOfDayByLocalTime(EVENING_MIN.plusMinutes(1));
        assertEquals("evening", partOfDay);
    }

    @Test
    void getPartOfDayByLocalTime_shouldReturnNight() {
        String partOfDay = timeHandler.getPartOfDayByLocalTime(EVENING_MAX.plusMinutes(1));
        assertEquals("night", partOfDay);
    }

    @Test
    void getPartOfDayByLocalTime_shouldReturnNull() {
        String partOfDay = timeHandler.getPartOfDayByLocalTime(MORNING_MAX.plusMinutes(1));
        assertNull(partOfDay);
    }
}