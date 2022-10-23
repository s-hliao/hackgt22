package com.example.hackgt22.model;

public class Plant {
    public static final String FIELD_NAME = "name";
    public static final String FIELD_WATERINTENSITY = "waterIntensive";
    public static final String FIELD_NUTRIENTINTENSITY = "nutrientIntensive";
    public static final String FIELD_GROWTHTIME = "growthTime";
    public static final String FIELD_PICTUREID = "pictureID";

    private String name;
    private boolean waterIntensive;
    private boolean nutrientIntensive;
    private int growthTime;
    private int pictureID;


    public Plant(String name, boolean waterIntensive, boolean nutrientIntensive, int growthTime, int pictureID){
        this.name = name;
        this.waterIntensive = waterIntensive;
        this.nutrientIntensive = nutrientIntensive;
        this.growthTime = growthTime;
        this.pictureID = pictureID;

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

    public int getGrowthTime() {
        return growthTime;
    }

    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }
}
