package com.ndiamanti.greeter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class GreeterTest {

    @Mock
    private TimeHandlerImpl timeHandler;

    private Greeter greeter;

    @BeforeEach
    private void initilize() {
        greeter = new GreeterImpl(timeHandler);
    }

    @Test
    public void greet_shouldReturnHelloWithName() {
        when(timeHandler.getCurrentPartOfDay()).thenReturn(null);
        String greet = greeter.greet("name");
        assertEquals("Hello Name", greet);
    }

    @Test
    public void greet_shouldTrimsInput() {
        when(timeHandler.getCurrentPartOfDay()).thenReturn(null);
        String greet = greeter.greet(" name ");
        assertEquals("Hello Name", greet);
    }

    @Test
    public void greet_shouldCapitalizeFirstLetterOfInput() {
        when(timeHandler.getCurrentPartOfDay()).thenReturn(null);
        String greet = greeter.greet("name");
        assertEquals("Hello Name", greet);
    }

    @Test
    public void greet_shouldThrowExceptionIfNameIsNull() {
        Throwable exception = assertThrows(GreeterImpl.NullNameException.class, () -> greeter.greet(null));
        assertEquals("Name parameter cannot be null", exception.getMessage());
    }

    @Test
    public void greet_shouldReturnGoodMorningIfTimeIsInRange() {
        when(timeHandler.getCurrentPartOfDay()).thenReturn("morning");
        String greet = greeter.greet("name");
        assertEquals("Good morning Name", greet);
    }

    @Test
    public void greet_shouldReturnGoodEveningIfTimeIsInRange() {
        when(timeHandler.getCurrentPartOfDay()).thenReturn("evening");
        String greet = greeter.greet("name");
        assertEquals("Good evening Name", greet);
    }

    @Test
    public void greet_shouldReturnGoodNightIfTimeIsInRange() {
        when(timeHandler.getCurrentPartOfDay()).thenReturn("night");
        String greet = greeter.greet("name");
        assertEquals("Good night Name", greet);
    }
}