package com.example.weightconvertor;

import android.content.Context;
import com.example.commonapp.DataManagerBase;
import com.example.commonapp.ConversionManager;

public class WeightDataManager extends DataManagerBase {

    public WeightDataManager(Context context) {
        super(context);
    }

    @Override
    public void initializeData() {
    }

    public double convertWeight(double value, String fromUnit, String toUnit) {
        return ConversionManager.convert(value, fromUnit, toUnit, "Weight");
    }
}
