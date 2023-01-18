package com.example.unitconverter;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class LengthActivity extends AppCompatActivity {

    EditText inputKm;
    TextView outputMi;
    MaterialButton buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        inputKm = findViewById(R.id.input_number);
        outputMi = findViewById(R.id.output_number);

        buttonBack = (MaterialButton) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(view -> goBack());

        inputKm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                convertKilometersToMiles();
            }
        });

        inputKm.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                inputKm.setHint("");
            }
        });

    }

    private void convertKilometersToMiles() {

        String inputKgStr = inputKm.getText().toString();
        if (inputKgStr.isEmpty()) {
            outputMi.setText("");
            return;
        }
        double kilometers = Double.parseDouble(inputKgStr);

        double miles = kilometers * 0.62137;

        DecimalFormat df = new DecimalFormat("#.###");
        outputMi.setText(df.format(miles));
    }

    public void goBack() {
        this.finish();
    }
}
