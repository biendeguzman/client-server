package com._98Labs.exercises.sockets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
public class ServerPoem {
    private static Logger serverlogger = LogManager.getLogger(ServerPoem.class);

    private static poemReaderServer poemServerHandler(Socket soc) throws IOException {
        String filePath = "C:\\Users\\ticed\\project\\client-server\\server\\src\\main\\resources\\Poem.txt";
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        //Open the file for reading
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        poemReaderServer result = new poemReaderServer(in, reader);
        return result;
    }
    public static Server.Result poemReader(Socket soc) throws IOException {
        poemReaderServer result = poemServerHandler(soc);
        int lineNumber = handleLineFromClient(result.in());
        //Line Starts
        int currentLine = 1;
        String line;
        while ((line = result.reader().readLine()) != null) {
            if (currentLine == lineNumber) {
                serverlogger.info("Line " + lineNumber + ": " + line);
                break;
            }
            currentLine++;
        }
        result.reader().close();
        // Validate the lineNumber
        Server.Result getPoemReaderServer = new Server.Result(lineNumber, line);
        return getPoemReaderServer;
    }

    private record poemReaderServer(BufferedReader in, BufferedReader reader) {
    }

    private static int handleLineFromClient(BufferedReader in) throws IOException {
        String input = in.readLine();
        int lineNumber = serverValidate(input);
        return lineNumber;
    }

    public static int serverValidate(String input){
        try {
            int lineNumber = Integer.parseInt(input);
            if (lineNumber < 1) {
                serverlogger.info("Input Exceed Limit");
            }
            return lineNumber;
        } catch (NumberFormatException e) {
            serverlogger.warn("Invalid Input");
            return Integer.parseInt("end");
        }
    }
}


