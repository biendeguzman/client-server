package com._98Labs.exercises.sockets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com._98Labs.exercises.sockets.ServerPoem.serverValidate;
import static com._98Labs.exercises.sockets.ServerPoem.poemReader;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileReader;
import java.io.IOException;

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
    @Test
    public void testPoemLine() throws IOException {
        String line = ServerPoem.poemReader(1);
        String expectedLine = "The Road Not Taken";
        assertEquals(expectedLine, line);
    }
    @Test
    public void testPoemLine2() throws IOException {
        String line = ServerPoem.poemReader(21);
        String expectedLine = "Somewhere ages and ages hence:";
        assertEquals(expectedLine, line);
    }
    @Test
    public void testPoemLineInputExceed() throws IOException {
        String line = ServerPoem.poemReader(1000);
        String expectedLine = null;
        assertEquals(expectedLine, line);
    }
    @Test
    public void testPoemLineInputNegative() throws IOException {
        String line = ServerPoem.poemReader(-1);
        String expectedLine = null;
        assertEquals(expectedLine, line);
    }
//    @Test
//    public void testPoemLine3() throws IOException {
//        String line = ServerPoem.poemReader(2);
//        String expectedLine = "calling children out to play.";
//        assertEquals(expectedLine, line);
//    }
}