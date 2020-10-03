package com.aadesh.geektrust;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.aadesh.geektrust.dto.Kingdom;
import com.aadesh.geektrust.service.TameOfThrones;
import com.aadesh.geektrust.service.TameOfThronesImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Description - This class tests all the method responsible for alliance process.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */
@TestInstance(Lifecycle.PER_CLASS)
public class TameOfThronesImplTests {

    private TameOfThrones tameOfThrones;

    /**
     * Description - Setup for all tests in this class to execute
     * 
     * @throws ClassNotFoundException
     */
    @BeforeAll
    void setup() throws ClassNotFoundException {
        tameOfThrones = new TameOfThronesImpl();
    }

    /**
     * Description - This method validates that the right input returns the alliance and ruler.
     * 
     * @throws ClassNotFoundException
     */
    @Test
    void checkPossibleAllianceInitialize() throws ClassNotFoundException {
        LinkedHashMap<String,String> tempInput = new LinkedHashMap<>();
        tempInput.put("AIR","ROZO");
        tempInput.put("LAND","FAIJWJSOOFAMAU");
        tempInput.put("ICE","STHSTSTVSASOS");
        List<Kingdom> kingdomRegister = new ArrayList<>();
        kingdomRegister.add(new Kingdom("SPACE", "GORILLA"));
        kingdomRegister.add(new Kingdom("LAND", "PANDA"));
        kingdomRegister.add(new Kingdom("WATER", "OCTOPUS"));
        kingdomRegister.add(new Kingdom("ICE", "MAMMOTH"));
        kingdomRegister.add(new Kingdom("AIR", "OWL"));
        kingdomRegister.add(new Kingdom("FIRE", "DRAGON"));

        List<Kingdom> allies = tameOfThrones.allegianceInitializer(kingdomRegister, tempInput);
        kingdomRegister.get(0).setAllies(allies);
        assertEquals(3, allies.size());
        assertEquals("AIR", allies.get(0).getName());
        assertEquals("PANDA", allies.get(1).getEmblem());
        assertTrue(()-> tameOfThrones.isRuler(kingdomRegister.get(0)));
    }

    /**
     * Description - This method validates that the wrong input doesn't returns the ruler.
     * 
     * @throws ClassNotFoundException
     */
    @Test
    void checkImpossibleAllianceInitialize() throws ClassNotFoundException {
        LinkedHashMap<String,String> tempInput = new LinkedHashMap<>();
        tempInput.put("AIR","OWLAOWLBOWLC");
        tempInput.put("LAND","OFBBMUFDICCSO");
        tempInput.put("ICE","VTBTBHTBBBOBAB");
        tempInput.put("WATER","SUMMER IS COMING");
        List<Kingdom> kingdomRegister = new ArrayList<>();
        kingdomRegister.add(new Kingdom("SPACE", "GORILLA"));
        kingdomRegister.add(new Kingdom("LAND", "PANDA"));
        kingdomRegister.add(new Kingdom("WATER", "OCTOPUS"));
        kingdomRegister.add(new Kingdom("ICE", "MAMMOTH"));
        kingdomRegister.add(new Kingdom("AIR", "OWL"));
        kingdomRegister.add(new Kingdom("FIRE", "DRAGON"));

        List<Kingdom> allies = tameOfThrones.allegianceInitializer(kingdomRegister, tempInput);
        kingdomRegister.get(0).setAllies(allies);
        assertEquals(2, allies.size());
        assertFalse(()-> tameOfThrones.isRuler(kingdomRegister.get(0)));
    }
    
}