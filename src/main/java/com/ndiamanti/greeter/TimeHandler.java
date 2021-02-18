package com.ndiamanti.greeter;

import java.time.LocalTime;

public interface TimeHandler {

    LocalTime MORNING_MIN = LocalTime.of(6, 0);
    LocalTime MORNING_MAX = LocalTime.of(12, 0);
    LocalTime EVENING_MIN = LocalTime.of(18, 0);
    LocalTime EVENING_MAX = LocalTime.of(22, 0);

    String getCurrentPartOfDay();

    String getPartOfDayByLocalTime(LocalTime time);
}
