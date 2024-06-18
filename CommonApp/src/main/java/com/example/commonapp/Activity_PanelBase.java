package com.example.commonapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public abstract class Activity_PanelBase extends AppCompatActivity {

    private static final String TAG = "Activity_PanelBase";

    protected EditText numberInput;
    protected TextView numberOutput;
    protected Spinner unitSpinner;
    protected Spinner unitSpinnerLower;
    protected ImageButton swapButton;
    protected TextView upperText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");
        setContentView(R.layout.activity_panel);

        findViews();
        setupSpinners();
        setUpperText();
        applyBackground();

        swapButton.setOnClickListener(v -> {
            Log.d(TAG, "swapButton clicked");
            performConversion();
        });
    }

    private void findViews() {
        numberInput = findViewById(R.id.numberInput);
        numberOutput = findViewById(R.id.numberOutput);
        unitSpinner = findViewById(R.id.unitSpinner);
        unitSpinnerLower = findViewById(R.id.unitSpinnerLower);
        swapButton = findViewById(R.id.swapButton);
        upperText = findViewById(R.id.upperText);
        Log.d(TAG, "Views found successfully");
    }

    protected abstract void setupSpinners();

    protected abstract void performConversion();

    protected abstract void setUpperText();

    protected abstract int getBackgroundDrawableResource();

    private void applyBackground() {
        int backgroundResource = getBackgroundDrawableResource();
        findViewById(R.id.root_layout).setBackground(ContextCompat.getDrawable(this, backgroundResource));
        Log.d(TAG, "Background applied");
    }
}
