package com.aadesh.geektrust.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static com.aadesh.geektrust.constants.AppConstants.MIN_ALLY_NUMBER;
import com.aadesh.geektrust.dto.Kingdom;

 /**
 * Description - A class that implements the TameOfThrones class, responsible for - 
 *                  1. Start alliance proposals.
 *                  2. Check if kingdom is ruler.
 *                  3. Print the ruler and its allies.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */

public class TameOfThronesImpl implements TameOfThrones{

    
    private AllianceCheck allianceCheck;
    public TameOfThronesImpl() throws ClassNotFoundException {
        allianceCheck = new AllianceCheck();
    }
    
    
    @Override
    public List<Kingdom> allegianceInitializer(List<Kingdom> kingdomList,LinkedHashMap<String,String> kingdomMessages) {
        List<Kingdom> allegedKingdoms = new ArrayList<>();
        for (HashMap.Entry<String, String> entry : kingdomMessages.entrySet()) {
            String kingdomName = entry.getKey() ;
            String message = entry.getValue();
            Kingdom currentKingdom = kingdomList.stream()
                                     .filter(kingdom -> kingdomName.equals(kingdom.getName()))
                                     .findAny()
                                     .orElse(null);
            if ( currentKingdom != null && allianceCheck.checkAlliance(currentKingdom,message) )
                allegedKingdoms.add(currentKingdom);
        }
        return allegedKingdoms;
    }

    @Override
    public boolean isRuler(Kingdom kingdom) {
        return ( kingdom.getAllies().size() >= MIN_ALLY_NUMBER ) ;
    }

    @Override
    public void displayRuler(Kingdom ruler) {
        if ( isRuler(ruler) ) {
            System.out.print( ruler.getName() );
            List<Kingdom> allegedKingdoms = ruler.getAllies();
            for ( int i=0 ; i<allegedKingdoms.size() ; i++) {
                String kingdomName = allegedKingdoms.get(i).getName();
                System.out.print(" " + kingdomName);
            }
        }
        else 
            System.out.print("NONE");   
    }

}
