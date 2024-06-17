package com.example.commonapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.graphics.drawable.Drawable;

public abstract class Activity_PanelBase extends AppCompatActivity {

    protected EditText numberInput;
    protected TextView numberOutput;
    protected Spinner unitSpinner;
    protected Spinner unitSpinnerLower;
    protected Button swapButton;
    protected TextView upperText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        findViews();
        setupSpinners();
        setUpperText();
        applyBackground();


        swapButton.setOnClickListener(v -> performConversion());
    }

    private void findViews() {
        numberInput = findViewById(R.id.numberInput);
        numberOutput = findViewById(R.id.numberOutput);
        unitSpinner = findViewById(R.id.unitSpinner);
        unitSpinnerLower = findViewById(R.id.unitSpinnerLower);
        swapButton = findViewById(R.id.swapButton);
        upperText = findViewById(R.id.upperText);
    }

    protected abstract void setupSpinners();

    protected abstract void performConversion();

    protected abstract void setUpperText();

    protected abstract int getBackgroundDrawableResource();


    private void applyBackground() {
        int backgroundResource = getBackgroundDrawableResource();
        findViewById(R.id.root_layout).setBackground(ContextCompat.getDrawable(this, backgroundResource));
    }
    }