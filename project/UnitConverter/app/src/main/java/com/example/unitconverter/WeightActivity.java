package com.example.unitconverter;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class WeightActivity extends AppCompatActivity {

    MaterialButton buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        buttonBack = (MaterialButton) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(view -> goBack());

    }



    public void goBack() {
        this.finish();
    }
}
