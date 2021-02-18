package com.ndiamanti.greeter;

import java.time.LocalTime;

public class Greeter {

    private LocalTime time;

    public Greeter() {
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String greet(String name) {
        if (name != null)
            name = trimAndCapitalizeFirstLetter(name);
        else
            throw new NullNameException();

        if (isTimeInRange(LocalTime.of(6, 0), LocalTime.of(12, 0)))
            return "Good morning " + name;
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
