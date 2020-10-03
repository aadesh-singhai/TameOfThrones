package com.aadesh.geektrust.constants;

/**
 * DESCRIPTION - This is a class having all the parameters,
 *               that will be constant during the execution of the program.
 * 
 * @param KINGDOMS - This is the table which has initial list of kingdoms, with their name and emblem. 
 * @param MIN_ALLY_NUMBER - This is the minimum number of allies, that is required to be the universe ruler.
 * 
 * @param RULER_NAME - This is the name of the kingdom, who is asking for allegiance.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */

public final class AppConstants {
    
    private AppConstants() {}

    public static String KINGDOMS[][] = {{"AIR", "OWL"} , {"SPACE", "GORILLA"} ,
                                    {"LAND", "PANDA"} , {"WATER", "OCTOPUS"} ,
                                    {"ICE", "MAMMOTH"} , {"FIRE", "DRAGON"}} ;

    public static int MIN_ALLY_NUMBER = 3;

    public static String RULER_NAME = "SPACE";
}