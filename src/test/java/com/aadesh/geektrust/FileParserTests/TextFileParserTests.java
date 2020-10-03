package com.aadesh.geektrust.FileParserTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.aadesh.geektrust.utils.FileParser;
import com.aadesh.geektrust.utils.FileParserFactory;
import com.aadesh.geektrust.utils.TextFileParser;

import org.junit.jupiter.api.Test;

/**
 * Description - This a class to run tests for the validity of File content
 * correctly read.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */
public class TextFileParserTests {

    /**
     * Description - This method checks, if we are reading correct input and getting
     * it returned in desired format.
     * 
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    void checkTextParseFile() throws IOException, ClassNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input1.txt").getFile());
        String path = file.getPath();
        FileParser fileParser = FileParserFactory.INSTANCE.getFileParser("txt", path);
        LinkedHashMap<String, String> input = fileParser.parseFile();
        assertTrue(input.containsKey("AIR"));
        assertEquals(3, input.size());
        assertEquals("FAIJWJSOOFAMAU", input.get("LAND"));
    }

    /**
     * Description - This method checks, if we are throwing exception if input
     * content is not in correct format.
     * 
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Test
    void checkWrongInputTextParseFile() throws ClassNotFoundException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("incorrectInput.txt").getFile());
        String path = file.getPath();
        FileParser fileParser = FileParserFactory.INSTANCE.getFileParser("txt", path);
        assertThrows(IOException.class, () -> fileParser.parseFile());
    }

    /**
     * Description - This method check if file is present ,asserting file not found exception by passing non existing file.
     *  
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Test
    void checkFileNotFoundException() throws ClassNotFoundException, IOException {
        assertThrows(FileNotFoundException.class,() -> FileParserFactory.INSTANCE.getFileParser("txt", "abc.txt"));
    }
}
