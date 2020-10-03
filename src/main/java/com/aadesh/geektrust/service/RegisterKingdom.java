package com.aadesh.geektrust.service;

import java.util.ArrayList;
import java.util.List;

import static com.aadesh.geektrust.constants.AppConstants.KINGDOMS;
import com.aadesh.geektrust.dto.Kingdom;

/**
 * DESCRIPTION - This is a singleton class:
 * 					1. Initializes the kingdom objects.
 *                  2. Add a new kingdom in the registry.
 * 					3. Provide access to the registered kingdom list.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */

public class RegisterKingdom {

    private List<Kingdom> kingdomRegister ;

    /**
    * Initialize the kingdom registry with the given kingdoms in the constants class .
    */
    public void initalizeKingdoms(){
        String universekingdoms[][] = KINGDOMS ;
        for( String currentKingdom[] : universekingdoms)
		    kingdomRegister.add(new Kingdom(currentKingdom[0],currentKingdom[1]) );
    }
    
    /**
    * get the list of kingdoms from kingdom registry
    */
    public List<Kingdom> getKingdoms() {
        return kingdomRegister;
    }

    /**
     * Description - Adds new kingdom to registry
     * 
     * @param name - Name of the kingdom
     * @param emblem - Name of the emblem that represents the Kingdom
     */
    public void addNewKingdom(String name,String emblem) {
        kingdomRegister.add(new Kingdom(name, emblem));
    }

    /**
     * Default constructor
     */
    public RegisterKingdom() {
        this.kingdomRegister = new ArrayList<>();
        initalizeKingdoms();
    }

}
