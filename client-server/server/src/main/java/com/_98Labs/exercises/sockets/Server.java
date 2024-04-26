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
                Result result = ServerPoem.poemReader(soc);
                ServerResult.serverResultHandler(soc, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public record Result(int lineNumber, String line) {
    }
}
