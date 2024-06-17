package com.example.commonapp;

import java.util.HashMap;
import java.util.Map;

public class ConversionManager {

    private static final Map<String, Double> lengthConversionMap = new HashMap<>();
    private static final Map<String, Double> weightConversionMap = new HashMap<>();
    private static final Map<String, Map<String, Double>> conversionMap = new HashMap<>();

    static {
        // Length conversion factors relative to meters
        lengthConversionMap.put("Meters", 1.0);
        lengthConversionMap.put("Kilometers", 1000.0);
        lengthConversionMap.put("Centimeters", 0.01);
        lengthConversionMap.put("Millimeters", 0.001);

        // Weight conversion factors relative to kilograms
        weightConversionMap.put("Kilograms", 1.0);
        weightConversionMap.put("Grams", 0.001);
        weightConversionMap.put("Pounds", 0.453592);
        weightConversionMap.put("Ounces", 0.0283495);

        // Adding to the main conversion map
        conversionMap.put("Length", lengthConversionMap);
        conversionMap.put("Weight", weightConversionMap);
    }

    public static double convert(double value, String fromUnit, String toUnit, String type) {
        if (!conversionMap.containsKey(type)) {
            throw new IllegalArgumentException("Invalid conversion type");
        }

        Map<String, Double> map = conversionMap.get(type);

        if (!map.containsKey(fromUnit) || !map.containsKey(toUnit)) {
            throw new IllegalArgumentException("Invalid units for conversion");
        }

        double fromFactor = map.get(fromUnit);
        double toFactor = map.get(toUnit);
        return value * (fromFactor / toFactor);
    }
}
