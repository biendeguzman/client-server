package com._98Labs.exercises.sockets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class EagerLoad {
    private static Logger eagerLogger = LogManager.getLogger(EagerLoad.class);
    private static String filepath = ServerPoem.class.getClassLoader().getResource("Poem.txt").getPath();
    private static List<String> poemLines;
    public static void eagerLoad()  {
        if(poemLines != null)
            return;
        //loading the poem into memory
        poemLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                poemLines.add(line);
            }
            eagerLogger.info(poemLines);
        } catch (IOException e) {
            eagerLogger.error(e.getMessage());
        }
    }
    static {
        eagerLoad();
    }
    public static String poemReader(int lineNumber) {
        eagerLoad();
        if (lineNumber < 1 || lineNumber > poemLines.size()) {
            eagerLogger.info("Invalid line number: " + lineNumber);
            return null;
        }
        String line = poemLines.get(lineNumber - 1);
        eagerLogger.info("Line " + lineNumber + ": " + line);
        return line;
    }
}
