package com.aadesh.geektrust.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Description - A class implementing FileParser interface. 1. Parse file of
 * .txt format.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */

public class TextFileParser implements FileParser {

    public Scanner sc;

    /**
     * Description- Method to create scanner object having content of given file.
     * 
     * @param uri - File path
     * 
     * @throws FileNotFoundException - File is not present at the provide path.
     * @throws IOException           - Input format in the file is not correct.
     */
    public TextFileParser(String uri) throws FileNotFoundException, IOException {
        File file = new File(uri);
        sc = new Scanner(file);
    }

    @Override
    public LinkedHashMap<String, String> parseFile() throws IOException {
        LinkedHashMap<String,String> input = new LinkedHashMap<>();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String attributes[] = line.split(" ",2);
            if (attributes.length != 2)
                throw new IOException("Input format inccorect of line  => " + line);
            input.put(attributes[0], attributes[1]);
        }
        cleanup();
        return input;
    }

    /**
     * Description - Method responsible for cleanup process after the whole process.
     *                  1. Closing scanner object.
     */
    public void cleanup() {
        sc.close();
    }
}
