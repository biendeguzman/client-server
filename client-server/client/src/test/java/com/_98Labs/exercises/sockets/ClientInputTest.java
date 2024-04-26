package com._98Labs.exercises.sockets;
import static com._98Labs.exercises.sockets.ClientInput.clientInputValidate;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClientInputTest {
    @Test
    @DisplayName("Client Input Integer")
    public void testClientInputInt() {
        int result = clientInputValidate("2");
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Client input less then 1")
    public void clientInputLessThan() {
        int result = clientInputValidate("0");
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Client input with decimal")
    public void clientInputDecimal() {
        int result = clientInputValidate("1.1");
        assertEquals(0, result);
    }
    @Test
    @DisplayName("Client input String")
    public void clientInputString() {
        int actualLineNumber = clientInputValidate("aaa");
        assertEquals(0, actualLineNumber);
    }
}

