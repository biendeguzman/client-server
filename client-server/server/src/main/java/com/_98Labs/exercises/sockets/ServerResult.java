package com._98Labs.exercises.sockets;
import java.io.IOException;
import java.io.PrintWriter;

public class ServerResult {
    static void serverResultHandler(int result) throws IOException {
        PrintWriter out = new PrintWriter(Server.clientSocket.getOutputStream(), true);
        out.println("Line " + result + " : "+ ServerPoem.poemReader(result));
    }
}
