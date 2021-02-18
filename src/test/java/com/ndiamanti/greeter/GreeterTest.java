package com.ndiamanti.greeter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class GreeterTest {

    private final Greeter greeter = new Greeter();

    @Test
    public void greet_shouldReturnHelloWithName() {
        String greet = greeter.greet("name");
        assertEquals(greet, "Hello Name");
    }

    @Test
    public void greet_shouldTrimsInput() {
        String greet = greeter.greet(" name ");
        assertEquals(greet, "Hello Name");
    }

    @Test
    public void greet_shouldCapitalizeFirstLetterOfInput() {
        String greet = greeter.greet("name");
        assertEquals(greet, "Hello Name");
    }
}