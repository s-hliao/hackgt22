package com.example.hackgt22.model;

import com.google.firebase.Timestamp;

import java.util.HashMap;
import java.util.Map;

public class Reservoir {
    public static final String FIELD_NAME = "name";
    public static final String FIELD_FARMS = "connectedFarms";
    public static final String FIELD_WATERLEVEL = "waterLevel";
    public static final String FIELD_RESERVOIRS = "nutrientLevel";

    private String name;
    private int[]connectedFarms;
    private Map<Timestamp, Double> waterLevel;
    private Map<Timestamp, Double> nutrientLevel;

    public Reservoir(String name){
        this.name = name;
        connectedFarms = new int[]{-1, -1, -1};
        waterLevel = new HashMap<>();
        nutrientLevel = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getConnectedFarms() {
        return connectedFarms;
    }

    public void setConnectedFarms(int[] farms) {
        this.connectedFarms = farms;
    }

    public Map<Timestamp, Double> getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Map<Timestamp, Double> waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Map<Timestamp, Double> getNutrientLevel() {
        return nutrientLevel;
    }

    public void setNutrientLevel(Map<Timestamp, Double> nutrientLevel) {
        this.nutrientLevel = nutrientLevel;
    }
}
