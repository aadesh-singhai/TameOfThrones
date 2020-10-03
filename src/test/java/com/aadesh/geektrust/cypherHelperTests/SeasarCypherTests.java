package com.aadesh.geektrust.cypherHelperTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aadesh.geektrust.cypherhelper.Cypher;
import com.aadesh.geektrust.cypherhelper.CypherFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Description - This a class to run tests for validity of algorithm results.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */
@TestInstance(Lifecycle.PER_CLASS)
public class SeasarCypherTests {

    private Cypher seasarCypher;

    /**
     * Description - This is a setup to run before all test can be executed in this class.
     * 
     * @throws ClassNotFoundException
     */
    @BeforeAll
    void setup() throws ClassNotFoundException {
        seasarCypher = CypherFactory.INSTANCE.getEncrypt("SEASAR");
    }

    /**
     * Description - This is a test method, which tests the Seasar cypher algorithm working
     *               correctlly for decryption.
     * 
     */
    @Test
    void checkDecrypt() {
        assertEquals("Z", seasarCypher.decrypt("A", "a"));
        assertEquals("ABC", seasarCypher.decrypt("DEF", "abc"));
        assertEquals("OLWL", seasarCypher.decrypt("ROZO", "owl"));
    }

    /**
    * Description - This is a test method, which tests the Seasar cypher algorithm working
    *               correctlly for encryption.
    * 
    */
    @Test
    void checkEncrypt() {
        assertEquals("A", seasarCypher.encrypt("Z", "a"));
        assertEquals("DEF", seasarCypher.encrypt("ABC", "abc"));
        assertEquals("ROZO", seasarCypher.encrypt("OLWL", "owl"));
    }
}
