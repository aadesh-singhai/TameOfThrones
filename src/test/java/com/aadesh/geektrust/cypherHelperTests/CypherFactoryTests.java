package com.aadesh.geektrust.cypherHelperTests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aadesh.geektrust.cypherhelper.Cypher;
import com.aadesh.geektrust.cypherhelper.CypherFactory;
import com.aadesh.geektrust.cypherhelper.SeasarCypher;

import org.junit.jupiter.api.Test;
/**
 * Description - This a class to run tests for cypher Instances of different algorithms supported.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */
public class CypherFactoryTests {
    /**
     * Description - This is a test method which test cypher factory instance for Seasar cypher.
     * 
     * @throws ClassNotFoundException - if algorithm is not supported.
     */
    @Test
    void checkSeasarCipherInstance() throws ClassNotFoundException {
        Cypher seasarCypher = CypherFactory.INSTANCE.getEncrypt("SEASAR");
        assertTrue(seasarCypher instanceof SeasarCypher);
    }

    /**
     * Description - This is a test method to check if it throws the exception for algorithm not supported,
     *                  asserting ClassNotFoundException.
     */
    @Test
    void checkNotSupportedAlgorithm() {
        assertThrows(ClassNotFoundException.class, () -> CypherFactory.INSTANCE.getEncrypt("algorithm"));
    }
}
