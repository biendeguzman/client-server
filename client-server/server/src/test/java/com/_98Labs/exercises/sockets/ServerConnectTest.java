package com._98Labs.exercises.sockets;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.Socket;
import static org.junit.jupiter.api.Assertions.*;

class ServerConnectTest {

    @Test
    public void getServerConnect(){
        try {
            Socket clientSocket = ServerConnect.getSocket();

            // Assert
            assertNotNull(clientSocket, "Client socket should not be null");
            assertFalse(clientSocket.isClosed(), "Client socket should not be closed");
            clientSocket.close(); // Close the socket after the test
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }
    }
}