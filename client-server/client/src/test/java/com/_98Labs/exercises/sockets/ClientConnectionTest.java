package com._98Labs.exercises.sockets;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.Socket;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
class ClientConnectionTest {
@Test
    public void getClientConnection() throws IOException {
    Socket serverSocket = ClientConnection.getClientConnect().soc();
    try {
        // Assert
        assertNotNull(serverSocket, "Client socket should not be null");
        assertFalse(serverSocket.isClosed(), "Client socket should not be closed");
        serverSocket.close(); // Close the socket after the test
    } catch (IOException e) {
        fail("IOException occurred: " + e.getMessage());
        }
    }
}