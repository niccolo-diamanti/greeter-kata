package com.ndiamanti.greeter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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

    @Test
    public void greet_shouldThrowExceptionIfNameIsNull() {
        Throwable exception = assertThrows(Greeter.NullNameException.class, () -> greeter.greet(null));
        assertEquals("Name parameter cannot be null", exception.getMessage());
    }

    @Test
    public void greet_shouldReturnGoodMorningIfTimeIsInRange() {
        greeter.setTime(LocalTime.of(6, 1));
        String greet = greeter.greet("name");
        assertEquals(greet, "Good morning Name");
    }
}