package com._98Labs.exercises.sockets;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ServerConnect {
    private static Logger serverConnectLogger = LogManager.getLogger(ServerConnect.class);
    public static Socket getSocket() throws IOException {
        serverConnectLogger.info("Waiting for Client...");
        ServerSocket ss = new ServerSocket(5000);
        //accept methods waits until client connects to the server.
        Server.clientSocket = ss.accept();
        serverConnectLogger.info("Client Accepted!");
        return Server.clientSocket;
    }
}
