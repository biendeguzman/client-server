package com._98Labs.exercises.sockets;
import java.net.Socket;

public class Server {
    public static Socket clientSocket;
    public static void main (String[]args) {
        try {
            //Connection to Client
            Socket soc = ServerConnect.getSocket();
            //Poem Line Result
            while (true) {
                int result = ServerPoem.handleLineFromClient();
                ServerResult.serverResultHandler(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
