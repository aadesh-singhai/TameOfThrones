package com.aadesh.geektrust.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.aadesh.geektrust.dto.Kingdom;

 /**
 * Description - An Interface that defines the contract for the game of thrones program-
 *                  1. Start alliance proposals.
 *                  2. Check if kingdom is ruler.
 *                  3. Print the ruler and its allies.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */

public interface TameOfThrones {
    /**
     * Description - Start alliance process by sending the messages.
     * 
     * @param kingdomList - List of kingdom objects.
     * @param kingdomMessages - Map having kingdom name as key and messgae as value.
     * 
     * @return - List of kingdom objects, which accepted the alliance.
     * @throws ClassNotFoundException
     * 
     */
    List<Kingdom> allegianceInitializer(List<Kingdom> kingdomList,LinkedHashMap<String,String> kingdomMessages) throws ClassNotFoundException;

    /**
     * Description - Method responsible for checking if the given kingdom is ruler or not.
     * 
     * @param kingdom - Kingdom object to check if it is ruler.
     * @return - boolean, Is kingdom is ruler or not.
     */
    boolean isRuler(Kingdom kingdom);

    /**
     * Description - Method responsible for consoling/printing the universe ruler and its allies.
     * 
     * @param ruler 
     */
    void displayRuler(Kingdom ruler);
}
