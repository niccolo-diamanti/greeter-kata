package com.ndiamanti.greeter;

public class Greeter {

    public String greet(String name) {
        name = name.trim();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return "Hello " + name;
    }
}
