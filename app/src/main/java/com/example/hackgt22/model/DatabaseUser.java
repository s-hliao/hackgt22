package com.example.hackgt22.model;
import com.google.firebase.firestore.IgnoreExtraProperties;

import java.util.HashMap;

@IgnoreExtraProperties
public class DatabaseUser {

    public static final String FIELD_NAME = "name";
    public static final String FIELD_FARMS = "farms";
    public static final String FIELD_RESERVOIRS = "reservoirs";

    private String name;
    private HashMap<String, String> farms;
    private HashMap<String, String> reservoirs;

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


    public HashMap<String, String> getFarms() {
        return farms;
    }

    public void setFarms(HashMap<String, String> farms) {
        this.farms = farms;
    }

    public HashMap<String, String> getReservoirs() {
        return reservoirs;
    }

    public void setReservoirs(HashMap<String, String> reservoirs) {
        this.reservoirs = reservoirs;
    }
}