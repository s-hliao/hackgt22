package com.example.hackgt22.model;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Farm {
    public static final String FIELD_NAME = "name";
    public static final String FIELD_PLANTROW1 = "plantRow1";
    public static final String FIELD_PLANTROW2 = "plantRow2";
    public static final String FIELD_WATERLEVEL = "waterLevel";
    public static final String FIELD_CONNECTEDRESERVOIR = "connectedReservoir";

    private String name;
    private int[] plantRow1;
    private int[] plantRow2;
    private Map<Timestamp, Double> waterLevel;
    private int connectedReservoir;


    public Farm(String name, int connectedReservoir) {
        this.name=  name;
        plantRow1 = new int[5];
        plantRow2 = new int[5];
        waterLevel = new HashMap<>();
        this.connectedReservoir = connectedReservoir;

    }

    public int[] getPlantRow1() {
        return plantRow1;
    }

    public void setPlantRow1(int[] plantRow1) {
        this.plantRow1 = plantRow1;
    }

    public int[] getPlantRow2() {
        return plantRow2;
    }

    public void setPlantRow2(int[] plantRow2) {
        this.plantRow2 = plantRow2;
    }

    public Map<Timestamp, Double> getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Map<Timestamp, Double> waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getConnectedReservoir() {
        return connectedReservoir;
    }

    public void setConnectedReservoir(int connectedReservoir) {
        this.connectedReservoir = connectedReservoir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



