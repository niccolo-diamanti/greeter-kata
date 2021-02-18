package com.ndiamanti.greeter;

public class GreeterImpl implements Greeter {

    private final TimeHandlerImpl timeHandler;

    public GreeterImpl(TimeHandlerImpl timeHandler) {
        this.timeHandler = timeHandler;
    }

    @Override
    public String greet(String name) {
        if (name != null)
            name = trimAndCapitalizeFirstLetter(name);
        else
            throw new NullNameException();

        String partOfDay = timeHandler.getCurrentPartOfDay();
        if (partOfDay != null)
            return "Good " + partOfDay + " " + name;
        else
            return "Hello " + name;
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
