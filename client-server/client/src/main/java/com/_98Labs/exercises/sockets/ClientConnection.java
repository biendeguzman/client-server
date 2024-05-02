package com._98Labs.exercises.sockets;
import java.io.*;
import java.net.Socket;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ClientConnection {
    private static Logger clientConnectLogger = LogManager.getLogger(ClientInput.class);
    private static int port;
    private static Properties properties;
    private static void configProperties() throws IOException{
        String filepath = ClientConnection.class.getClassLoader().getResource("config.properties").getPath();
        FileInputStream readFile = new FileInputStream(filepath);
        properties = new Properties();
        properties.load(readFile);
    }
//    private static String portProp()throws IOException{
//        return
//    }
    public static Client.ClientConnect getClientConnect() throws IOException {
        configProperties();
        port = Integer.parseInt(properties.getProperty("port"));
        clientConnectLogger.info("Client started...");
        Socket soc = new Socket("localhost",port);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        Client.ClientConnect result = new Client.ClientConnect(soc, userInput);
        return result;
    }
}
