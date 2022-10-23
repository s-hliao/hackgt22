package com.example.hackgt22.model;
import com.google.firebase.firestore.IgnoreExtraProperties;

import java.util.HashMap;

@IgnoreExtraProperties
public class DatabaseUser {

    public static final String FIELD_NAME = "name";
    public static final String FIELD_FARMS = "farms";
    public static final String FIELD_RESERVOIRS = "reservoirs";

    private String name;
    private HashMap<Integer, Integer> farms;
    private HashMap<Integer, Integer> reservoirs;

    public DatabaseUser() {}

    public DatabaseUser(String name) {
        this.name = name;
        this.farms = new HashMap<>();
        this.reservoirs = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public HashMap<Integer, Integer> getFarms() {
        return farms;
    }

    public void setFarms(HashMap<Integer, Integer> farms) {
        this.farms = farms;
    }

    public HashMap<Integer, Integer> getReservoirs() {
        return reservoirs;
    }

    public void setReservoirs(HashMap<Integer, Integer> reservoirs) {
        this.reservoirs = reservoirs;
    }
}