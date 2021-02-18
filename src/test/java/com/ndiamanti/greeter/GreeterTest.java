package com.ndiamanti.greeter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class GreeterTest {

    private final GreeterImpl greeter = new GreeterImpl();

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
        Throwable exception = assertThrows(GreeterImpl.NullNameException.class, () -> greeter.greet(null));
        assertEquals("Name parameter cannot be null", exception.getMessage());
    }

    @Test
    public void greet_shouldReturnGoodMorningIfTimeIsInRange() {
        greeter.setTime(Greeter.MORNING_MIN.plusMinutes(1));
        String greet = greeter.greet("name");
        assertEquals(greet, "Good morning Name");
    }

    @Test
    public void greet_shouldReturnGoodEveningIfTimeIsInRange() {
        greeter.setTime(Greeter.EVENING_MIN.plusMinutes(1));
        String greet = greeter.greet("name");
        assertEquals(greet, "Good evening Name");
    }
}