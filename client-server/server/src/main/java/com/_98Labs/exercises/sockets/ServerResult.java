package com._98Labs.exercises.sockets;
import java.io.IOException;
import java.io.PrintWriter;

public class ServerResult {
    static void serverResultHandler(Server.Result result) throws IOException {
        PrintWriter out = new PrintWriter(Server.clientSocket.getOutputStream(), true);
        out.println("Line " + result.lineNumber() + " : "+ result.line());
    }
}
