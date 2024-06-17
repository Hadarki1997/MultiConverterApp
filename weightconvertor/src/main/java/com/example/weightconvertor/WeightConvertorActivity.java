package com.example.weightconvertor;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.example.commonapp.Activity_PanelBase;

public abstract class WeightConvertorActivity extends Activity_PanelBase {

    private WeightDataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManager = new WeightDataManager(this);
        dataManager.initializeData();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setupSpinners() {
        String[] weightUnits = {"Kilograms", "Grams", "Pounds", "Ounces"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weightUnits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitSpinner.setAdapter(adapter);
        unitSpinnerLower.setAdapter(adapter);
    }

    @Override
    protected void performConversion() {
        String fromUnit = unitSpinner.getSelectedItem().toString();
        String toUnit = unitSpinnerLower.getSelectedItem().toString();
        String inputValueString = numberInput.getText().toString();

        if (inputValueString.isEmpty()) {
            Toast.makeText(this, "Please enter a value to convert", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputValue = Double.parseDouble(inputValueString);
        double resultValue = dataManager.convertWeight(inputValue, fromUnit, toUnit);
        numberOutput.setText(String.valueOf(resultValue));
    }

    @Override
    protected void setUpperText() {
        upperText.setText("Weight Conversion");
    }

    @Override
    protected int getBackgroundDrawableResource() {
        return R.drawable.gradient_background_red;
    }

}
