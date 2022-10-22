package com.example.hackgt22.model;

public class Plant {
    public static final String FIELD_NAME = "name";
    public static final String FIELD_WATERINTENSITY = "waterIntensive";
    public static final String FIELD_NUTRIENTINTENSITY = "nutrientIntensive";
    public static final String FIELD_GROWTHTIME = "growthTime";

    private String name;
    private boolean waterIntensive;
    private boolean nutrientIntensive;
    private double growthTime;


    public Plant(String name, boolean waterIntensive, boolean nutrientIntensive, double growthTime){
        this.name = name;
        this.waterIntensive = waterIntensive;
        this.nutrientIntensive = nutrientIntensive;
        this.growthTime = growthTime;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWaterIntensive() {
        return waterIntensive;
    }

    public void setWaterIntensive(boolean waterIntensive) {
        this.waterIntensive = waterIntensive;
    }

    public boolean isNutrientIntensive() {
        return nutrientIntensive;
    }

    public void setNutrientIntensive(boolean nutrientIntensive) {
        this.nutrientIntensive = nutrientIntensive;
    }

    public double getGrowthTime() {
        return growthTime;
    }

    public void setGrowthTime(double growthTime) {
        this.growthTime = growthTime;
    }
}
