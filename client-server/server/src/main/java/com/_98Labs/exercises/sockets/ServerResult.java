package com._98Labs.exercises.sockets;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
public class ServerResult {
    private static  String poemLines;
    static void serverResultHandler(int result) throws IOException {
        Properties properties = new Properties();
        // Load the properties file
        FileInputStream filepath = new FileInputStream(Server.class.getClassLoader().getResource("config.properties").getPath());
        properties.load(filepath);
        filepath.close();
        PrintWriter out = new PrintWriter(Server.clientSocket.getOutputStream(), true);
        if(properties.getProperty("eagerLoad").equals("enabled")){
            out.println("Line " + result + " : "+ EagerLoad.poemReader(result));
        } else {
            out.println("Line " + result + " : "+ ServerPoem.poemReader(result));
        }
    }
}
