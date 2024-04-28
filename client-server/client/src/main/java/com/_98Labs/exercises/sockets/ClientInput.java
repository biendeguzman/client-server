package com._98Labs.exercises.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.LimitExceededException;

public class ClientInput {
    private static Logger clientInputLogger = LogManager.getLogger(ClientInput.class);
    private static int lineNumber;

    public static void clientInputToServer(Socket soc) throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

        clientInputLogger.info("Enter a number for Poem Line 1 to 24 or (type '000' to end Poem Line): ");
        String inputLine = userInput.readLine();
        lineNumber = clientInputValidate(inputLine);
        if (inputLine.equals("000")) {
            clientInputLogger.warn("Poem line terminated");
            soc.close();
        } else {
            out.println(lineNumber);
        }
    }
    public static int clientInputValidate(String input) throws IllegalArgumentException {
        try {
            lineNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            clientInputLogger.warn("Invalid input. Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            clientInputLogger.error(e.getMessage());
        }
        return lineNumber;
    }
}