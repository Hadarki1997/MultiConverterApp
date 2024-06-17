package com.example.commonapp;

import android.content.Context;

public abstract class DataManagerBase {
    protected Context context;

    public DataManagerBase(Context context) {
        this.context = context;
    }

    public abstract void initializeData();
}