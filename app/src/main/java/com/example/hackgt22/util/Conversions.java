package com.example.hackgt22.util;

import com.google.firebase.Timestamp;

import java.text.DateFormat;
import java.util.Date;

public class Conversions {
    public static String plantFromCode(int code){
        switch(code){
            case 1:
                return "Arugula";
            case 2:
                return "Spinach";
            case 3:
                return "Basil";
            case 4:
                return "Parsley";
            default:
                return "None";
        }
    }

    public static int codeFromPlant(String plant){
        switch(plant){
            case "Arugula":
                return 1;
            case "Spinach":
                return 2;
            case "Basil":
                return 3;
            case "Parsley":
                return 4;
            default:
                return 0;
        }
    }
}
