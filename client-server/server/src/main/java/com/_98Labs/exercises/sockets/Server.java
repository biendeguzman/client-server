package com._98Labs.exercises.sockets;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Properties;
public class Server {
    public static Socket clientSocket;
    public static void main (String[]args) {
        Properties properties = new Properties();
        try {
            // Load the properties file
            FileInputStream filepath = new FileInputStream(Server.class.getClassLoader().getResource("config.properties").getPath());
            properties.load(filepath);
            filepath.close();
            //Connection to Client
            Socket soc = ServerConnect.getSocket();
            //Poem Line Result
            while (true) {
                int result = ServerPoem.handleLineFromClient();
                if(properties.getProperty("eagerLoad").equals("enabled")){
                    new EagerLoad();
                } else {
                    new ServerPoem();
                }
                ServerResult.serverResultHandler(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
