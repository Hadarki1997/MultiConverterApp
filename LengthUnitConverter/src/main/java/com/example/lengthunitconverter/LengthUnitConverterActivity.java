package com.example.lengthunitconverter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.example.commonapp.Activity_PanelBase;

public class LengthUnitConverterActivity extends Activity_PanelBase {

    private LengthDataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManager = new LengthDataManager(this);
        dataManager.initializeData();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setupSpinners() {
        String[] lengthUnits = {"Meters", "Kilometers", "Centimeters", "Millimeters"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lengthUnits);
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

        try {
            double inputValue = Double.parseDouble(inputValueString);
            double resultValue = dataManager.convertLength(inputValue, fromUnit, toUnit);
            numberOutput.setText(String.valueOf(resultValue));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input value", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error during conversion", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void setUpperText() {
        upperText.setText("Length Conversion");
    }

    @Override
    protected int getBackgroundDrawableResource() {
        return R.drawable.gradient_background_blue;
    }
}
