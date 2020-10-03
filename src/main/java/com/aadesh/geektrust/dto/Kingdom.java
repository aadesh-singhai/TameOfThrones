package com.aadesh.geektrust.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Description - This a data class, representing a kingdom object having parameters - 
 *                  1.Constructor of class with params.
 *                  2.Params of the kingdom objects.
 * 
 * @param name - Kingdom name
 * @param emblem - Kingdom emblem
 * @param allies - List of allies of the kingdom
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */
public class Kingdom {
    
    private String name;
    private String emblem;
    private List<Kingdom> allies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public List<Kingdom> getAllies() {
        return allies;
    }

    public void setAllies(List<Kingdom> allies) {
        this.allies = allies;
    }

    public Kingdom(String name, String emblem) {
        this.name = name;
        this.emblem = emblem;
        this.allies = new ArrayList<>();
    }
    
}
