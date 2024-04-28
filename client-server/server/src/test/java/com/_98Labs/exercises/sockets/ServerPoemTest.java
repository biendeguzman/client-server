package com._98Labs.exercises.sockets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com._98Labs.exercises.sockets.ServerPoem.serverValidate;
import static org.junit.jupiter.api.Assertions.*;
import static com._98Labs.exercises.sockets.ServerPoem.poemReader;

class ServerPoemTest {
    @Test
    public void validateInput(){
        int result = serverValidate("2");
        assertEquals(2,result);
    }
    @Test
    @DisplayName("Validate Input Less than 1")
    public void validateInputLessThan(){
        int result = serverValidate("0");
        assertEquals(0,result);
    }
    @Test
    public void validateInputDecimal(){
        int result = serverValidate("2.7");
        assertEquals(0,result);
    }
    @Test
    public void validateStringInput(){
        int result = serverValidate("aaa");
        assertEquals(0, result);
    }
    @Test
    public void validateInputExceed(){
        int result = serverValidate("1000");
        assertEquals(1000, result);
    }
}
class ServerPoemReaderTest{
    private static final String filepath = "C:\\Users\\ticed\\project\\client-server\\server\\src\\main\\resources\\Poem.txt";
    private ServerPoem poemReader;

    @BeforeEach
    public void serverPoemRead(){
        poemReader = new ServerPoem();
    }
    @Test
    public void testInput(){
        int result = ServerPoem.poemReader(1);
        assertEquals("The Road Not Taken",result);
    }
}