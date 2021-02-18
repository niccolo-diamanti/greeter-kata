package com.ndiamanti.greeter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class GreeterTest {

    final String NAME = "test";

    @Test
    public void greet_shouldReturnHelloWithName() {
        Greeter greeter = new Greeter();
        String greet = greeter.greet(NAME);

        assertEquals(greet, "Hello " + NAME);
    }

    @Test
    public void greet_shouldTrimsInput() {
        Greeter greeter = new Greeter();
        String greet = greeter.greet(" " + NAME + " ");

        assertEquals(greet, "Hello " + NAME);
    }
}