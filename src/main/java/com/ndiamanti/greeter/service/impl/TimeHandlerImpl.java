package com.ndiamanti.greeter.service.impl;

import com.ndiamanti.greeter.service.TimeHandler;

import java.time.LocalTime;

public class TimeHandlerImpl implements TimeHandler {

    public String getCurrentPartOfDay() {
        LocalTime currentTime = LocalTime.now();
        return getPartOfDayByLocalTime(currentTime);
    }

    public String getPartOfDayByLocalTime(LocalTime time) {
        if (isTimeInRange(time, MORNING_MIN, MORNING_MAX))
            return "morning";
        else if (isTimeInRange(time, EVENING_MIN, EVENING_MAX))
            return "evening";
        else if (isTimeInRange(time, MORNING_MAX, EVENING_MIN))
            return null;
        else
            return "night";
    }

    private boolean isTimeInRange(LocalTime time, LocalTime min, LocalTime max) {
        return time.isAfter(min) && time.isBefore(max);
    }
}
