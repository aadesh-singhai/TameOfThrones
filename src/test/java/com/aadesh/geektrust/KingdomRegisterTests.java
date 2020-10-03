package com.aadesh.geektrust;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aadesh.geektrust.service.RegisterKingdom;

import org.junit.jupiter.api.Test;
/**
 * Description - This Class tests the Kingdom Registration is happening correctly or not.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */
public class KingdomRegisterTests {
    
    @Test
    void checkKingdomRegistration() {
        RegisterKingdom registerKingdom = new RegisterKingdom();
        assertEquals(6,registerKingdom.getKingdoms().size());
        registerKingdom.addNewKingdom("HELL", "DEVIL");
        assertEquals(7,registerKingdom.getKingdoms().size());
    }
}
