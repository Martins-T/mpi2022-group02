package com.example.unitconverter;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class SpeedActivity extends AppCompatActivity {
    EditText inputKmH;
    TextView outputMih;
    MaterialButton buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        inputKmH = findViewById(R.id.input_number);
        outputMih = findViewById(R.id.output_number);

        buttonBack = (MaterialButton) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(view -> goBack());

        inputKmH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                convertKmHToMiH();
            }
        });

        inputKmH.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                inputKmH.setHint("");
            }
        });

    }

    private void convertKmHToMiH() {

        String inputKgStr = inputKmH.getText().toString();
        if (inputKgStr.isEmpty()) {
            outputMih.setText("");
            return;
        }
        double kilometers = Double.parseDouble(inputKgStr);

        double miles = kilometers * 0.62137;

        DecimalFormat df = new DecimalFormat("#.###");
        outputMih.setText(df.format(miles));
    }

    public void goBack() {
        this.finish();
    }
}
