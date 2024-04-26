package com._98Labs.exercises.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ClientResult {
    private static Logger clientResultLogger = LogManager.getLogger(ClientResult.class);
    static void clientResult(Socket soc) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        clientResultLogger.info(in.readLine());
    }
}
