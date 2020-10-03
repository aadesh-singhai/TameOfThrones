package com.aadesh.geektrust.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Description - An interface defining contracts for class implementing it,
 *                  1. Parse given file.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */

public interface FileParser {

    /**
     * Description - Parse the given file.
     * 
     * @return - A Map with key value pair of given attributes in file.
     * @throws IOException - If any Format mismatch is there in give file.
     */
    LinkedHashMap<String, String> parseFile() throws IOException; 
}
