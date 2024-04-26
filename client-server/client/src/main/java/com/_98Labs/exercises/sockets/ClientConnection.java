package com._98Labs.exercises.sockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ClientConnection {
    private static Logger clientConnectLogger = LogManager.getLogger(ClientInput.class);
    static Client.ClientConnect getClientConnect() throws IOException {
        clientConnectLogger.info("Client started...");
        Socket soc = new Socket("localhost",5000);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        Client.ClientConnect result = new Client.ClientConnect(soc, userInput);
        return result;
    }
}
