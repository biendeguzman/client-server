package com._98Labs.exercises.sockets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class ServerPoem {
    private static String filepath = ServerPoem.class.getClassLoader().getResource("Poem.txt").getPath();
    private static Logger serverlogger = LogManager.getLogger(ServerPoem.class);
    private static List<String> poemLines;

    static {
        //loading the poem into memory
        poemLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                poemLines.add(line);
//                System.out.println(poemLines);
            }
        } catch (IOException e) {
            serverlogger.error("Error loading poem: " + e.getMessage());
        }
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
    public static String poemReader(int lineNumber) {
        if (lineNumber < 1 || lineNumber > poemLines.size()) {
            serverlogger.info("Invalid line number: " + lineNumber);
            return null;
        }
        String line = poemLines.get(lineNumber - 1); // Adjust for 0-based indexing
        serverlogger.info("Line " + lineNumber + ": " + line);
        return line;
    }
//    public static String poemReader(int lineNumber) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader(filepath));
//        //Line Starts
//        int currentLine = 1;
//        String line;
//        while ((line = reader.readLine()) != null) {
//            if (currentLine == lineNumber) {
//                serverlogger.info("Line " + lineNumber + ": " + line);
//                break;
//            }
//            currentLine++;
//        }
//        reader.close();
//        return line;
//    }
    public static int serverValidate(String input) {
        try {
            int lineNumber = Integer.parseInt(input);
            if (lineNumber < 1) {
                serverlogger.info("Input Exceed Limit");
            }
            return lineNumber;
        } catch (NumberFormatException e) {
            serverlogger.warn("Server Terminated");
            return Integer.parseInt("000");
        }
    }
}
