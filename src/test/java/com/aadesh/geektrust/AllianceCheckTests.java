package com.aadesh.geektrust;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aadesh.geektrust.dto.Kingdom;
import com.aadesh.geektrust.service.AllianceCheck;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Description - This is the test class that validates the functioning of the service class, AllianceCheck.
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */
@TestInstance(Lifecycle.PER_CLASS)
public class AllianceCheckTests {

    private AllianceCheck allianceCheck;

    @BeforeAll
    void setup() throws ClassNotFoundException {
        allianceCheck = new AllianceCheck();
    }

    /**
     * Description - This method validate the checkalliance method, 
     *               which is reponsible to check if the given message can be used to form alliance.
     */
    @Test
    void checkAllianceMethod() {
        Kingdom temp1 = new Kingdom("AIR", "OWL");
        Kingdom temp2 = new Kingdom("LAND", "PANDA");
        assertTrue(allianceCheck.checkAlliance(temp1, "ROZO"));
        assertFalse(allianceCheck.checkAlliance(temp2, "ROZO"));
    }
}
