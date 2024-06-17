package com.example.lengthunitconverter;

import android.content.Context;
import com.example.commonapp.DataManagerBase;
import com.example.commonapp.ConversionManager;

public class LengthDataManager extends DataManagerBase {

    public LengthDataManager(Context context) {
        super(context);
    }

    @Override
    public void initializeData() {
    }

    public double convertLength(double value, String fromUnit, String toUnit) {
        return ConversionManager.convert(value, fromUnit, toUnit, "Length");
    }
}
