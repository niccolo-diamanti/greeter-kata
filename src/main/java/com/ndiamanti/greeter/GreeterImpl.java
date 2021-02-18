package com.ndiamanti.greeter;

import java.time.LocalTime;

public class GreeterImpl implements Greeter {

    private LocalTime time;

    public GreeterImpl() {
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String greet(String name) {
        if (name != null)
            name = trimAndCapitalizeFirstLetter(name);
        else
            throw new NullNameException();

        if (isTimeInRange(MORNING_MIN, MORNING_MAX))
            return "Good morning " + name;
        else if (isTimeInRange(EVENING_MIN, EVENING_MAX))
            return "Good evening " + name;
        else
            return "Hello " + name;
    }

    private boolean isTimeInRange(LocalTime min, LocalTime max) {
        return time != null && time.isAfter(min) && time.isBefore(max);
    }

    private String trimAndCapitalizeFirstLetter(String str) {
        str = str.trim();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static class NullNameException extends RuntimeException {

        public NullNameException() {
            super("Name parameter cannot be null");
        }
    }
}
