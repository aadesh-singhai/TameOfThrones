package com.aadesh.geektrust.utils;

import java.io.IOException;

/**
 * Description - A Factory providing instance, responsible for parsing files of given format.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */

public enum FileParserFactory {
    INSTANCE;

    /**
     * Description - Method to return the FileParser instance based on the file format requested.
     *
     * @param format The format of the file.
     * @param uri The input file path.
     * 
     * @return The required FileParser instance.
     * @throws ClassNotFoundException FileParser instance of the specified format not found.
     * @throws IOException
     */
    public FileParser getFileParser(String format, String uri) throws ClassNotFoundException, IOException {
    switch (format.toLowerCase()) {
      case "text":
      case "txt":
        return new TextFileParser(uri);
      default:
        throw new ClassNotFoundException("Can not parse files of given type");
    }
  }
}