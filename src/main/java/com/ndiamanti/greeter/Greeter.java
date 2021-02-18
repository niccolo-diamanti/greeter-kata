package com.ndiamanti.greeter;

public class Greeter {

    public String greet(String name) {
        name = name.trim();
        return "Hello " + name;
    }
}
