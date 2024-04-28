package com._98Labs.exercises.sockets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ServerPoem {
    private static Logger serverlogger = LogManager.getLogger(ServerPoem.class);

    public static String  poemServerHandler() throws IOException {
        String filePath = "C:\\Users\\ticed\\client-server\\client-server\\server\\src\\main\\resources\\Poem.txt";
        return filePath;
    }
    public static int handleLineFromClient() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(Server.clientSocket.getInputStream()));
        String input = in.readLine();
        int lineNumber = serverValidate(input);
        if(lineNumber == 000){
            Server.clientSocket.close();
        }
        return lineNumber;
    }
    public static String poemReader(int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(poemServerHandler()));
        //Line Starts
        int currentLine = 1;
        String line;
        while ((line = reader.readLine()) != null) {
            if (currentLine == lineNumber) {
                serverlogger.info("Line " + lineNumber + ": " + line);
                break;
            }
            currentLine++;
        }
        reader.close();
        return line;
    }

    public static int serverValidate(String input) {
        try {
            int lineNumber = Integer.parseInt(input);
            if (lineNumber < 1) {
                serverlogger.info("Input Exceed Limit");
            }
            return lineNumber;
        } catch (NumberFormatException e) {
            serverlogger.warn("Invalid Input");
            return Integer.parseInt("000");
        }
    }
}
