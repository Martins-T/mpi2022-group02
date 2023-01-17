package com.example.unitconverter;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton buttonWeight, buttonLength, buttonSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignId(buttonWeight, R.id.button_weight);
        assignId(buttonLength, R.id.button_length);
        assignId(buttonSpeed, R.id.button_speed);

        buttonWeight = (MaterialButton) findViewById(R.id.button_weight);
        buttonWeight.setOnClickListener(view -> openWeightScreen());

        buttonLength = (MaterialButton) findViewById(R.id.button_length);
        buttonLength.setOnClickListener(view -> openLengthScreen());

        buttonSpeed = (MaterialButton) findViewById(R.id.button_speed);
        buttonSpeed.setOnClickListener(view -> openSpeedScreen());

    }

    void assignId(MaterialButton button, int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    public void openWeightScreen() {
        Intent intent = new Intent(this,WeightActivity.class);
        startActivity(intent);
    }

    public void openLengthScreen() {
        Intent intent = new Intent(this,LengthActivity.class);
        startActivity(intent);
    }

    public void openSpeedScreen() {
        Intent intent = new Intent(this,SpeedActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
    }
}