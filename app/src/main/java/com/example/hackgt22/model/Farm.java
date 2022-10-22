package com.example.hackgt22.model;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Farm {
    public static final String FIELD_PLANTROW1 = "plantRow1";
    public static final String FIELD_PLANTROW2 = "plantRow2";
    public static final String FIELD_WATERLEVEL = "waterLevel";

    private int[] plantRow1;
    private int[] plantRow2;
    private Map<Timestamp, Double> waterLevel;


    public Farm() {
        plantRow1 = new int[8];
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        ;

    }

}



