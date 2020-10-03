package com.aadesh.geektrust.service;

import java.util.HashMap;

import com.aadesh.geektrust.cypherhelper.Cypher;
import com.aadesh.geektrust.cypherhelper.CypherFactory;
import com.aadesh.geektrust.dto.Kingdom;

/**
 * DESCRIPTION - This is class which provides method, reponsible for checking if
 * allegiance with the kingdom can be attained from the given message.
 *
 * @author Aadesh Singhai
 * @version 0.0.1
 */

public class AllianceCheck {

    private Cypher cypher;
    public AllianceCheck() throws ClassNotFoundException {
        cypher = CypherFactory.INSTANCE.getEncrypt("SEASAR");
    }

    /**
     * Description - Method to check alliance for the kingdom.
     * 
     * @param kingdom - Kingdom asked for alliance.
     * @param message - This is encrypted message, sent by the ruler to ask for
     *                allegiance.
     * 
     * @return - boolean if alliance is possible or not.
     * @throws ClassNotFoundException - Cypher algorithm not supported.
     * 
     */
    public boolean checkAlliance(Kingdom kingdom, String message) {
 
        String emblem = kingdom.getEmblem();
        message = cypher.decrypt(message, emblem);

        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : emblem.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : message.toCharArray()) {

            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) - 1);
                if (charCount.get(c) == 0)
                    charCount.remove(c);
            }
        }

        return (charCount.size() == 0) ? true : false;

    }

}
