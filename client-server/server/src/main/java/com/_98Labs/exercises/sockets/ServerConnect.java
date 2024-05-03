package com._98Labs.exercises.sockets;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ServerConnect {
    private static int port;
    private static Properties properties;
    private static void configProperties() throws IOException{
        String filepath = ServerConnect.class.getClassLoader().getResource("config.properties").getPath();
        FileInputStream readFile = new FileInputStream(filepath);
        properties = new Properties();
        properties.load(readFile);
    }
    private static Logger serverConnectLogger = LogManager.getLogger(ServerConnect.class);
    public static Socket getSocket() throws IOException {
        configProperties();
        port = Integer.parseInt(properties.getProperty("port"));
        serverConnectLogger.info("Waiting for Client...");
        ServerSocket ss = new ServerSocket(port);
        //accept methods waits until client connects to the server.
        Server.clientSocket = ss.accept();
        serverConnectLogger.info("Client Accepted!");
        return Server.clientSocket;
    }
}
