package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTv, solutionTv;
    MaterialButton buttonMC, buttonMR, buttonMS;
    MaterialButton buttonDivide, buttonMultiply, buttonSubtract, buttonAdd, buttonEquals;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    MaterialButton buttonC, buttonDot;

    private double memoryValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

        assignId(buttonMC, R.id.button_mc);
        assignId(buttonMR, R.id.button_mr);
        assignId(buttonMS, R.id.button_ms);
        assignId(buttonDivide, R.id.button_divide);
        assignId(buttonMultiply, R.id.button_multiply);
        assignId(buttonSubtract, R.id.button_subtract);
        assignId(buttonAdd, R.id.button_add);
        assignId(buttonEquals, R.id.button_equals);
        assignId(button0, R.id.button_0);
        assignId(button1, R.id.button_1);
        assignId(button2, R.id.button_2);
        assignId(button3, R.id.button_3);
        assignId(button4, R.id.button_4);
        assignId(button5, R.id.button_5);
        assignId(button6, R.id.button_6);
        assignId(button7, R.id.button_7);
        assignId(button8, R.id.button_8);
        assignId(button9, R.id.button_9);
        assignId(buttonC, R.id.button_c);
        assignId(buttonDot, R.id.button_dot);
    }

    void assignId(MaterialButton button, int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    private void updateMemory(double value) {
        memoryValue = value;
    }

    private void clearMemory() {
        memoryValue = 0;
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();

        if(buttonText.equals("C")) {
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        if (buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            return;
        }

        if(buttonText.equals("MS")) {
            updateMemory(Double.parseDouble(resultTv.getText().toString()));
            return;
        }

        if(buttonText.equals("MR")) {
            String memoryText = String.valueOf(memoryValue);
            if(memoryText.endsWith(".0")) {
                memoryText = memoryText.substring(0, memoryText.length() - 2);
            }
            dataToCalculate = dataToCalculate + memoryText;
            solutionTv.setText(dataToCalculate);
            String finalResult = getResult(dataToCalculate);
            if(!finalResult.equals("Error")){
                resultTv.setText(finalResult);
            }
            return;
        }

        if(buttonText.equals("MC")) {
            clearMemory();
            return;
        }

        dataToCalculate = dataToCalculate+buttonText;
        solutionTv.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if(!finalResult.equals("Error")){
            resultTv.setText(finalResult);
        }
    }

    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        } catch (Exception e){
            return "Error";
        }
    }
}