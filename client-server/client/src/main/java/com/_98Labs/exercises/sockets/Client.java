package com._98Labs.exercises.sockets;
import java.io.BufferedReader;
import java.net.Socket;
import static com._98Labs.exercises.sockets.ClientInput.clientInputToServer;
import static com._98Labs.exercises.sockets.ClientConnection.getClientConnect;
import static com._98Labs.exercises.sockets.ClientResult.clientResult;

public class Client {
    public static void main (String[]args) {
        //Connection for Client and Server
        try {
            //Client Connection to Server
            ClientConnect result = getClientConnect();
            while (true) {
                clientInputToServer(result.soc()); //UserInput
                clientResult(result.soc());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public record ClientConnect(Socket soc, BufferedReader userInput) {
    }
}
