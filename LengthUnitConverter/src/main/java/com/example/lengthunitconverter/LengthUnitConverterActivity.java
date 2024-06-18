package com.example.lengthunitconverter;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.example.commonapp.Activity_PanelBase;

public class LengthUnitConverterActivity extends Activity_PanelBase {

    private static final String TAG = "LengthUnitConverterActivity";
    private LengthDataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate called");
        try {
            dataManager = new LengthDataManager(this);
            dataManager.initializeData();
            super.onCreate(savedInstanceState);
            Log.d(TAG, "LengthUnitConverterActivity created successfully");
        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate", e);
        }
    }

    @Override
    protected void setupSpinners() {
        Log.d(TAG, "setupSpinners called");
        try {
            String[] lengthUnits = {"Meters", "Kilometers", "Centimeters", "Millimeters"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lengthUnits);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            unitSpinner.setAdapter(adapter);
            unitSpinnerLower.setAdapter(adapter);
            Log.d(TAG, "Spinners setup with length units");
        } catch (Exception e) {
            Log.e(TAG, "Error setting up spinners", e);
        }
    }

    @Override
    protected void performConversion() {
        Log.d(TAG, "performConversion called");
        try {
            String fromUnit = unitSpinner.getSelectedItem().toString();
            String toUnit = unitSpinnerLower.getSelectedItem().toString();
            String inputValueString = numberInput.getText().toString();

            if (inputValueString.isEmpty()) {
                Toast.makeText(this, "Please enter a value to convert", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Input value is empty");
                return;
            }

            double inputValue = Double.parseDouble(inputValueString);
            double resultValue = dataManager.convertLength(inputValue, fromUnit, toUnit);
            numberOutput.setText(String.valueOf(resultValue));
            Log.d(TAG, "Conversion performed: " + inputValue + " " + fromUnit + " to " + resultValue + " " + toUnit);
        } catch (Exception e) {
            Log.e(TAG, "Error performing conversion", e);
        }
    }

    @Override
    protected void setUpperText() {
    upperText.setText("Length Converter");

    }

    @Override
    protected int getBackgroundDrawableResource() {
        return R.drawable.gradient_background_blue;
    }
}
