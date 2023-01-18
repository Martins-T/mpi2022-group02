package com.example.unitconverter;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class WeightActivity extends AppCompatActivity {

    EditText inputKg;
    TextView outputLb;
    MaterialButton buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        inputKg = findViewById(R.id.input_number);
        outputLb = findViewById(R.id.output_number);

        buttonBack = (MaterialButton) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(view -> goBack());

        inputKg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                convertKilogramsToPounds();
            }
        });

        inputKg.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                inputKg.setHint("");
            }
        });

    }

    private void convertKilogramsToPounds() {

        String inputKgStr = inputKg.getText().toString();
        if (inputKgStr.isEmpty()) {
            outputLb.setText("");
            return;
        }
        double kilograms = Double.parseDouble(inputKgStr);

        double pounds = kilograms * 2.20462;

        DecimalFormat df = new DecimalFormat("#.###");
        outputLb.setText(df.format(pounds));
    }

    public void goBack() {
        this.finish();
    }
}
