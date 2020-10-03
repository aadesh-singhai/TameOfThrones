package com.aadesh.geektrust.cypherhelper;
/**
 * DESCRIPTION - An Interface defining the contracts for the class impelemnting it.
 *                  1. Encryption Method.
 *                  2. Decryption Method.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */

public interface Cypher {

    /**
     * 
     * @param message - This is the given string, that will be encrypted.
     * @param key - This is the encryption key that will be used for the process.
     * 
     * @return - An encrypted form of string.
     */
    String encrypt(String message,String key);

    /**
     * 
     * @param message - This is the given string, that will be decrypted.
     * @param key - This is the decryption key that will be used for the process.
     * 
     * @return - A decrypted form of string.
     */
    String decrypt(String message,String key);
}
