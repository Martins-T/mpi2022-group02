package com.example.unitconverter;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LengthActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        assignId(buttonBack, R.id.button_back);

    }

    void assignId(MaterialButton button, int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
