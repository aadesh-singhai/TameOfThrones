package com.aadesh.geektrust.FileParserTests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import com.aadesh.geektrust.utils.FileParser;
import com.aadesh.geektrust.utils.FileParserFactory;

import org.junit.jupiter.api.Test;

/**
 * Description - This is the test class which validates the instances of File parser factory.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */
public class FileParserFactoryTests {

    /**
     * Description - This method tests the instance of File format supported for parsing.
     * 
     * @throws ClassNotFoundException - if the file format is not supported
     * @throws IOException - if any format of content inside the file is not correct.
     */
    @Test
    void checkTextFileParserInstance() throws ClassNotFoundException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input1.txt").getFile());
        String path = file.getPath();
        FileParser fileParser = FileParserFactory.INSTANCE.getFileParser("txt", path);
        assertTrue(fileParser instanceof FileParser);
    }

    /**
     * Description - This method tests the instance of File format not supported for parsing.
     * 
     * @throws ClassNotFoundException - if the file format is not supported
     * @throws IOException - if any format of content inside the file is not correct.
     */
    @Test
    void checkCSVFileParserInstance() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input1.csv").getFile());
        String path = file.getPath();
        assertThrows(ClassNotFoundException.class, () -> FileParserFactory.INSTANCE.getFileParser("csv", path));
    }
}
