package com.aadesh.geektrust.cypherhelper;


/**
 * Description - A class implementing the old school Seasar cipher, uses the key length or integer number,
 *               to rotate the string characters clockwise for encryption and anti-clockwise for decryption.
 *                      1.Encryption method.
 *                      2.Decryption method.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */
public class SeasarCypher implements Cypher {
    
	@Override
    public String encrypt(String message,String key) {
        int keyLength = key.length();
        StringBuilder encryptMessage = new StringBuilder();
        for (int i=0 ; i<message.length() ; i++) {

            char ch = message.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
              ch = (char) (ch + keyLength);
              ch = ch > 'Z' ? (char) (ch - 'Z' + 'A' - 1) : ch;
            }
            encryptMessage.append(ch);
        }
        return encryptMessage.toString();
    }

    @Override
    public String decrypt(String message, String key) {
        int keyLength = key.length();
        StringBuilder decryptMessage = new StringBuilder();
        for (int i=0 ; i<message.length() ; i++) {
            
            char ch = message.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
              ch = (char) (ch - keyLength);
              ch = ch < 'A' ? (char) (ch + 'Z' - 'A' + 1) : ch;
            }
            decryptMessage.append(ch);
        }
        return decryptMessage.toString();
    }
    
}
